package graduation.demo.pharmacymanagementsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import graduation.demo.pharmacymanagementsystem.entity.Product;
import graduation.demo.pharmacymanagementsystem.service.ProductsService;

@RestController
@RequestMapping("/api")
public class ProductsRestController {

	private ProductsService productsService;
	
	@Autowired
	public ProductsRestController(ProductsService theProductsService) {
		productsService = theProductsService;
	}
	

	// expose "/products" and return list of products
	@GetMapping("/products")
	public List <Product> findAllProducts() {
		return productsService.findAllProducts();
	}

	// add mapping for GET /products/{productCode} - to get product by code
	
	@GetMapping("/products/{productCode}")
	public Product getProduct(@PathVariable int productCode) {
		
		Product theProduct = productsService.findByCode(productCode);
		
		if (theProduct == null) {
			throw new RuntimeException("Employee id not found - " + productCode);
		}
		
		return theProduct;
	}
	
	// add mapping for GET /products/{productName} - to get product by name
	
	@GetMapping("/products_search/{productName}")
	public List<Product> getProduct(@PathVariable String productName) {
		
		List<Product> theProduct = productsService.searchByName(productName);
		
		if (theProduct == null) {
			throw new RuntimeException("product not found " + productName);
		}
		
		return theProduct;
	}
	
	// add mapping for GET /products/{productName} - to get product by the two categories
	
		@GetMapping("/products_category_search/{main_category}/{secondary_category}")
		public List<Product> getProduct(@PathVariable String main_category ,@PathVariable String secondary_category) {
			
			List<Product> theProducts = productsService.select_by_category(main_category, secondary_category);
			
			if (theProducts == null) {
				throw new RuntimeException(" empty category " );
			}
			
			return theProducts;
		}
	
	
	
	
	// add mapping for POST /products - add new products
	
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product theProduct) {
		
		// also just in case they pass an id in JSON ... set id to 0
		
		// this is to force a save of new item ... instead of update
		
		theProduct.setCode(0);
		
		productsService.saveORupdate(theProduct);
		
		return theProduct;
	}
	
	
	// add mapping for PUT /products - update existing product
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product theProduct) {
		
		productsService.saveORupdate(theProduct);
		
		return theProduct;
	}
	
	
	// add mapping for DELETE /products/{productCode} - delete product
	
	@DeleteMapping("/products/{productCode}")
	public String deleteProduct(@PathVariable int productCode) {
		
		Product tempProduct = productsService.findByCode(productCode);
		
		// throw exception if null
		
		if (tempProduct == null) {
			throw new RuntimeException("Product code not found - " + productCode);
		}
		
		productsService.deleteByCode(productCode);
		
		return "Deleted product id - " + productCode;
	}

	
	
	
}
