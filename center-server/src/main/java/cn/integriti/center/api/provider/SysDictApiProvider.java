package cn.integriti.center.api.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import app.support.query.PageResult;
import cn.integriti.center.api.DTFactory;
import cn.integriti.center.api.dto.queryParam.SysDictQueryDTO;
import cn.integriti.center.api.model.SysDictDTO;
import cn.integriti.center.api.model.SysDictItemDTO;
import cn.integriti.center.api.service.SysDictApiService;
import cn.integriti.center.api.transformer.SysDictItemTransformer;
import cn.integriti.center.api.transformer.SysDictTransformer;
import cn.integriti.center.biz.sys.domain.SysDict;
import cn.integriti.center.biz.sys.domain.SysDictItem;
import cn.integriti.center.biz.sys.queryParam.SysDictQueryParam;
import cn.integriti.center.biz.sys.service.SysDictItemService;
import cn.integriti.center.biz.sys.service.SysDictService;
import cn.integriti.center.core.util.BeanMapper;
@Service(version = "${dubbo.service.version}")
public class SysDictApiProvider implements SysDictApiService {

	@Autowired
	private SysDictService service;
	
	@Autowired
	private SysDictItemService itemService;
	
	private static final SysDictTransformer T = DTFactory.getInstance(SysDictTransformer.class);
	
	@Override
	public PageResult<SysDictDTO> query(SysDictQueryDTO qpDTO) {
		SysDictQueryParam qp = BeanMapper.getInstance().map(qpDTO, SysDictQueryParam.class);
		List<SysDict> list = this.service.findByQueryParam(qp);
		long total = this.service.countByQueryParam(qp);
		
		PageResult<SysDictDTO> page = new PageResult<SysDictDTO>();
		page.setData(T.produces(list));
		page.setTotal(total);
		return page;
	}
	@Override
	public SysDictDTO findWithItemsById(Integer id) {
		SysDict dict = service.findById(id);
		if(dict == null) {
			return null;
		}
		List<SysDictItem> items = this.itemService.findByDictId(id);
		
		SysDictDTO dictDTO = T.produce(dict);
		List<SysDictItemDTO> itemDTOs = DTFactory.getInstance(SysDictItemTransformer.class).produces(items);
		dictDTO.setItems(itemDTOs);
		return dictDTO;
	}

	@Override
	public Integer saveDictItem(SysDictItemDTO item) {
		SysDictItem entity = DTFactory.getInstance(SysDictItemTransformer.class).consume(item);
		if(item.getId() == null) {
			this.itemService.save(entity);
		} else {
			SysDictItem tmp = this.itemService.findById(entity.getId());
			BeanMapper.getInstance().map(entity, tmp);
			this.itemService.update(tmp);
		}
		return entity.getId();
	}

	@Override
	public void deleteItem(Integer itemId) {
		this.itemService.deleteById(itemId);
	}
	@Override
	public SysDictDTO findWithItemsByCode(Integer corpId, String code) {
		SysDict tmp = this.service.findByCode(corpId,code);
		return T.produce(tmp);
	}
	@Override
	public SysDictItemDTO findItemById(Integer itemId) {
		SysDictItem item = this.itemService.findById(itemId);
		return DTFactory.getInstance(SysDictItemTransformer.class).produce(item);
	}
	@Override
	public List<SysDictItemDTO> findItemsByIds(List<Integer> itemIds) {
		List<SysDictItem> items = this.itemService.findByIds(itemIds);
		
		return DTFactory.getInstance(SysDictItemTransformer.class).produces(items);
	}

}
