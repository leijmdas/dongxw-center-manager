package cn.kunlong.center.biz.sys.service;

import cn.kunlong.center.biz.sys.domain.SysShortlink;
import java.util.List;
/**
 * SysShortlinkService
 * @author generator
 * @date 2018年10月11日
 */
public interface SysShortlinkService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysShortlink entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysShortlink entity);
	
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
	public SysShortlink findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysShortlinkController
	 * @return
	 */
	public List<SysShortlink> findByNotNullProps(SysShortlink entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysShortlinkController
	 * @return
	 */
	public void updateNotNullPropsById(SysShortlink entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param SysShortlink.QueryParam
	 * @return
	 */
	public List<SysShortlink> findByQueryParam(SysShortlink.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param SysShortlink.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysShortlink.QueryParam queryParam);

	public SysShortlink findByCode(String code);
}
