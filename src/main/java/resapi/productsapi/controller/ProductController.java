package resapi.productsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resapi.productsapi.dto.ProductDto;
import resapi.productsapi.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productservice;


    @PostMapping
    public ResponseEntity<ProductDto> createproduct(@RequestBody ProductDto productDto)
    {
        return new ResponseEntity<>(productservice.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllproducts()
    {
        List<ProductDto> response = productservice.getAllProducts();
        return ResponseEntity.ok(response);
    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getproductById(@PathVariable("id") Long productId )
    {
        ProductDto response = productservice.getProductById(productId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateproductById(@PathVariable("id") Long productId, @RequestBody ProductDto productDto )
    {
        ProductDto response = productservice.updateProductById(productId, productDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteproductById(@PathVariable("id") Long productId )
    {
        productservice.deleteProductById(productId);
        return ResponseEntity.ok("product succefully deleted");
    }
}
