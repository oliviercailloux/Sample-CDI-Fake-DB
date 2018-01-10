package io.github.oliviercailloux.sample_cdi_fake_db;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FakeDatabase {
	private List<String> customerNames = new ArrayList<>();

	private Map<Integer, String> productNamesById = new LinkedHashMap<>();

	public FakeDatabase() {
		init();
	}

	public List<String> getCustomerNames() {
		return customerNames;
	}

	public Map<Integer, String> getProductNamesById() {
		return productNamesById;
	}

	private void init() {
		customerNames.add("Name 1");
		customerNames.add("Name 2");
		customerNames.add("Name 3");
		productNamesById.put(1, "Product 1");
		productNamesById.put(2, "Product 2");
	}
}
