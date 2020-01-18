package cn.kunlong.center.biz.sys.service;

import java.util.List;

import cn.kunlong.center.biz.sys.domain.SysMsg;
import cn.kunlong.center.biz.sys.queryParam.SysMsgQueryParam;
/**
 * SysMsgService
 * @author generator
 * @date 2016年02月18日
 */
public interface SysMsgService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysMsg entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysMsg entity);
	
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
	public SysMsg findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysMsg
	 * @return
	 */
	public List<SysMsg> findByNotNullProps(SysMsg entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysMsg
	 * @return
	 */
	public void updateNotNullPropsById(SysMsg entity);

	public List<SysMsg> findByQueryParam(SysMsgQueryParam queryParam);

	public long countByQueryParam(SysMsgQueryParam queryParam);

	public int countUnRead(Integer userId);
}
