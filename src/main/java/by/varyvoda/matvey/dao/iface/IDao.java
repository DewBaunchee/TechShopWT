package by.varyvoda.matvey.dao.iface;

import by.varyvoda.matvey.entity.criteria.Query;

import java.util.List;

public interface IDao<V> {

	List<V> get(Query<V> criteria);

	void save(V appliance);

}
