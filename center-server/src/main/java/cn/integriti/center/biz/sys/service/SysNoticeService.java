package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysNotice;
import cn.integriti.center.biz.sys.queryParam.SysNoticeQueryParam;
/**
 * SysNoticeService
 * @author generator
 * @date 2015年12月17日
 */
public interface SysNoticeService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysNotice entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysNotice entity);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk);
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public SysNotice findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysNotice
	 * @return
	 */
	public List<SysNotice> findByNotNullProps(SysNotice entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysNotice
	 * @return
	 */
	public void updateNotNullPropsById(SysNotice entity);
	
	public List<SysNotice> findByQueryParam(SysNoticeQueryParam queryParma);
	
	public long countByQueryParam(SysNoticeQueryParam queryParam) ;
	
	public List<SysNotice> findAll();
}
