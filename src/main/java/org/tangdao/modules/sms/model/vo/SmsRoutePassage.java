package org.tangdao.modules.sms.model.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.tangdao.common.utils.StringUtils;
import org.tangdao.modules.paas.model.vo.MobileCatagory;
import org.tangdao.modules.sms.model.domain.SmsPassageAccess;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO 用户路由通道信息
 * 
 * @author zhengying
 * @version V1.0
 * @date 2016年10月11日 上午11:57:29
 */
@Getter
@Setter
public class SmsRoutePassage implements Serializable {

    private static final long              serialVersionUID = 7468557377818340963L;
    private String                        userCode;

    // 通道手机号码信息（手机号码以逗号分割）
    private Map<String, String>           passageMobiles   = new HashMap<>();
    // 未找到对应通道手机号码集合
    private Set<String>                    unkonwnMobiles   = new HashSet<>();
    // 通道信息
    private Map<String, SmsPassageAccess> passaegAccesses  = new HashMap<>();

    // 错误信息
    private String                         errorMessage;

    public Map<String, String> getPassageMobiles() {
        return passageMobiles;
    }

    public void setPassageMobiles(Map<String, String> passageMobiles) {
        this.passageMobiles = passageMobiles;
    }

    public Map<String, SmsPassageAccess> getPassaegAccesses() {
        return passaegAccesses;
    }

    public void setPassaegAccesses(Map<String, SmsPassageAccess> passaegAccesses) {
        this.passaegAccesses = passaegAccesses;
    }

    /**
     * TODO 加入通道ID和手机号码对应关系(即同一个通道下面拥有手机号码集合信息)
     * 
     * @param cmcp 运营商
     * @param passageId
     * @param mobiles
     */
    public void addPassageMobilesMapping(String passageId, String mobiles) {
        if (MapUtils.isEmpty(passageMobiles) || !passageMobiles.containsKey(passageId)) {
            passageMobiles.put(passageId, mobiles);
            return;
        }

        // 拼接手机号码
        passageMobiles.put(passageId, passageMobiles.get(passageId) + MobileCatagory.MOBILE_SPLIT_CHARCATOR + mobiles);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Set<String> getUnkonwnMobiles() {
        return unkonwnMobiles;
    }

    public void setUnkonwnMobiles(Set<String> unkonwnMobiles) {
        this.unkonwnMobiles = unkonwnMobiles;
    }

    public void addUnknownMobiles(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return;
        }

        this.unkonwnMobiles.addAll(Arrays.asList(mobile.split(MobileCatagory.MOBILE_SPLIT_CHARCATOR)));
    }

}
