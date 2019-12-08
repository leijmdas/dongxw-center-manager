package cn.integriti.center.web.controller.sysAccount;

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

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.sys.domain.SysAccount;
import cn.integriti.center.biz.sys.service.SysAccountService;
import cn.integriti.center.core.enums.StatusEnum;
import cn.integriti.center.web.controller.AbstractController;
import cn.integriti.center.web.core.JsonResult;

/**
 * 企业
 * 
 * @author zz
 *
 */
@RequestMapping("/sys/account")
@Controller
public class SysAccountController extends AbstractController {

	@Autowired
	private SysAccountService sysAccountService;

	@RequestMapping(value = "query", method = RequestMethod.POST)
	public @ResponseBody JsonResult query(@RequestBody SysAccount.QueryParam qp) {
		List<SysAccount> list = this.sysAccountService.findByQueryParam(qp);
		return JsonResult.success().setData(list).setTotal(this.sysAccountService.countByQueryParam(qp));
	}

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody SysAccount save(@RequestBody SysAccount entity) {
		if (entity.getId() == null) {
			entity.setStatus(StatusEnum.ENABLE.getValue());
			this.sysAccountService.save(entity);
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
	public @ResponseBody SysAccount update(@RequestBody SysAccount entity) {

		SysAccount tmp = this.sysAccountService.findById(entity.getId());
		tmp.setRemark(entity.getRemark());
		tmp.setStatus(entity.getStatus());
//		tmp.setPid(entity.getPid());
//		tmp.setAccountName(entity.getAccountName());
		this.sysAccountService.update(tmp);
		return tmp;
	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody SysAccount getAccount(@PathVariable("id") Integer id) {
		SysAccount tmp = this.sysAccountService.findById(id);
		return tmp;
	}

	@RequestMapping(value = "microList", method = RequestMethod.POST)
	public @ResponseBody JsonResult findMicroList(@RequestBody SysAccount.QueryParam qp) {
		List<SysAccount> list = this.sysAccountService.findMicroList(qp);
		return JsonResult.success().setData(list.stream().map(entity -> {
			return new HashMap<String, Object>() {
				private static final long serialVersionUID = 1L;
				{
					this.put("id", entity.getId());
					this.put("realName", entity.getRealName());
					this.put("telNo", entity.getTelNo());
					this.put("status", entity.getStatus());
				}
			};
		}).collect(Collectors.toList()));
	}
	@RequestMapping(value = "modifyPwd", method = RequestMethod.POST)
	public @ResponseBody Boolean modifyPwd(@RequestBody ModifyPwdFormBean bean) {
		this.sysAccountService.modifyPwd(CurrentRequestContext.getOpBy(),bean.getOldPass(),bean.getNewPass());
		return true;
	}
	static class ModifyPwdFormBean {
		private String newPass;
		private String oldPass;
		public String getNewPass() {
			return newPass;
		}
		public void setNewPass(String newPass) {
			this.newPass = newPass;
		}
		public String getOldPass() {
			return oldPass;
		}
		public void setOldPass(String oldPass) {
			this.oldPass = oldPass;
		}
		
	}
}
