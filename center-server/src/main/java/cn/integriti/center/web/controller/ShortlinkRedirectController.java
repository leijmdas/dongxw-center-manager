package cn.integriti.center.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.integriti.center.biz.sys.domain.SysShortlink;
import cn.integriti.center.biz.sys.service.SysShortlinkService;

@Controller
@RequestMapping("/public/redirect")
public class ShortlinkRedirectController {

	@Autowired
	private SysShortlinkService sysShortlinkService;
	
	@RequestMapping("{code}")
	public void redirect(@PathVariable("code")String code,HttpServletResponse rsp) {
		SysShortlink tmp = sysShortlinkService.findByCode(code);
		Assert.notNull(tmp,"短链码不存在");
		if(tmp.getUrl().endsWith("/public/redirect/"+code)) {
			throw new RuntimeException("目的地址相同");
		}
		try {
			rsp.sendRedirect(tmp.getUrl());
		} catch (IOException e) {
			
		}
	}
}
