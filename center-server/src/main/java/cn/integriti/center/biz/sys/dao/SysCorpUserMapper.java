package cn.integriti.center.biz.sys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import cn.integriti.center.biz.sys.domain.SysCorpUser;
/**
 * SysCorpUserMapper
 * @author generator
 * @date 2018年06月07日
 */
public interface SysCorpUserMapper extends HbatisMapper<SysCorpUser, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<SysCorpUser> findByQueryParam(@Param("queryParam")SysCorpUser.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")SysCorpUser.QueryParam queryParam);
	//-- 按实体参数查询[END] 
	
	//-- 自定义业务方法，请写在下方 -->
}