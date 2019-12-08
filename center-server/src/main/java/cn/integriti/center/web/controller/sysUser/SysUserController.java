package cn.integriti.center.web.controller.sysUser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.integriti.center.api.model.SysUserDTO;
import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.sys.domain.SysUser;
import cn.integriti.center.biz.sys.service.SysAccountService;
import cn.integriti.center.biz.sys.service.SysOrgService;
import cn.integriti.center.biz.sys.service.SysUserService;
import cn.integriti.center.core.enums.StatusEnum;
import cn.integriti.center.core.util.StringHelper;
import cn.integriti.center.web.controller.AbstractController;
import cn.integriti.center.web.core.JsonResult;

/**
 * 企业
 * 
 * @author zz
 *
 */
@RequestMapping("/sys/user")
@Controller
public class SysUserController extends AbstractController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysAccountService sysAccountService;
	
	@Autowired
	private SysOrgService sysOrgService;

	@RequestMapping(value = "query", method = RequestMethod.POST)
	public @ResponseBody JsonResult query(@RequestBody SysUser.QueryParam qp) {
		List<SysUser> list = this.sysUserService.findByQueryParam(qp);
		return JsonResult.success().setData(list).setTotal(this.sysUserService.countByQueryParam(qp));
	}

	/**
	 * 保存
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody SysUser save(@RequestBody SysUser entity) {
		if (entity.getId() == null) {
			entity.setStatus(StatusEnum.ENABLE.getValue());
			this.sysUserService.save(entity);
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
	public @ResponseBody SysUser update(@RequestBody SysUser entity) {

		SysUser tmp = this.sysUserService.findById(entity.getId());
//		tmp.setOrgId(entity.getOrgId());
//		tmp.setEmployeeNo(entity.getEmployeeNo());
//		tmp.setEmail(entity.getEmail());
//		tmp.setRemark(entity.getRemark());
//		tmp.setStatus(entity.getStatus());
//		tmp.setSysAccount(entity.getSysAccount());
//		this.sysUserService.update(tmp);
		return tmp;
	}

	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody SysUser getUser(@PathVariable("id") Integer id) {
		SysUser tmp = this.sysUserService.findById(id);
		return tmp;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
	public @ResponseBody JsonResult delete(@PathVariable("id") Integer id) {
		this.sysUserService.deleteById(id);
		return JsonResult.success();
	}

	/**
	 * 通过关键字查询
	 * @param keywords
	 * @return
	 */
	@RequestMapping(value = "findByKeywords", method = RequestMethod.GET)
	public @ResponseBody List<SysUserDTO> findByKeywords(@RequestParam(value = "keywords", required = false, defaultValue = "") String keywords,
			@RequestParam(value = "userId", required = false) Integer userId) {
		List<SysUserDTO> rs = new ArrayList<SysUserDTO>();

		List<SysUser> tmp = this.sysUserService.findByKeywords(CurrentRequestContext.getCurrentCorpId(), userId, keywords);
//		if (tmp != null) {
//			tmp.forEach(su -> {
//				SysUserDTO d = BeanMapper.getInstance().map(su, SysUserDTO.class);
//				if (su.getSysAccount() != null) {
//					d.setRealName(su.getSysAccount().getRealName());
//					d.setLoginName(su.getSysAccount().getLoginName());
//					d.setTelNo(su.getSysAccount().getTelNo());
//
//					rs.add(d);
//				}
//			});
//		}

		return rs;
	}

	/**
	 * 查询企业用户信息
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "findCorpUsersByIds", method = RequestMethod.GET)
	public @ResponseBody List<SysUserDTO> findCorpUsers(@RequestParam("ids") String ids) {
		List<SysUserDTO> tmp = this.findByUserIds(StringHelper.trans2IntegerList(ids, ","));
		return tmp;
	}

	@RequestMapping(value = "findRoleIds/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Integer> findRoleIds(@PathVariable("id") Integer id, @RequestParam("type")Integer type) {
		return this.sysUserService.findRoleIds(id, type);
	}

	@RequestMapping(value = "assignRoles/{id}", method = RequestMethod.POST)
	public @ResponseBody JsonResult assignRoles(@PathVariable("id") Integer id, @RequestParam("roleType")Integer roleType, @RequestBody List<Integer> roleIds) {
		this.sysUserService.assignRoles(id, roleType, roleIds);
		return JsonResult.success();
	}
	
	@RequestMapping(value = "findUserIdsByRole", method = RequestMethod.GET)
	public @ResponseBody List<Integer> findUserIdsByRoleCode(@RequestParam("corpId")Integer corpId,@RequestParam("roleCode")String roleCode) {
		List<Integer> userIds = this.sysUserService.findUserIdsByRoleCode(corpId,roleCode);
		return userIds;
	}
	public List<SysUserDTO> findByUserIds(List<Integer> userIds) {
		if (CollectionUtils.isEmpty(userIds))
			return null;
		List<SysUser> suList = this.sysUserService.findByIds(userIds);
		List<Integer> accountIds = new ArrayList<Integer>();
		List<Integer> orgIds = new ArrayList<Integer>();
//		for(SysUser u:suList) {
//			accountIds.add(u.getAccountId());
//			if(u.getOrgId() != null) {
//				orgIds.add(u.getOrgId());
//			}
//		}
//		Map<Integer, SysOrg> soMap = new HashMap<Integer,SysOrg>();
//		if(orgIds.size()>0) {
//			List<SysOrg> soList = this.sysOrgService.findByIds(orgIds);
//			soMap = soList.stream().collect(Collectors.toMap(SysOrg::getId, Function.identity()));
//		}
//		List<SysAccount> saList = this.sysAccountService.findByIds(accountIds);
//
//		Map<Integer, SysAccount> saMap = saList.stream().collect(Collectors.toMap(SysAccount::getId, Function.identity()));
//
		List<SysUserDTO> rs = new ArrayList<SysUserDTO>();
//		for (SysUser su : suList) {
//			SysAccount sa = saMap.get(su.getAccountId());
//			if (sa == null) {
//				break;
//			}
//			SysUserDTO suDTO = BeanMapper.getInstance().map(su, SysUserDTO.class);
//			suDTO.setLoginName(sa.getLoginName());
//			suDTO.setRealName(sa.getRealName());
//			suDTO.setTelNo(sa.getTelNo());
//			
//			SysOrgDTO sysOrgDTO = BeanMapper.getInstance().map(soMap.get(su.getOrgId()), SysOrgDTO.class);
//			suDTO.setSysOrgDTO(sysOrgDTO);
//			rs.add(suDTO);
//		}

		return rs;
	}

	
//	@RequestMapping(value = "findCorpUserByEmployeeNo", method = RequestMethod.GET)
//	public @ResponseBody SysUserDTO findCorpUserByEmployeeNo(Integer corpId,String employNo) {
//		SysUser tmp = this.sysUserService.findCorpUserByEmployeeNo(corpId,employNo);
//		if(tmp == null) {
//			return null;
//		}
//		SysOrg org = this.sysOrgService.findById(tmp.getOrgId());
//		SysOrgDTO orgDTO = BeanMapper.getInstance().map(org, SysOrgDTO.class);
//		
//		SysUserDTO dto = BeanMapper.getInstance().map(tmp, SysUserDTO.class);
//		dto.setSysOrgDTO(orgDTO);
//		return dto;
//	}
}
