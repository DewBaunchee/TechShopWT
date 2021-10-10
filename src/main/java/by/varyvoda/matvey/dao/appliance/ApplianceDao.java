package by.varyvoda.matvey.dao.appliance;

import by.varyvoda.matvey.dao.AbstractDao;
import by.varyvoda.matvey.entity.Appliance;
import by.varyvoda.matvey.entity.criteria.Query;

import java.io.IOException;
import java.util.List;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 */
public class ApplianceDao extends AbstractDao<Appliance> {

    public ApplianceDao() {
        super("appliances.xml");
    }

    /**
     * @param query - search query
     * @return list of appliances that fit to query
     */
    @Override
    public List<Appliance> get(Query<? extends Appliance> query) {
        try {
            return getSession()
                    .specifyQuery(query)
                    .commit()
                    .getResult();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param appliance - appliance for saving
     */
    @Override
    public void save(Appliance appliance) {
        try {
            getSession().save(appliance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
