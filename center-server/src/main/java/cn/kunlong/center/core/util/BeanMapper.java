package cn.kunlong.center.core.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

/**
 * 
 * @author zz
 *
 */
public class BeanMapper {

	public static final Integer UNMAPNULLS = 0;
	public static final Integer MAPNULLS = 1;
	public static final Integer DEFAULT = UNMAPNULLS;
	
	private static Map<Integer, BeanMapper> instanceCache = new HashMap<Integer, BeanMapper>();

	public static BeanMapper getInstance(){
		return BeanMapper.getInstance(DEFAULT);
	}
	public static BeanMapper getInstance(Integer type) {
		BeanMapper mapper = instanceCache.get(type);
		if (mapper == null) {
			mapper = new BeanMapper(type);
			instanceCache.put(type, mapper);
		}
		return mapper;
	}

	private MapperFacade facade;

	private BeanMapper(int type) {

		if (type == 0) {
			this.init(false);

		} else if (type == 1) {
			this.init(true);
		} else {
			throw new RuntimeException("可用参数为0或1");
		}

	}
	protected void init(boolean mapNulls) {

		DefaultMapperFactory.Builder factoryBuilder = new DefaultMapperFactory.Builder();
		factoryBuilder.mapNulls(mapNulls);
		MapperFactory factory = factoryBuilder.build();
		this.facade = factory.getMapperFacade();
	}

	public <S, D> D map(S sourceObject, Class<D> destinationClass) {
		return facade.map(sourceObject, destinationClass);
	}

	public <S, D> D map(S sourceObject, Class<D> destinationClass, MappingContext context) {

		return facade.map(sourceObject, destinationClass, context);
	}

	public <S, D> void map(S sourceObject, D destinationObject) {
		facade.map(sourceObject, destinationObject);
	}

	public <S, D> void map(S sourceObject, D destinationObject, MappingContext context) {
		facade.map(sourceObject, destinationObject, context);
	}

	public <S, D> void map(S sourceObject, D destinationObject, Type<S> sourceType, Type<D> destinationType) {
		facade.map(sourceObject, destinationObject, sourceType, destinationType);
	}

	public <S, D> void map(S sourceObject, D destinationObject, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		facade.map(sourceObject, destinationObject, sourceType, destinationType, context);
	}

	public <S, D> Set<D> mapAsSet(Iterable<S> source, Class<D> destinationClass) {
		return facade.mapAsSet(source, destinationClass);
	}

	public <S, D> Set<D> mapAsSet(Iterable<S> source, Class<D> destinationClass, MappingContext context) {
		return facade.mapAsSet(source, destinationClass, context);
	}

	public <S, D> Set<D> mapAsSet(S[] source, Class<D> destinationClass) {
		return facade.mapAsSet(source, destinationClass);
	}

	public <S, D> Set<D> mapAsSet(S[] source, Class<D> destinationClass, MappingContext context) {
		return facade.mapAsSet(source, destinationClass, context);
	}

