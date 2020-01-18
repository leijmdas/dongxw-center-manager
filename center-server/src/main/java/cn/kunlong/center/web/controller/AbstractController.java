package cn.kunlong.center.web.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import cn.kunlong.center.biz.sys.domain.SysDictItem;
import cn.kunlong.center.biz.sys.domain.SysUser;
import cn.kunlong.center.biz.sys.service.SysDevService;
import cn.kunlong.center.biz.sys.service.SysDictService;


public abstract class AbstractController {

	@Autowired
	protected SysDictService sysDictService;
	
	@Autowired
	protected SysDevService sysDevService;
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		df.setLenient(false);
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(df,true));
	}

	/**
	 * 获取当前用户
	 * 
	 * @return
	 */
	public SysUser getCurrentUser() {
//		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
//		if (principalCollection == null)
//			return null;
//		SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
//		return user;
		return null;
	}
	
	public List<SysDictItem> getDictDetails(Integer corpId,String code){
		return this.sysDictService.findByDictDetails(corpId,code);
	}
}
