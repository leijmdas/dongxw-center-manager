package cn.kunlong.center.web.controller.sysOrg;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kunlong.center.biz.sys.domain.SysOrg;
import cn.kunlong.center.biz.sys.service.SysOrgService;
import cn.kunlong.center.core.enums.StatusEnum;
import cn.kunlong.center.core.support.tree.TreeNode;
import cn.kunlong.center.web.controller.AbstractController;
import cn.kunlong.center.web.core.JsonResult;

/**
 * 企业
 * 
 * @author zz
 *
 */
@RequestMapping("/sys/org")
@Controller
public class SysOrgController extends AbstractController {

	@Autowired
	private SysOrgService sysOrgService;

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody SysOrg save(@RequestBody SysOrg entity) {
		if (entity.getId() == null) {
			entity.setStatus(StatusEnum.ENABLE.getValue());
			this.sysOrgService.save(entity);
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
	public @ResponseBody SysOrg update(@RequestBody SysOrg entity) {

		SysOrg tmp = this.sysOrgService.findById(entity.getId());
		tmp.setRemark(entity.getRemark());
		tmp.setStatus(entity.getStatus());
		tmp.setPid(entity.getPid());
		tmp.setOrgName(entity.getOrgName());
		this.sysOrgService.update(tmp);
		return tmp;
	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody SysOrg get(@PathVariable("id") Integer id) {
		SysOrg tmp = this.sysOrgService.findById(id);
		return tmp;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public @ResponseBody JsonResult delete(@PathVariable("id") Integer id) {
		this.sysOrgService.deleteById(id);
		return JsonResult.success();
	}

	@RequestMapping(value = "tree", method = RequestMethod.GET)
	public @ResponseBody TreeNode<SysOrg> tree(@RequestParam("corpId") Integer corpId) {
		TreeNode<SysOrg> tmp = this.sysOrgService.getRootNode(corpId);
		return tmp;
	}

	@RequestMapping(value = "microList", method = RequestMethod.POST)
	public @ResponseBody JsonResult findMicroList(@RequestBody SysOrg.QueryParam qp) {
		List<SysOrg> list = this.sysOrgService.findMicroList(qp);
		return JsonResult.success().setData(list.stream().map(entity -> {
			return new HashMap<String, Object>() {
				private static final long serialVersionUID = 1L;
				{
					this.put("id", entity.getId());
					this.put("orgName", entity.getOrgName());
					this.put("orderNum", entity.getOrderNum());
					this.put("status", entity.getStatus());
				}
			};
		}).collect(Collectors.toList()));
	}

}
