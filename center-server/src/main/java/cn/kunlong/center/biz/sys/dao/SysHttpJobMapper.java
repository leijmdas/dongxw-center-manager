package cn.kunlong.center.biz.sys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import cn.kunlong.center.biz.sys.domain.SysHttpJob;
/**
 * SysHttpJobMapper
 * @author generator
 * @date 2019年03月21日
 */
public interface SysHttpJobMapper extends HbatisMapper<SysHttpJob, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<SysHttpJob> findByQueryParam(@Param("queryParam")SysHttpJob.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")SysHttpJob.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}