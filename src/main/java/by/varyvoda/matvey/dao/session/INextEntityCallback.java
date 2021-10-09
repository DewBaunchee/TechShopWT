package by.varyvoda.matvey.dao.session;

public interface INextEntityCallback<V> {
    boolean isSuitable(V value);
}
