package by.varyvoda.matvey.service.iface;

import by.varyvoda.matvey.entity.Appliance;
import by.varyvoda.matvey.entity.criteria.Query;

import java.util.List;

/**
 * @author Matvey Varyvoda
 * @since 09.10.2021
 */
public interface IApplianceService {

    List<Appliance> get(Query<Appliance> query);

    Appliance getCheapest();

    void save(Appliance appliance);

}
