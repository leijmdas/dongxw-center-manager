package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysDomain;
import cn.integriti.center.biz.sys.queryParam.SysDomainQueryParam;
/**
 * SysDomainService
 * @author generator
 * @date 2016年05月04日
 */
public interface SysDomainService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysDomain entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysDomain entity);
	
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
	public SysDomain findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysDomain
	 * @return
	 */
	public List<SysDomain> findByNotNullProps(SysDomain entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysDomain
	 * @return
	 */
	public void updateNotNullPropsById(SysDomain entity);

	public List<SysDomain> findByQueryParam(SysDomainQueryParam queryParam);

	public long countByQueryParam(SysDomainQueryParam queryParam);

	public List<SysDomain> findAll();

	public SysDomain findByCode(String domainCode);
}
