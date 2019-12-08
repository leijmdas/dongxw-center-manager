package cn.integriti.center.api;

import java.util.ArrayList;
import java.util.List;

public interface ITransformer<T,R> {

	default R produce(T t) {
		if(t == null) {
			return null;
		}
		return null;
	}
	
	default T consume(R r) {
		if(r == null) {
			return null;
		}
		return null;
	}
	

	default List<R> produces(List<T> list) {
		if(list == null || list.isEmpty()) {
			return null;
		}
		List<R> rs = new ArrayList<R>();
		for(T t:list) {
			rs.add(this.produce(t));
		}
		return rs;
	}
	
}
