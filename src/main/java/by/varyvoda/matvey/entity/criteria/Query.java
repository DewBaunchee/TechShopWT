package by.varyvoda.matvey.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Query {

	private final String groupSearchName;
	private final Map<String, Object> criteria = new HashMap<>();

	public Query(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}
	
	public String getGroupSearchName() {
		return groupSearchName;
	}

	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}
	
	// you may add your own code here

}
