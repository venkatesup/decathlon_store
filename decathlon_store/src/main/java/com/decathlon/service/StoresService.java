package com.decathlon.service;

import java.util.List;

import com.decathlon.dto.ProductDto;
import com.decathlon.dto.StoresDto;
import com.decathlon.entities.Store;

public interface StoresService {
	
	List<StoresDto> fetchAllStores();
	
	// below code need to modify 
	Store createStore(Store store);
	
	List<ProductDto> fetchAllProductsByStoreId(Integer storeId) throws Exception;
	
}
