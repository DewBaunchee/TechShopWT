package by.varyvoda.matvey.dao.appliance;

import by.varyvoda.matvey.dao.AbstractDao;
import by.varyvoda.matvey.entity.Appliance;
import by.varyvoda.matvey.entity.criteria.Query;

import java.io.IOException;
import java.util.List;

public class ApplianceDao extends AbstractDao<Appliance> {

    public ApplianceDao() {
       super("appliances.xml");
    }

    @Override
    public List<Appliance> get(Query criteria) {try {
        return getSession()
                .createQuery((appliance) -> true, Appliance.class)
                .commit()
                .getResult();
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
    }

    @Override
    public List<Appliance> getAll() {
        try {
            return getSession()
                    .createQuery((appliance) -> true, Appliance.class)
                    .commit()
                    .getResult();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(Appliance appliance) {
        try {
            getSession().save(appliance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
