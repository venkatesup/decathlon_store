package com.decathlon.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.decathlon.store.entities.Store;

public interface StoreRepository extends JpaRepository<Store, Integer> {

	
}
