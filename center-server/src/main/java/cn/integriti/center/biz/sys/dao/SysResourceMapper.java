package cn.integriti.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.integriti.center.biz.sys.domain.SysResource;

/**
 * SysResourceMapper
 * @author generator
 * @date 2015年12月05日
 */
public interface SysResourceMapper extends HbatisMapper<SysResource, Integer> {

	List<SysResource> findByQueryParam(@Param("queryParam") SysResource.QueryParam queryParam);

	long countByQueryParam(@Param("queryParam") SysResource.QueryParam queryParam);

	List<SysResource> findByIdsWithGroup(@Param("ids") List<Integer> ids);
}