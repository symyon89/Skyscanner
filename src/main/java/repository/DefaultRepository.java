package repository;


import java.util.List;
import java.util.UUID;


public class DefaultRepository<T>  {
    HibernateUtil util = HibernateUtil.getInstance();

    public void save(T object) {
        util.runWithTransaction(
                (entityManager) -> entityManager.merge(object)
        );
    }

    public List<T> findAll(String query) {
        return util.getEntityManager().createQuery(query).getResultList();
    }

    public void remove(T object) {
        util.runWithTransaction(entityManager -> entityManager.remove(object));
    }

    public T findById(UUID id, Class<T> clazz) {
        return util.getEntityManager().find(clazz,id);
    }

    public T findById(Integer id, Class<T> clazz) {
        return util.getEntityManager().find(clazz,id);
    }

}
