package cn.kunlong.center.web.controller.currentCorp;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import cn.kunlong.center.api.model.SysCorpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.sys.domain.SysCorp;
import cn.kunlong.center.biz.sys.service.SysCorpService;
import cn.kunlong.center.core.enums.StatusEnum;
import cn.kunlong.center.core.util.BeanMapper;
import cn.kunlong.center.web.controller.AbstractController;
import cn.kunlong.center.web.core.JsonResult;

/**
 * 企业
 * 
 * @author zz
 *
 */
@RequestMapping("/sys/corp")
@Controller
public class SysCorpController extends AbstractController  {

	@Autowired
	private SysCorpService sysCorpService;

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody SysCorp save(@RequestBody SysCorp entity) {
		if (entity.getId() == null) {
			entity.setStatus(StatusEnum.ENABLE.getValue());

			this.sysCorpService.save(entity);
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
	@ResponseBody
	public SysCorp update(@RequestBody SysCorp entity) {

		SysCorp tmp = this.sysCorpService.findById(entity.getId());
		tmp.setRemark(entity.getRemark());
		tmp.setStatus(entity.getStatus());
		tmp.setAddress(entity.getAddress());
		tmp.setAuditOn(entity.getAuditOn());
		tmp.setContactMan(entity.getContactMan());
		tmp.setContactNo(entity.getContactNo());
		tmp.setCorpName(entity.getCorpName());
		tmp.setWebsite(entity.getWebsite());
		this.sysCorpService.update(tmp);
		return tmp;
	}

	@RequestMapping("get")
	@ResponseBody
	public SysCorpDTO get() {
		return this.getCorp(CurrentRequestContext.getCurrentCorpId());
	}

	public SysCorpDTO getCorp(Integer id) {
		SysCorp tmp = this.sysCorpService.findById(id);
		SysCorpDTO dto = BeanMapper.getInstance().map(tmp, SysCorpDTO.class);
		return dto;
	}

	@RequestMapping(value = "microList", method = RequestMethod.POST)
	public @ResponseBody JsonResult findMicroList(@RequestBody SysCorp.QueryParam qp) {
		List<SysCorp> list = this.sysCorpService.findMicroList(qp);
		return JsonResult.success().setData(list.stream().map(entity -> {
			return new HashMap<String, Object>() {
				private static final long serialVersionUID = 1L;
				{
					this.put("id", entity.getId());
					this.put("corpCode", entity.getCorpCode());
					this.put("corpName", entity.getCorpName());
					this.put("status", entity.getStatus());
				}
			};
		}).collect(Collectors.toList()));
	}

}
