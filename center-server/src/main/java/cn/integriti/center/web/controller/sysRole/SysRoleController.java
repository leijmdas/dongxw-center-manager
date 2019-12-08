package cn.integriti.center.web.controller.sysRole;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.integriti.center.biz.sys.domain.SysRole;
import cn.integriti.center.biz.sys.service.SysRoleService;
import cn.integriti.center.core.enums.StatusEnum;
import cn.integriti.center.web.controller.AbstractController;
import cn.integriti.center.web.core.JsonResult;

/**
 * 企业
 * 
 * @author zz
 *
 */
@RequestMapping("/sys/role")
@Controller
public class SysRoleController extends AbstractController {

	@Autowired
	private SysRoleService sysRoleService;

	@RequestMapping(value = "query", method = RequestMethod.POST)
	public @ResponseBody JsonResult query(@RequestBody SysRole.QueryParam qp) {
		List<SysRole> list = this.sysRoleService.findByQueryParam(qp);
		return JsonResult.success().setData(list).setTotal(this.sysRoleService.countByQueryParam(qp));
	}

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody SysRole save(@RequestBody SysRole entity) {
		if (entity.getId() == null) {
			entity.setStatus(StatusEnum.ENABLE.getValue());
			this.sysRoleService.save(entity);
		} else {
			this.update(entity);
		}
		return entity;
	}

	/**
	 * 更新
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public @ResponseBody SysRole update(@RequestBody SysRole entity) {

		SysRole tmp = this.sysRoleService.findById(entity.getId());
		tmp.setRoleCode(entity.getRoleCode());
		tmp.setRoleName(entity.getRoleName());
		tmp.setType(entity.getType());
		tmp.setRemark(entity.getRemark());
		tmp.setStatus(entity.getStatus());
		this.sysRoleService.update(tmp);
		return tmp;
	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody SysRole get(@PathVariable("id") Integer id) {
		SysRole tmp = this.sysRoleService.findById(id);
		return tmp;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public @ResponseBody JsonResult delete(@PathVariable("id") Integer id) {
		this.sysRoleService.deleteById(id);
		return JsonResult.success();
	}

	@RequestMapping(value = "assignRoleResources/{id}", method = RequestMethod.POST)
	public @ResponseBody JsonResult assignRoleResources(@PathVariable("id") Integer id, @RequestBody List<Integer> resIds) {
		this.sysRoleService.assignRoleResources(id, resIds);
		return JsonResult.success();
	}

	@RequestMapping(value = "findResourceIds/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Integer> findResourceIds(@PathVariable("id") Integer id) {
		return this.sysRoleService.findResourceIds(id);
	}

	@RequestMapping(value = "microList", method = RequestMethod.POST)
	public @ResponseBody JsonResult findMicroList(@RequestBody SysRole.QueryParam qp) {
		List<SysRole> list = this.sysRoleService.findMicroList(qp);
		return JsonResult.success().setData(list.stream().map(entity -> {
			return new HashMap<String, Object>() {
				private static final long serialVersionUID = 1L;
				{
					this.put("id", entity.getId());
					this.put("roleName", entity.getRoleName());
					this.put("roleCode", entity.getRoleCode());
					this.put("status", entity.getStatus());
				}
			};
		}).collect(Collectors.toList()));
	}

}
