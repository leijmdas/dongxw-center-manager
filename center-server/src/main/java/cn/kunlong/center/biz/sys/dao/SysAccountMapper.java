package cn.kunlong.center.biz.sys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import cn.kunlong.center.biz.sys.domain.SysAccount;
/**
 * SysAccountMapper
 * @author generator
 * @date 2018年06月11日
 */
public interface SysAccountMapper extends HbatisMapper<SysAccount, Integer> {
	
	
	//-- 按实体参数查询[START] 
	List<SysAccount> findByQueryParam(@Param("queryParam")SysAccount.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")SysAccount.QueryParam queryParam);
	//-- 按实体参数查询[END] 

	
	//-- 自定义业务方法，请写在下方 -->
	
	@Select("select * from t_sys_account sa where sa.login_name=#{username} or sa.tel_no=#{username} limit 0,1")
	@ResultMap(value= {"BaseResultMap"})
	SysAccount findLoginnameOrTel(String username);
	
}