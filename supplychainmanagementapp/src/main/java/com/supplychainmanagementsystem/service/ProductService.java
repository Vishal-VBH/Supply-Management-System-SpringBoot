package com.supplychainmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.supplychainmanagementsystem.dao.ProductDao;
import com.supplychainmanagementsystem.dto.ResponseStructure;
import com.supplychainmanagementsystem.entity.Product;
import com.supplychainmanagementsystem.exceptionpackage.IdNotFoundException;
import com.supplychainmanagementsystem.exceptionpackage.NoRecordFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDao productdao;
	
	
	public ResponseEntity<ResponseStructure<Product>> addProduct(Product product){
		Product recieveproduct=productdao.addProduct(product);
		ResponseStructure<Product> structure= new ResponseStructure<Product>();
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setMessage("Added product successfully");
		structure.setData(recieveproduct);
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
	}
	
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product){
		Product recieveproduct=productdao.updateProduct(product);
		ResponseStructure<Product> structure= new ResponseStructure<Product>();
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setMessage("Product updated successfully");
		structure.setData(recieveproduct);
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts(){
		List<Product> productlist=productdao.getAllProducts();
		ResponseStructure<List<Product>> structure= new ResponseStructure<List<Product>>();
		if(!productlist.isEmpty()) {
		structure.setStatuscode(HttpStatus.CREATED.value());
		structure.setMessage("All Product fetched successfully");
		structure.setData(productlist);
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.CREATED);
		}
		else {
			throw new NoRecordFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteProductById(int id){
		Optional<Product> opt=productdao.deleteProductById(id);
		ResponseStructure<Product> structure= new ResponseStructure<Product>();
		if(opt.isPresent()) {
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Product deleted successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<Product>> getProductById(int id){
		Optional<Product> opt=productdao.getProductById(id);
		ResponseStructure<Product> structure= new ResponseStructure<Product>();
		if(opt.isPresent()) {
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Product fetched successfully");
		structure.setData(opt.get());
		return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getProductBySupplierId(int id){
		List<Product> productList=productdao.getProductBySupplierId(id);
		ResponseStructure<List<Product>> structure= new ResponseStructure<List<Product>>();
		if(!productList.isEmpty()) {
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		structure.setMessage("Products fetched successfully");
		structure.setData(productList);
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
}
