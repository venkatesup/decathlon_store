package com.decathlon.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decathlon.dto.ProductDto;
import com.decathlon.dto.StoresDto;
import com.decathlon.entities.Product;
import com.decathlon.entities.Store;
import com.decathlon.repository.StoreRepository;

@Service
public class StoresServiceImpl implements StoresService {

	@Autowired
	StoreRepository storeRepository;


	@Override
	public List<StoresDto> fetchAllStores() {
		
		List<Store> storesList=storeRepository.findAll();
		
		List<StoresDto> storesDto=null;
		
		if(storesList!=null && !storesList.isEmpty()){
			
			storesDto=storesList.stream().map(store -> new StoresDto(store.getStoreId(),store.getStoreName(),store.getStoreCity())).collect(Collectors.toList());
			
		}
		return storesDto;
	}


	@Override
	public Store createStore(Store store) {
		
		return storeRepository.save(store);
	}


	@Override
	public List<ProductDto> fetchAllProductsByStoreId(Integer storeId) throws Exception {
		
		Optional<Store> store = storeRepository.findById(storeId);
		
		if (!store.isPresent()) {
			throw new Exception("Invalid storeId" + storeId);
		}
	
		List<Product> productsList = store.get().getProducts();
		List<ProductDto> productDtos=null;
		
		if(productsList!=null && !productsList.isEmpty()){
			
			productDtos=productsList.stream().map(pro -> new ProductDto(pro.getProductId(),pro.getProductName(),
					pro.getProductDescription(),pro.getProductLevel(),pro.getProductSport())).collect(Collectors.toList());
		}
		
		return productDtos;
	}
	
	
	
	
}
