package by.varyvoda.matvey.entity.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 * */
public class Query<E> {

    private final Class<? extends E> targetClass;
    private final Map<SearchCriteria.Criteria<?>, Object> criteria = new HashMap<>();

    public Query(Class<? extends E> targetClass) {
        this.targetClass = targetClass;
    }

    /**
     * Getter of target class
     * @return class of objects that query is looking for
     * */
    public Class<? extends E> getTargetClass() {
        return targetClass;
    }

    /**
     * Method for adding a criteria
     *
     * @param searchCriteria - add search criteria as a key
     * @param value - value of criteria
     * @param <V> - type of value of criteria
     * @return this query
     * */
    public <V> Query<E> add(SearchCriteria.Criteria<V> searchCriteria, V value) {
        if(!searchCriteria.getValueValidator().isCorrect(value))
            throw new IllegalArgumentException("Value '" + value + "' is not suitable for '" + searchCriteria + "' search criteria.");
        criteria.put(searchCriteria, value);
        return this;
    }

    /**
     * @param entity object for checking
     * @return true if entity is fit to criteria
     * */
    public boolean isSuitable(E entity) {
        return targetClass.isAssignableFrom(entity.getClass()) &&
                criteria.keySet()
                        .stream()
                        .allMatch(
                                key -> key.getComparer().isSuitable(entity, criteria.get(key))
                        );
    }

}
