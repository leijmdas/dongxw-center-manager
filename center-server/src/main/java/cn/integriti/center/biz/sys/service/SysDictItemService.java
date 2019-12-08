package cn.integriti.center.biz.sys.service;

import java.util.List;

import cn.integriti.center.biz.sys.domain.SysDictItem;
import cn.integriti.center.biz.sys.queryParam.SysDictDetailQueryParam;
/**
 * SysDictDetailService
 * @author generator
 * @date 2015年12月15日
 */
public interface SysDictItemService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysDictItem entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysDictItem entity);
	
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
	public SysDictItem findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysDictItem
	 * @return
	 */
	public List<SysDictItem> findByNotNullProps(SysDictItem entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysDictItem
	 * @return
	 */
	public void updateNotNullPropsById(SysDictItem entity);
	
	
	public List<SysDictItem> findByQueryParam(SysDictDetailQueryParam queryParam);

	public long countByQueryParam(SysDictDetailQueryParam queryParam);
	
	/**
	 * 查询字典特定项
	 * @param dictCode
	 * @param code
	 * @return
	 */
	public SysDictItem findDictDetail(Integer corpId,String dictCode,String code);

	public List<SysDictItem> findByDictId(Integer id);

	public List<SysDictItem> findByIds(List<Integer> ids);
}
