package cn.integriti.center.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.integriti.center.biz.sys.domain.SysShortlink;
import cn.integriti.center.biz.sys.service.SysShortlinkService;
import cn.integriti.center.core.enums.StatusEnum;
import cn.integriti.center.core.util.BeanMapper;
import cn.integriti.center.web.core.JsonResult;

@Controller
@RequestMapping("/sys/shortlink")
public class SysShortlinkController {
	@Autowired
	private SysShortlinkService sysShortlinkService;


	@RequestMapping(value = "query", method = RequestMethod.POST)
	public @ResponseBody JsonResult query(@RequestBody SysShortlink.QueryParam qp) {
		List<SysShortlink> list = this.sysShortlinkService.findByQueryParam(qp);
		return JsonResult.success().setData(list).setTotal(this.sysShortlinkService.countByQueryParam(qp));
	}

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody SysShortlink save(@RequestBody SysShortlink entity) {
		if (entity.getId() == null) {
			entity.setStatus(StatusEnum.ENABLE.getValue().intValue());
			this.sysShortlinkService.save(entity);
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
	public @ResponseBody SysShortlink update(@RequestBody SysShortlink entity) {

		SysShortlink tmp = this.sysShortlinkService.findById(entity.getId());
		BeanMapper.getInstance().map(entity, tmp);
		this.sysShortlinkService.update(tmp);
		return tmp;
	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody SysShortlink getUser(@PathVariable("id") Integer id) {
		SysShortlink tmp = this.sysShortlinkService.findById(id);
		return tmp;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public @ResponseBody JsonResult delete(@PathVariable("id") Integer id) {
		this.sysShortlinkService.deleteById(id);
		return JsonResult.success();
	}
}