	public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
		return facade.mapAsList(source, destinationClass);
	}

	public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass, MappingContext context) {
		return facade.mapAsList(source, destinationClass, context);
	}

	public <S, D> List<D> mapAsList(S[] source, Class<D> destinationClass) {
		return facade.mapAsList(source, destinationClass);
	}

	public <S, D> List<D> mapAsList(S[] source, Class<D> destinationClass, MappingContext context) {
		return facade.mapAsList(source, destinationClass, context);
	}

	public <S, D> D[] mapAsArray(D[] destination, Iterable<S> source, Class<D> destinationClass) {
		return facade.mapAsArray(destination, source, destinationClass);
	}

	public <S, D> D[] mapAsArray(D[] destination, S[] source, Class<D> destinationClass) {
		return facade.mapAsArray(destination, source, destinationClass);
	}

	public <S, D> D[] mapAsArray(D[] destination, Iterable<S> source, Class<D> destinationClass, MappingContext context) {
		return facade.mapAsArray(destination, source, destinationClass, context);
	}

	public <S, D> D[] mapAsArray(D[] destination, S[] source, Class<D> destinationClass, MappingContext context) {
		return facade.mapAsArray(destination, source, destinationClass, context);
	}

	public <S, D> D map(S sourceObject, Type<S> sourceType, Type<D> destinationType) {
		return facade.map(sourceObject, sourceType, destinationType);
	}

	public <S, D> D map(S sourceObject, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.map(sourceObject, sourceType, destinationType, context);
	}

	public <S, D> Set<D> mapAsSet(Iterable<S> source, Type<S> sourceType, Type<D> destinationType) {
		return facade.mapAsSet(source, sourceType, destinationType);
	}

	public <S, D> Set<D> mapAsSet(Iterable<S> source, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.mapAsSet(source, sourceType, destinationType, context);
	}

	public <S, D> Set<D> mapAsSet(S[] source, Type<S> sourceType, Type<D> destinationType) {
		return facade.mapAsSet(source, sourceType, destinationType);
	}

	public <S, D> Set<D> mapAsSet(S[] source, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.mapAsSet(source, sourceType, destinationType, context);
	}

	public <S, D> List<D> mapAsList(Iterable<S> source, Type<S> sourceType, Type<D> destinationType) {
		return facade.mapAsList(source, sourceType, destinationType);
	}

	public <S, D> List<D> mapAsList(Iterable<S> source, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.mapAsList(source, sourceType, destinationType, context);
	}

	public <S, D> List<D> mapAsList(S[] source, Type<S> sourceType, Type<D> destinationType) {
		return facade.mapAsList(source, sourceType, destinationType);
	}

	public <S, D> List<D> mapAsList(S[] source, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.mapAsList(source, sourceType, destinationType, context);
	}

	public <S, D> D[] mapAsArray(D[] destination, Iterable<S> source, Type<S> sourceType, Type<D> destinationType) {
		return facade.mapAsArray(destination, source, sourceType, destinationType);
	}

	public <S, D> D[] mapAsArray(D[] destination, S[] source, Type<S> sourceType, Type<D> destinationType) {
		return facade.mapAsArray(destination, source, sourceType, destinationType);
	}

	public <S, D> D[] mapAsArray(D[] destination, Iterable<S> source, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.mapAsArray(destination, source, sourceType, destinationType, context);
	}

	public <S, D> D[] mapAsArray(D[] destination, S[] source, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.mapAsArray(destination, source, sourceType, destinationType, context);
	}

	public <S, D> void mapAsCollection(Iterable<S> source, Collection<D> destination, Class<D> destinationClass) {
		facade.mapAsCollection(source, destination, destinationClass);
	}

	public <S, D> void mapAsCollection(Iterable<S> source, Collection<D> destination, Class<D> destinationClass, MappingContext context) {
		facade.mapAsCollection(source, destination, destinationClass, context);
	}

	public <S, D> void mapAsCollection(S[] source, Collection<D> destination, Class<D> destinationCollection) {
		facade.mapAsCollection(source, destination, destinationCollection);
	}

	public <S, D> void mapAsCollection(S[] source, Collection<D> destination, Class<D> destinationCollection, MappingContext context) {
		facade.mapAsCollection(source, destination, destinationCollection, context);
	}

	public <S, D> void mapAsCollection(Iterable<S> source, Collection<D> destination, Type<S> sourceType, Type<D> destinationType) {
		facade.mapAsCollection(source, destination, sourceType, destinationType);
	}

	public <S, D> void mapAsCollection(S[] source, Collection<D> destination, Type<S> sourceType, Type<D> destinationType) {
		facade.mapAsCollection(source, destination, sourceType, destinationType);
	}

	public <S, D> void mapAsCollection(Iterable<S> source, Collection<D> destination, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		facade.mapAsCollection(source, destination, sourceType, destinationType, context);
	}

	public <S, D> void mapAsCollection(S[] source, Collection<D> destination, Type<S> sourceType, Type<D> destinationType, MappingContext context) {
		facade.mapAsCollection(source, destination, sourceType, destinationType, context);
	}

	public <S, D> D newObject(S source, Type<? extends D> destinationClass, MappingContext context) {
		return facade.newObject(source, destinationClass, context);
	}

	public <Sk, Sv, Dk, Dv> Map<Dk, Dv> mapAsMap(Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType, Type<? extends Map<Dk, Dv>> destinationType) {
		return facade.mapAsMap(source, sourceType, destinationType);
	}

	public <Sk, Sv, Dk, Dv> Map<Dk, Dv> mapAsMap(Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType, Type<? extends Map<Dk, Dv>> destinationType, MappingContext context) {
		return facade.mapAsMap(source, sourceType, destinationType, context);
	}

	public <S, Dk, Dv> Map<Dk, Dv> mapAsMap(Iterable<S> source, Type<S> sourceType, Type<? extends Map<Dk, Dv>> destinationType) {
		return facade.mapAsMap(source, sourceType, destinationType);
	}

	public <S, Dk, Dv> Map<Dk, Dv> mapAsMap(Iterable<S> source, Type<S> sourceType, Type<? extends Map<Dk, Dv>> destinationType, MappingContext context) {
		return facade.mapAsMap(source, sourceType, destinationType, context);
	}

	public <S, Dk, Dv> Map<Dk, Dv> mapAsMap(S[] source, Type<S> sourceType, Type<? extends Map<Dk, Dv>> destinationType) {
		return facade.mapAsMap(source, sourceType, destinationType);
	}

	public <S, Dk, Dv> Map<Dk, Dv> mapAsMap(S[] source, Type<S> sourceType, Type<? extends Map<Dk, Dv>> destinationType, MappingContext context) {
		return facade.mapAsMap(source, sourceType, destinationType, context);
	}

	public <Sk, Sv, D> List<D> mapAsList(Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType, Type<D> destinationType) {
		return facade.mapAsList(source, sourceType, destinationType);
	}

	public <Sk, Sv, D> List<D> mapAsList(Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.mapAsList(source, sourceType, destinationType, context);
	}

	public <Sk, Sv, D> Set<D> mapAsSet(Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType, Type<D> destinationType) {
		return facade.mapAsSet(source, sourceType, destinationType);
	}

	public <Sk, Sv, D> Set<D> mapAsSet(Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.mapAsSet(source, sourceType, destinationType, context);
	}

	public <Sk, Sv, D> D[] mapAsArray(D[] destination, Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType, Type<D> destinationType) {
		return facade.mapAsArray(destination, source, sourceType, destinationType);
	}

	public <Sk, Sv, D> D[] mapAsArray(D[] destination, Map<Sk, Sv> source, Type<? extends Map<Sk, Sv>> sourceType, Type<D> destinationType, MappingContext context) {
		return facade.mapAsArray(destination, source, sourceType, destinationType, context);
	}

	public MapperFacade getFacade() {
		return facade;
	}
}