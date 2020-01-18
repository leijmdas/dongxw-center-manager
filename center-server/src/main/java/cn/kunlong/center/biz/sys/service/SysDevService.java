package cn.kunlong.center.biz.sys.service;

import java.util.List;
import java.util.Map;

import cn.kunlong.center.biz.sys.domain.SysDev;
/**
 * SysDevService
 * @author generator
 * @date 2016年02月18日
 */
public interface SysDevService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysDev entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysDev entity);
	
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
	public SysDev findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysDev
	 * @return
	 */
	public List<SysDev> findByNotNullProps(SysDev entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysDev
	 * @return
	 */
	public void updateNotNullPropsById(SysDev entity);

	public List<SysDev> findAllDevs();

	public void saveOrUpdateDevVals(Map<String, String> devEntryMap);
	
	
	SysDev findByKey(String key);
}
