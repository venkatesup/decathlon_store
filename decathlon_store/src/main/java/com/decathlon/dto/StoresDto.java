package com.decathlon.dto;

public class StoresDto {

	private Integer storeId;
	private String storeName;
	private String storeCity;
	
	
	public StoresDto() {
	
	}
	
	public StoresDto(Integer storeId, String storeName, String storeCity) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeCity = storeCity;
	}



	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreCity() {
		return storeCity;
	}
	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
	}
	
}
