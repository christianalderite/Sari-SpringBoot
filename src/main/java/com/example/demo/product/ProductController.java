package com.example.demo.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable String id) {
		long productId = Long.parseLong(id);
		return productRepository.getOne(productId);
	}
	
	@PostMapping("/product")
	public Product create(@RequestBody Map<String, String> body) {
		Long detailsUserId = Long.parseLong(body.get("detailsUserId"));
		Double price = Double.parseDouble(body.get("price"));
		Integer quantity = Integer.parseInt(body.get("quantity"));
		Product product = new Product();
		product.setName(body.get("name"));
		product.setBarcode(ifStringEmpty(body.get("barcode"),"NO_BARCODE"));
		product.setCategory(body.get("category"));
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setDetailsUserId(detailsUserId);
		product.toString();
		return productRepository.save(product);
	}
	
	@PutMapping("/product/details/{id}")
	public Product updateDetails(@PathVariable String id, @RequestBody Map<String, String> body) {
		Long productId = Long.parseLong(id);
		Long detailsUserId = Long.parseLong(body.get("detailsUserId"));
		Product product = productRepository.getOne(productId);
		product.setName(body.get("name"));
		product.setBarcode(body.get("barcode"));
		product.setCategory(body.get("category"));
		product.setDetailsUserId(detailsUserId);
		return productRepository.save(product);
    }
	
	@PutMapping("/product/price/{id}")
	public Product updatePrice(@PathVariable String id, @RequestBody Map<String, String> body) {
		Long productId = Long.parseLong(id);
		Long priceUserId = Long.parseLong(body.get("priceUserId"));
		Double price = Double.parseDouble(body.get("price"));
		Product product = productRepository.getOne(productId);
		product.setPriceUserId(priceUserId);
		product.setPrice(price);
		return productRepository.save(product);
    }
	
	@PutMapping("/product/stock/{id}")
	public Product updateStock(@PathVariable String id, @RequestBody Map<String, String> body) {
		Long productId = Long.parseLong(id);
		Long stockUserId = Long.parseLong(body.get("priceUserId"));
		Integer quantity = Integer.parseInt(body.get("quantity"));
		Product product = productRepository.getOne(productId);
		product.setStockUserId(stockUserId);
		product.setQuantity(quantity);
		return productRepository.save(product);
    }
	
	@DeleteMapping("/product/{id}")
	public boolean delete(@PathVariable String id) {
    	long productId = Long.parseLong(id);
    	productRepository.deleteById(productId);
    	return true;
    }
	
	private String ifStringEmpty(String s, String alt){
		if(s == null || s.equals("")) {
			return alt;
		}else {
			return s;
		}
	}
	
}
