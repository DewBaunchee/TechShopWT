package by.varyvoda.matvey.dao;

import by.varyvoda.matvey.dao.appliance.ApplianceDao;
import by.varyvoda.matvey.dao.iface.IDao;
import by.varyvoda.matvey.entity.Appliance;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 */
public final class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();

    public static DaoFactory getInstance() {
        return instance;
    }

    private final IDao<Appliance> applianceDAO = new ApplianceDao();

    public IDao<Appliance> getApplianceDao() {
        return applianceDAO;
    }
}
