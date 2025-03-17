package resapi.productsapi.service;


import resapi.productsapi.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto product);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long ProductId);
    ProductDto updateProductById(Long ProductId, ProductDto product);
    void deleteProductById(Long ProductId);
}
