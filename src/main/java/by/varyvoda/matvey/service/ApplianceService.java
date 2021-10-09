package by.varyvoda.matvey.service;

import by.varyvoda.matvey.dao.DaoFactory;
import by.varyvoda.matvey.entity.Appliance;
import by.varyvoda.matvey.entity.criteria.Query;
import by.varyvoda.matvey.service.iface.IApplianceService;
import by.varyvoda.matvey.service.validation.Validator;

import java.util.List;

public class ApplianceService implements IApplianceService {

	@Override
	public List<Appliance> find(Query criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		
		return DaoFactory.getInstance().getApplianceDao().get(criteria);
	}

}
