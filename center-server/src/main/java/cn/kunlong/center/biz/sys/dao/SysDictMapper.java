package cn.kunlong.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.kunlong.center.biz.sys.domain.SysDict;
import cn.kunlong.center.biz.sys.queryParam.SysDictQueryParam;
/**
 * SysDictMapper
 * @author generator
 * @date 2015年12月15日
 */
public interface SysDictMapper extends HbatisMapper<SysDict, Integer> {

	List<SysDict> findByQueryParam(@Param("queryParam")SysDictQueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")SysDictQueryParam queryParam);
	
	
	SysDict findByCode(@Param("corpId")Integer corpId,@Param("code")String code);
}