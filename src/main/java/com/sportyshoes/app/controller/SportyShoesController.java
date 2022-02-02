package com.sportyshoes.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.app.exception.RecordNotFoundException;
import com.sportyshoes.app.model.Product;
import com.sportyshoes.app.model.PurchaseOrderUserDetail;
import com.sportyshoes.app.model.User;
import com.sportyshoes.app.repository.SportyShoesProductRepository;
import com.sportyshoes.app.repository.SportyShoesPurchaseOrderUserDetailRepository;
import com.sportyshoes.app.repository.SportyShoesUserRepository;

@RestController
@RequestMapping("sportyshoes")
public class SportyShoesController {

	@Autowired
	SportyShoesProductRepository sportyShoesProductRepository;

	@Autowired
	SportyShoesUserRepository sportyShoesUserRepository;

	@Autowired
	SportyShoesPurchaseOrderUserDetailRepository sportyShoesPurchaseOrderUserDetailRepository;

	// products resource start

	// insert new product into database
	@PostMapping("products/add")
	public Product createProduct(@RequestBody Product product) {
		return sportyShoesProductRepository.save(product);
	}

	// update existing product
	@PutMapping("products/update/{id}")
	public Product updateProductById(@RequestBody Product product) {
		return sportyShoesProductRepository.save(product);
	}

	// get particular product by their ID
	@GetMapping("products/get/{id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		Optional<Product> product = sportyShoesProductRepository.findById(id);
		if (product.isPresent()) {
			return product;
		} else {
			throw new RecordNotFoundException("Product id not found : " + id);
		}
	}

	// retrieve all products from database
	@GetMapping("products/all")
	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) sportyShoesProductRepository.findAll();
		return products;
	}

	// delete particular product from database
	@DeleteMapping("products/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		sportyShoesProductRepository.deleteById(id);
	}

	// delete all products from database
	@DeleteMapping("products/deleteAll")
	public void deleteAllBook() {
		List<Product> products = (List<Product>) sportyShoesProductRepository.findAll();
		sportyShoesProductRepository.deleteAll(products);
	}

	// find product by season from database
	@RequestMapping(value = "products/season/{season}", method = RequestMethod.GET)
	public Iterable<Product> findBySeason(@PathVariable("season") String season) {
		return sportyShoesProductRepository.findBySeason(season);
	}

	// find product by brand from database
	@RequestMapping(value = "products/brand/{brand}", method = RequestMethod.GET)
	public Iterable<Product> findByBrand(@PathVariable("brand") String brand) {
		return sportyShoesProductRepository.findByBrand(brand);
	}

	// find product by category from database
	@RequestMapping(value = "products/category/{category}", method = RequestMethod.GET)
	public Iterable<Product> findByCategory(@PathVariable("category") String category) {
		return sportyShoesProductRepository.findByCategory(category);
	}

	// find product by price from database
	@RequestMapping(value = "products/price/{order}", method = RequestMethod.GET)
	public List<Product> findByPrice(@PathVariable("order") String order) {
		List<Product> products = null;
		if (order.equalsIgnoreCase("asc")) {
			products = sportyShoesProductRepository.findAll(Sort.by("price").ascending());
		} else if (order.equalsIgnoreCase("desc")) {
			products = sportyShoesProductRepository.findAll(Sort.by("price").descending());
		}
		return products;
	}

	// find product by color from database
	@RequestMapping(value = "products/color/{color}", method = RequestMethod.GET)
	public Iterable<Product> findByColor(@PathVariable("color") String color) {
		return sportyShoesProductRepository.findByColor(color);
	}

	// find product by createdDate from database
	@RequestMapping(value = "products/createdDate/{createdDate}", method = RequestMethod.GET)
	public Iterable<Product> findByCreatedDate(@PathVariable("createdDate") String createdDate) throws ParseException {
		return sportyShoesProductRepository.findByCreatedDate(createdDate);
	}

	// find product by createdDate from database
	@RequestMapping(value = "products/createdDate", method = RequestMethod.GET)
	public Iterable<Product> findByCreatedDate() throws ParseException {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return sportyShoesProductRepository.findByCreatedDate(date);
	}

	// products resource end

	// users resource start

	// retrieve all users from database
	@GetMapping("users/all")
	public List<User> getAllUsers() {
		List<User> users = (List<User>) sportyShoesUserRepository.findAll();
		return users;
	}

	// users resource end

	// purchase order resource start

	// retrieve all purchaseOrder -> product details filtered by date and category
	// from database
	@RequestMapping(value = "purchaseOrder/products/createdDate/{createdDate}/category/{category}", method = RequestMethod.GET)
	public Iterable<Product> getAllPOProductDetails(@PathVariable("createdDate") String createdDate,
			@PathVariable("category") String category) throws ParseException {
		List<Product> productOrderProductDetails = (List<Product>) sportyShoesProductRepository
				.findByCreatedDateAndCategory(createdDate, category);
		return productOrderProductDetails;
	}

	// retrieve all purchaseOrder -> users details filtered by date and category
	// from database
	@RequestMapping(value = "purchaseOrder/users/createdDate/{createdDate}/category/{category}", method = RequestMethod.GET)
	public Iterable<PurchaseOrderUserDetail> getAllPOUserDetails(@PathVariable("createdDate") String createdDate,
			@PathVariable("category") String category) {
		List<PurchaseOrderUserDetail> productOrderUserDetails = (List<PurchaseOrderUserDetail>) sportyShoesPurchaseOrderUserDetailRepository
				.findByCreatedDateAndCategory(createdDate, category);
		return productOrderUserDetails;
	}

	// purchase order resource end

}
