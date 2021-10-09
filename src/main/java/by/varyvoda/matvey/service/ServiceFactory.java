package by.varyvoda.matvey.service;

import by.varyvoda.matvey.service.iface.IApplianceService;

public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final IApplianceService applianceService = new ApplianceService();
	
	private ServiceFactory() {}

	public IApplianceService getApplianceService() {

		return applianceService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}

}
