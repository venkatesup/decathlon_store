package com.decathlon.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class StoresDto {

	
	private Integer storeId;
	
	@ApiModelProperty(required=true)
	@NotNull(message="storeName can't be null")
	private String storeName;
	
	@NotNull(message="storeCity can't be null")
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
