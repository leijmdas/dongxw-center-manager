package cn.kunlong.center.biz.sys.service;

import java.util.List;

import cn.kunlong.center.biz.sys.domain.SysHttpJob;
/**
 * SysHttpJobService
 * @author generator
 * @date 2019年03月21日
 */
public interface SysHttpJobService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysHttpJob entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysHttpJob entity);
	
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
	public SysHttpJob findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysHttpJob
	 * @return
	 */
	public List<SysHttpJob> findByNotNullProps(SysHttpJob entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysHttpJob
	 * @return
	 */
	public void updateNotNullPropsById(SysHttpJob entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param SysHttpJob.QueryParam
	 * @return
	 */
	public List<SysHttpJob> findByQueryParam(SysHttpJob.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param SysHttpJob.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysHttpJob.QueryParam queryParam);
	/**
	 * 通过ID集合查询
	 * @param List<Integer> pks
	 * @return
	 */
	public List<SysHttpJob> findByIds(List<Integer> pks);
	/**
	 * 值填充
	 * @param items
	 * @param field
	 */
	public void fillValues(List<SysHttpJob> items,SysHttpJob.ValueField ...field);
	public void pause(Integer id);
	
	public void resume(Integer id);
}
