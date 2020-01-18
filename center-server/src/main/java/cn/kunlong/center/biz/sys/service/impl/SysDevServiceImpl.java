package cn.kunlong.center.biz.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.kunlong.center.biz.sys.dao.SysDevMapper;
import cn.kunlong.center.biz.sys.domain.SysDev;
import cn.kunlong.center.biz.sys.service.SysDevService;
import cn.kunlong.center.core.enums.SysDevKeyEnum;
import cn.kunlong.center.core.util.CollectionUtil;
/**
 * SysDevServiceImpl
 * @author generator
 * @date 2016年02月18日
 */
@Service
public class SysDevServiceImpl implements SysDevService {
	
	@Autowired
	private SysDevMapper repo;
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysDev entity){
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysDev entity){
		repo.update(entity);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk){
		repo.deleteByPK(pk);
	}
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public SysDev findById(Integer pk){
		return repo.selectByPK(pk);
	}
	/**
	 * 通过非空属性查询
	 * @param SysDev
	 * @return
	 */
	public List<SysDev> findByNotNullProps(SysDev entity){
		
		SelectStatement<SysDev> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}
	/**
	 * 通过主键更新非空属性
	 * @param SysDev
	 * @return
	 */
	public void updateNotNullPropsById(SysDev entity){
		
		UpdateStatement<SysDev> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysDev> findAllDevs() {
		SysDev.EntityNode n = SysDev.EntityNode.INSTANCE;
		SelectStatement<SysDev> st = StatementBuilder.buildSelect(n);
		return this.repo.selectByStatement(st);
	}

	@Override
	public void saveOrUpdateDevVals(Map<String, String> devEntryMap) {
		List<SysDev> devs = this.findAllDevs();

		List<SysDev> rs = new ArrayList<SysDev>();
		Map<String, String> keyNameMap = SysDevKeyEnum.toMap();

		for (Map.Entry<String, String> entry : devEntryMap.entrySet()) {
			String devKey = entry.getKey();
			boolean findFlag = false;
			SysDev dev = null;
			if (devs != null) {
				for (SysDev tmp : devs) {
					if (devKey.equals(tmp.getDevKey())) {
						dev = tmp;
						dev.setDevValue(entry.getValue());
						findFlag = true;
						break;
					}
				}
			}
			if (!findFlag) {
				dev = new SysDev();
				dev.setDevValueType("string");
				dev.setDevKey(devKey);
				String devName = keyNameMap.get(devKey);
				dev.setDevName(devName == null ? dev.getDevKey() : devName);
				dev.setDevValue(entry.getValue());
			}
			rs.add(dev);
		}
		for (SysDev tmp : rs) {
			this.saveOrUpdate(tmp);
		}
	}
	
	
	public void saveOrUpdate(SysDev dev) {
		if (dev.getId() == null) {
			this.repo.insert(dev);
		} else {
			SysDev.EntityNode n = SysDev.EntityNode.INSTANCE;
			UpdateStatement<SysDev> st = StatementBuilder.buildUpdateSelective(dev);
			st.addField(n.devKey, dev.getDevKey());
			this.repo.updateByStatement(st);
		}
	}

	@Override
	public SysDev findByKey(String key) {
		SysDev.EntityNode n = SysDev.EntityNode.INSTANCE;
		SelectStatement<SysDev> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.devKey.eq(key));
		List<SysDev> list = this.repo.selectByStatement(st);
		return CollectionUtil.uniqueResult(list);
	}
}
