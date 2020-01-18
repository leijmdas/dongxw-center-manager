package cn.kunlong.center.core.support.query;

import java.util.List;

public class QueryParam<T> {

	public static final int LIMIT = 20;
	private T param;

	private Integer start = 0;

	private Integer limit = LIMIT;

	private Integer page = null;

	private List<String> orders ;
	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}

	public Integer getStart() {
		int tmp = page == null ? start : (page - 1) * limit;
		return tmp;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return this.limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPageSize(Integer pageSize) {
		this.limit = pageSize;
	}

	public List<String> getOrders() {
		return orders;
	}

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}

}
