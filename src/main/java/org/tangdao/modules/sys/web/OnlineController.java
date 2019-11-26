package org.tangdao.modules.sys.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.RedisOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.session.Session;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;
import org.tangdao.common.utils.DateUtils;
import org.tangdao.common.utils.ListUtils;
import org.tangdao.common.utils.MapUtils;
import org.tangdao.common.utils.ObjectUtils;
import org.tangdao.common.utils.TimeUtils;
import org.tangdao.modules.sys.model.domain.User;

@Controller
@RequestMapping(value = "${adminPath}/sys/online")
public class OnlineController extends BaseController{
	
	@Autowired
    public SpringSessionBackedSessionRegistry<Session> sessionRegistry;

	@Autowired
	public RedisIndexedSessionRepository sessionRepository;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	/**
	 * 在线用户数
	 * @param request
	 * @param response
	 * @author ThinkGem
	 */
	@RequestMapping(value = "count")
	public @ResponseBody Integer count(HttpServletRequest request, HttpServletResponse response) {
		return sessionIds().size();
	}

	/**
	 * 在线用户列表
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping(value = "list")
	public String list(Model model) {
		return "modules/sys/onlineList";
	}
	
	/**
	 * 在线用户列表数据
	 * @param request
	 * @param response
	 * @author ThinkGem
	 */
	@RequestMapping(value = "listData")
	public @ResponseBody List<Object> listData(String sessionId,  String username) {
		List<String> sessionIds = sessionIds();
		long currentTime = System.currentTimeMillis();
		List<Object> list = ListUtils.newArrayList();
		for (Serializable sid : sessionIds) {
			Map<String, Object> map = MapUtils.newLinkedHashMap();
			BoundHashOperations<String, String, Object> hashOperations = this.stringRedisTemplate.boundHashOps(RedisIndexedSessionRepository.DEFAULT_NAMESPACE + ":sessions:" + sid);
			Map<String, Object> entries = hashOperations.entries();
			SessionInformation sessionInformation = this.sessionRegistry.getSessionInformation((String)sid);
			SecurityContext securityContext = (SecurityContext) entries.get("sessionAttr:SPRING_SECURITY_CONTEXT");
			if(securityContext!=null) {
				Authentication authentication = securityContext.getAuthentication();
				if(authentication!=null && authentication.getPrincipal() instanceof User) {
					User user = (User)authentication.getPrincipal();
					map.put("userCode", user.getUserCode());
					map.put("username", user.getUsername());
					map.put("nickname", user.getNickname());
					map.put("userType", user.getUserType());
				}
			}
			if(sessionInformation!=null) {
				map.put("id", sessionInformation.getSessionId());
				map.put("lastAccessTime", DateUtils.formatDateTime(sessionInformation.getLastRequest()));
				map.put("timeout", TimeUtils.formatDateAgo(ObjectUtils.toLong(entries.get("maxInactiveInterval"))*1000-(currentTime-sessionInformation.getLastRequest().getTime())));
			}
			map.put("startTimestamp", DateUtils.formatDateTime(new Date(ObjectUtils.toLong(entries.get("creationTime")))));
			map.put("host", entries.get("sessionAttr:host"));
			map.put("deviceName", entries.get("sessionAttr:deviceName"));
			list.add(map);
		}
		return list;
	}
	
	/**
	 * 提出在线用户
	 * @author ThinkGem
	 */
	@RequestMapping(value = "tickOut")
	public @ResponseBody String tickOut(String sessionId) {
		
		Session session = sessionRepository.findById(sessionId);
		if (session != null){
			sessionRepository.deleteById(sessionId);
			clearSession(sessionId);
			sessionRepository.cleanupExpiredSessions();
			return renderResult(Global.TRUE, "踢出已成功！");
		}
		
		if(sessionId!=null) {
			clearSession(sessionId);
		}
		return renderResult(Global.FALSE, "踢出失败，没有找到该在线用户！");
	}
	
	private List<String> sessionIds(){
		String key = RedisIndexedSessionRepository.DEFAULT_NAMESPACE + ":index:"+ RedisIndexedSessionRepository.PRINCIPAL_NAME_INDEX_NAME;
		List<String> kt = ListUtils.newArrayList();
		this.stringRedisTemplate.keys(key+":*").forEach((t)->{
			kt.add(t);
		});
		List<String> sessionIds = ListUtils.newArrayList();
		for (String principalKey : kt) {
			this.stringRedisTemplate.boundSetOps(principalKey).members().forEach((t)->{
				sessionIds.add((String)t);
			});
		}
		return sessionIds;
	}
	
	private void clearSession(String sessionId) {
		this.stringRedisTemplate.boundValueOps("spring:session:sessions:"+sessionId).expire(0, TimeUnit.SECONDS);
		this.stringRedisTemplate.boundValueOps("spring:session:sessions:expires:"+sessionId).expire(0, TimeUnit.SECONDS);
	}
	
}
