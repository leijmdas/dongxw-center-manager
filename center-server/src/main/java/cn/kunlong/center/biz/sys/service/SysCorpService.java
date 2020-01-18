package cn.kunlong.center.biz.sys.service;

import cn.kunlong.center.biz.sys.domain.SysCorp;
import java.util.List;
/**
 * SysCorpService
 * @author generator
 * @date 2018年06月07日
 */
public interface SysCorpService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysCorp entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysCorp entity);
	
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
	public SysCorp findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysCorp
	 * @return
	 */
	public List<SysCorp> findByNotNullProps(SysCorp entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysCorp
	 * @return
	 */
	public void updateNotNullPropsById(SysCorp entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param SysCorp.QueryParam
	 * @return
	 */
	public List<SysCorp> findByQueryParam(SysCorp.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param SysCorp.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysCorp.QueryParam queryParam);

	public SysCorp findByCode(String code);
	public List<SysCorp> findMicroList(SysCorp.QueryParam qp);
}
