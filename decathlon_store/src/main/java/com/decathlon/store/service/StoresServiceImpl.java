package com.decathlon.store.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decathlon.store.dto.ProductDto;
import com.decathlon.store.dto.StoresDto;
import com.decathlon.store.entities.Product;
import com.decathlon.store.entities.Store;
import com.decathlon.store.repository.StoreRepository;

@Service
public class StoresServiceImpl implements StoresService {

	private static final Logger logger = Logger
			.getLogger(StoresServiceImpl.class);

	@Autowired
	StoreRepository storeRepository;

	@Override
	public List<StoresDto> fetchAllStores() {

		logger.info("retriveAllStores in service class class");

		List<Store> storesList = storeRepository.findAll();

		List<StoresDto> storesDto = null;

		if (storesList != null && !storesList.isEmpty()) {

			storesDto = storesList
					.stream()
					.map(store -> new StoresDto(store.getStoreId(), store
							.getStoreName(), store.getStoreCity()))
					.collect(Collectors.toList());

		}
		return storesDto;
	}

	@Override
	public Store createStore(Store store) {

		return storeRepository.save(store);
	}

	@Override
	public List<ProductDto> fetchAllProductsByStoreId(Integer storeId)
			throws Exception {

		Optional<Store> store = storeRepository.findById(storeId);

		if (!store.isPresent()) {
			throw new Exception("Invalid storeId" + storeId);
		}

		List<Product> productsList = store.get().getProducts();
		List<ProductDto> productDtos = null;

		if (productsList != null && !productsList.isEmpty()) {

			productDtos = productsList
					.stream()
					.map(pro -> new ProductDto(pro.getProductId(), pro
							.getProductName(), pro.getProductDescription(), pro
							.getProductLevel(), pro.getProductSport()))
					.collect(Collectors.toList());
		}

		return productDtos;
	}

	@Override
	public StoresDto findById(Integer storeId) {
		Optional<Store> store = storeRepository.findById(storeId);
		StoresDto storesDto = new StoresDto();
		storesDto.setStoreCity(store.get().getStoreCity());
		storesDto.setStoreName(store.get().getStoreName());
		storesDto.setStoreId(store.get().getStoreId());
		return storesDto;
	}

}
