package by.varyvoda.matvey.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Query<E> {

    private final Class<? extends E> targetClass;
    private final Map<SearchCriteria.Criteria<E, Object>, Object> criteria = new HashMap<>();

    public Query(Class<? extends E> targetClass) {
        this.targetClass = targetClass;
    }

    public Class<? extends E> getTargetClass() {
        return targetClass;
    }

    public Query<E> add(SearchCriteria.Criteria<E, Object> searchCriteria, Object value) {
        if(!searchCriteria.getValueValidator().isCorrect(value))
            throw new IllegalArgumentException("Value '" + value + "' is not suitable for '" + searchCriteria + "' search criteria.");
        criteria.put(searchCriteria, value);
        return this;
    }

    public boolean isSuitable(E entity) {
        return targetClass.isAssignableFrom(entity.getClass()) &&
                criteria.keySet()
                        .stream()
                        .allMatch(
                                key -> key.getComparer()
                                        .isSuitable(entity, criteria.get(key))
                        );
    }

}
