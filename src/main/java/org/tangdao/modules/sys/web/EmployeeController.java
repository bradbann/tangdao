package org.tangdao.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangdao.common.config.Global;
import org.tangdao.common.suports.BaseController;
import org.tangdao.modules.sys.model.domain.Employee;
import org.tangdao.modules.sys.model.vo.EmpUser;
import org.tangdao.modules.sys.service.IEmployeeService;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 员工Controller
 * @author ruyang
 * @version 2019-12-16
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/employee")
public class EmployeeController extends BaseController {

	@Autowired
	private IEmployeeService employeeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Employee get(String empCode, boolean isNewRecord) {
		return employeeService.get(empCode, isNewRecord);
	}
	
	/**
	 * 机构管理主页面
	 */
	@RequestMapping(value = "index")
	public String index(Model model) {
		return "modules/sys/employeeIndex";
	}
	
	/**
	 * 查询列表
	 */
//	@PreAuthorize("hasAuthority('sys:employee:view')")
	@RequestMapping(value = {"list", ""})
	public String list(Employee employee, Model model) {
		model.addAttribute("employee", employee);
		return "modules/sys/employeeList";
	}
	
	/**
	 * 查询列表数据
	 */
//	@PreAuthorize("hasAuthority('sys:employee:view')")
	@RequestMapping(value = "listData")
	public @ResponseBody IPage<EmpUser> listData(Employee employee, HttpServletRequest request, HttpServletResponse response) {
		EmpUser empUser = new EmpUser();
		return employeeService.findEmpUserPage(employee.getPage(), empUser);
	}

	/**
	 * 查看编辑表单
	 */
//	@PreAuthorize("hasAuthority('sys:employee:view')")
	@RequestMapping(value = "form")
	public String form(Employee employee, Model model) {
		model.addAttribute("employee", employee);
		return "modules/sys/employeeForm";
	}

	/**
	 * 保存员工
	 */
	@PreAuthorize("hasAuthority('sys:employee:edit')")
	@PostMapping(value = "save")
	public @ResponseBody String save(@Validated Employee employee) {
		employeeService.saveOrUpdate(employee);
		return renderResult(Global.TRUE, "保存成功！");
	}
	
	/**
	 * 停用员工
	 */
	@PreAuthorize("hasAuthority('sys:employee:edit')")
	@RequestMapping(value = "disable")
	public @ResponseBody String disable(Employee employee) {
		employee.setStatus(Employee.STATUS_DISABLE);
		employeeService.updateById(employee);
		return renderResult(Global.TRUE, "停用成功");
	}
	
	/**
	 * 启用员工
	 */
	@PreAuthorize("hasAuthority('sys:employee:edit')")
	@RequestMapping(value = "enable")
	public @ResponseBody String enable(Employee employee) {
		employee.setStatus(Employee.STATUS_NORMAL);
		employeeService.updateById(employee);
		return renderResult(Global.TRUE, "启用成功");
	}
	
	/**
	 * 删除员工
	 */
	@PreAuthorize("hasAuthority('sys:employee:edit')")
	@RequestMapping(value = "delete")
	public @ResponseBody String delete(Employee employee) {
		employeeService.deleteById(employee);
		return renderResult(Global.TRUE, "删除成功！");
	}
	
}