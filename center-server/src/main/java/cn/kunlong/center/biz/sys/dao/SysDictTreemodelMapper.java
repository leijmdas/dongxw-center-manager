package cn.kunlong.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.kunlong.center.biz.sys.domain.SysDictTreemodel;
import cn.kunlong.center.biz.sys.queryParam.SysDictTreemodelQueryParam;
/**
 * SysDictTreemodelMapper
 * @author generator
 * @date 2015年12月27日
 */
public interface SysDictTreemodelMapper extends HbatisMapper<SysDictTreemodel, Integer> {

	int replacePath(@Param("oldIdPath")String oldIdPath, @Param("newIdPath")String path);

	List<SysDictTreemodel> findByQueryParam(@Param("queryParam")
			SysDictTreemodelQueryParam queryParam);

	long countByQueryParam(@Param("queryParam")SysDictTreemodelQueryParam queryParam);
	
}