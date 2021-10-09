package by.varyvoda.matvey.service.iface;

import by.varyvoda.matvey.entity.Appliance;
import by.varyvoda.matvey.entity.criteria.Query;

import java.util.List;

public interface IApplianceService {
	
	List<Appliance> find(Query criteria);
	
}
