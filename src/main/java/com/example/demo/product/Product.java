package com.example.demo.product;

import java.sql.Date;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String barcode;
	private Double price;
	private Integer quantity;
	
	@CreationTimestamp
	private Date createdTimestamp;
	private Date detailsTimestamp;
	private Date priceTimestamp;
	private Date stockTimestamp;
	
	private String category = "MISC";
	
	private Long createdUserId;
	private Long stockUserId;
	private Long detailsUserId;
	private Long priceUserId;
	
	public Product() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getDetailsTimestamp() {
		return detailsTimestamp;
	}

	public void setDetailsTimestamp(Date detailsTimestamp) {
		this.detailsTimestamp = detailsTimestamp;
	}

	public Date getPriceTimestamp() {
		return priceTimestamp;
	}

	public void setPriceTimestamp(Date priceTimestamp) {
		this.priceTimestamp = priceTimestamp;
	}

	public Date getStockTimestamp() {
		return stockTimestamp;
	}

	public void setStockTimestamp(Date stockTimestamp) {
		this.stockTimestamp = stockTimestamp;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(Long createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Long getStockUserId() {
		return stockUserId;
	}

	public void setStockUserId(Long stockUserId) {
		this.stockUserId = stockUserId;
	}

	public Long getDetailsUserId() {
		return detailsUserId;
	}

	public void setDetailsUserId(Long detailsUserId) {
		this.detailsUserId = detailsUserId;
	}

	public Long getPriceUserId() {
		return priceUserId;
	}

	public void setPriceUserId(Long priceUserId) {
		this.priceUserId = priceUserId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", barcode=" + barcode + ", price=" + price + ", quantity="
				+ quantity + ", createdTimestamp=" + createdTimestamp + ", detailsTimestamp=" + detailsTimestamp
				+ ", priceTimestamp=" + priceTimestamp + ", stockTimestamp=" + stockTimestamp + ", category=" + category
				+ ", createdUserId=" + createdUserId + ", stockUserId=" + stockUserId + ", detailsUserId="
				+ detailsUserId + ", priceUserId=" + priceUserId + "]";
	}

	
}
