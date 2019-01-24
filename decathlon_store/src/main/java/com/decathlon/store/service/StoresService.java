package com.decathlon.store.service;

import java.util.List;

import com.decathlon.store.dto.ProductDto;
import com.decathlon.store.dto.StoresDto;
import com.decathlon.store.entities.Store;

public interface StoresService {

	public List<StoresDto> fetchAllStores();

	// below code need to modify
	public Store createStore(Store store);

	public List<ProductDto> fetchAllProductsByStoreId(Integer storeId)
			throws Exception;

	public StoresDto findById(Integer storeId);

}
