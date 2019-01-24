package com.decathlon.store.controller;

import java.net.URI;
import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.decathlon.store.dto.ProductDto;
import com.decathlon.store.dto.StoresDto;
import com.decathlon.store.entities.Store;
import com.decathlon.store.service.StoresService;

@RestController
@RequestMapping(value = "/v1/public/stores")
public class StoresController {

	private static final Logger logger = Logger
			.getLogger(StoresController.class);

	@Autowired
	private StoresService storesService;

	@GetMapping("/{storeId}/products")
	public List<ProductDto> fetchAllProductsByStoreId(
			@PathVariable("storeId") Integer storeId) throws Exception {

		logger.log(Level.INFO, "fetchAllProductsByStoreId");

		return storesService.fetchAllProductsByStoreId(storeId);
	}

	@PostMapping
	public ResponseEntity<Store> createStore(@RequestBody Store store) {

		// TODO : Need to change entity class request object to dto object
		Store dbStore = storesService.createStore(store);

		// setting header for current url path with Id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{storeId}").buildAndExpand(dbStore.getStoreId())
				.toUri();
		return ResponseEntity.created(uri).build();

	}

	@GetMapping("/stores")
	public List<StoresDto> retriveAllStores() {
		logger.info("retriveAllStores in controller class");
		return storesService.fetchAllStores();
	}

	@GetMapping("/{storeId}")
	public StoresDto findByStoreId(@PathVariable("storeId") Integer storeId) {
		return storesService.findById(storeId);
	}

}
