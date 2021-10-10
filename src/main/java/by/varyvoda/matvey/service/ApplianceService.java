package by.varyvoda.matvey.service;

import by.varyvoda.matvey.dao.DaoFactory;
import by.varyvoda.matvey.entity.Appliance;
import by.varyvoda.matvey.entity.criteria.Query;
import by.varyvoda.matvey.service.iface.IApplianceService;

import java.util.Comparator;
import java.util.List;

public class ApplianceService implements IApplianceService {

	@Override
	public List<Appliance> get(Query<Appliance> query) {
		return DaoFactory.getInstance().getApplianceDao().get(query);
	}

	@Override
	public Appliance getCheapest() {
		return DaoFactory.getInstance()
				.getApplianceDao()
				.get(new Query<>(Appliance.class)).stream()
				.min(Comparator.comparing(Appliance::getPrice))
				.orElse(null);
	}

}
