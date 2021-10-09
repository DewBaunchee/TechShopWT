package by.varyvoda.matvey.main;


import by.varyvoda.matvey.entity.Appliance;
import by.varyvoda.matvey.entity.criteria.Query;
import by.varyvoda.matvey.entity.criteria.SearchCriteria;
import by.varyvoda.matvey.service.iface.IApplianceService;
import by.varyvoda.matvey.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		IApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Query criteriaOven = new Query(SearchCriteria.OvenCriteria.class.getSimpleName());//"Oven"
		criteriaOven.add(SearchCriteria.OvenCriteria.CAPACITY.toString(), 3);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Query(SearchCriteria.OvenCriteria.class.getSimpleName());
		criteriaOven.add(SearchCriteria.OvenCriteria.HEIGHT.toString(), 200);
		criteriaOven.add(SearchCriteria.OvenCriteria.DEPTH.toString(), 300);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////
		
		Query criteriaTabletPC = new Query(SearchCriteria.TabletPCCriteria.class.getSimpleName());
		criteriaTabletPC.add(SearchCriteria.TabletPCCriteria.COLOR.toString(), "BLUE");
		criteriaTabletPC.add(SearchCriteria.TabletPCCriteria.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(SearchCriteria.TabletPCCriteria.MEMORY_ROM.toString(), 4);

		appliance = service.find(criteriaOven);// find(Object...obj)

		PrintApplianceInfo.print(appliance);

	}

}
