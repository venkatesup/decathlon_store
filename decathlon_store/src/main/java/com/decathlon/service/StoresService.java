package com.decathlon.service;

import java.util.List;

import com.decathlon.dto.ProductDto;
import com.decathlon.dto.StoresDto;
import com.decathlon.entities.Store;

public interface StoresService {

	public List<StoresDto> fetchAllStores();

	// below code need to modify
	public Store createStore(Store store);

	public List<ProductDto> fetchAllProductsByStoreId(Integer storeId)
			throws Exception;

	public StoresDto findById(Integer storeId);

}
