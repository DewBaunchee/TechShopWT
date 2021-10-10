package by.varyvoda.matvey.service;

import by.varyvoda.matvey.dao.DaoFactory;
import by.varyvoda.matvey.entity.Appliance;
import by.varyvoda.matvey.entity.criteria.Query;
import by.varyvoda.matvey.service.iface.IApplianceService;

import java.util.Comparator;
import java.util.List;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 */
public class ApplianceService implements IApplianceService {

    /**
     * @param query - search query
     * @return list of appliances that fit to query
     */
    @Override
    public List<Appliance> get(Query<Appliance> query) {
        return DaoFactory.getInstance().getApplianceDao().get(query);
    }

    /**
     * @return cheapest appliance
     */
    @Override
    public Appliance getCheapest() {
        return DaoFactory.getInstance()
                .getApplianceDao()
                .get(new Query<>(Appliance.class)).stream()
                .min(Comparator.comparing(Appliance::getPrice))
                .orElse(null);
    }

    /**
     * @param appliance object for saving
     */
    @Override
    public void save(Appliance appliance) {
        DaoFactory.getInstance().getApplianceDao().save(appliance);
    }
}
