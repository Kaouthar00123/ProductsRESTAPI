package resapi.productsapi.mapper;

import resapi.productsapi.dto.ProductDto;
import resapi.productsapi.entity.Product;

public class ProductMapper {
    public static Product ProductdtoToProduct(ProductDto productdto)
    {
        return new Product(productdto);
    }
    public static Product ProductdtoToProduct(Long id,  ProductDto productdto)
    {
        return new Product(id, productdto);
    }
    public static ProductDto ProductToProductdto(Product product)
    {
        return new ProductDto(product);
    }
}
