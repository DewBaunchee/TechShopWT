package by.varyvoda.matvey.dao.iface;

import by.varyvoda.matvey.entity.criteria.Query;

import java.util.List;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 */
public interface IDao<V> {

    List<V> get(Query<? extends V> criteria);

    void save(V appliance);

}
