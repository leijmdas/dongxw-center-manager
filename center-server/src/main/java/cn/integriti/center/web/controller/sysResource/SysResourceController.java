package cn.integriti.center.web.controller.sysResource;

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

import cn.integriti.center.biz.sys.domain.SysResource;
import cn.integriti.center.biz.sys.domain.SysResourceGroup;
import cn.integriti.center.biz.sys.service.SysResourceService;
import cn.integriti.center.web.controller.AbstractController;
import cn.integriti.center.web.core.JsonResult;

/**
 * 企业
 * 
 * @author zz
 *
 */
@RequestMapping("/sys/resource")
@Controller
public class SysResourceController extends AbstractController {

	@Autowired
	private SysResourceService sysResourceService;

	@RequestMapping(value = "query", method = RequestMethod.POST)
	public @ResponseBody JsonResult query(@RequestBody SysResource.QueryParam qp) {
		List<SysResource> list = this.sysResourceService.findByQueryParam(qp);
		return JsonResult.success().setData(list).setTotal(this.sysResourceService.countByQueryParam(qp));
	}

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
//	@RequestMapping(value = "save", method = RequestMethod.POST)
//	public @ResponseBody SysResource save(@RequestBody SysResource entity) {
//		if (entity.getId() == null) {
//			entity.setStatus(StatusEnum.ENABLE.getValue());
//			this.sysResourceService.save(entity);
//		} else {
//			this.update(entity);
//		}
//		return entity;
//	}

	/**
	 * 更新
	 * 
	 * @param entity
	 * @return
	 */
//	@RequestMapping(value = "update", method = RequestMethod.POST)
//	public @ResponseBody SysResource update(@RequestBody SysResource entity) {
//
//		SysResource tmp = this.sysResourceService.findById(entity.getId());
//		tmp.setResourceCode(entity.getResourceCode());
//		tmp.setResourceName(entity.getResourceName());
//		tmp.setRemark(entity.getRemark());
//		tmp.setStatus(entity.getStatus());
//		this.sysResourceService.update(tmp);
//		return tmp;
//	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody SysResource get(@PathVariable("id") Integer id) {
		SysResource tmp = this.sysResourceService.findById(id);
		return tmp;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public @ResponseBody JsonResult delete(@PathVariable("id") Integer id) {
		this.sysResourceService.deleteById(id);
		return JsonResult.success();
	}

	@RequestMapping(value = "queryGroupAndResources", method = RequestMethod.POST)
	public @ResponseBody List<SysResourceGroup> queryGroupAndResources() {
		return this.sysResourceService.queryGroupAndResources();
	}

	@RequestMapping(value = "microList", method = RequestMethod.POST)
	public @ResponseBody JsonResult findMicroList(@RequestBody SysResource.QueryParam qp) {
		List<SysResource> list = this.sysResourceService.findMicroList(qp);
		return JsonResult.success().setData(list.stream().map(entity -> {
			return new HashMap<String, Object>() {
				private static final long serialVersionUID = 1L;
				{
					this.put("id", entity.getId());
					this.put("ResName", entity.getResName());
					this.put("ResCode", entity.getResCode());
					this.put("type", entity.getType());
					this.put("status", entity.getStatus());
				}
			};
		}).collect(Collectors.toList()));
	}

}
