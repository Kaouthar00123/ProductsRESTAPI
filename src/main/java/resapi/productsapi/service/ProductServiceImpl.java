package resapi.productsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resapi.productsapi.dto.ProductDto;
import resapi.productsapi.entity.Product;
import resapi.productsapi.exception.ResourceNotFoundException;
import resapi.productsapi.mapper.ProductMapper;
import resapi.productsapi.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productrepo;

    @Override
    public ProductDto createProduct(ProductDto objectdto) {
        Product object = ProductMapper.ProductdtoToProduct(objectdto);
        return ProductMapper.ProductToProductdto(productrepo.save (object));
    }

    @Override
    public List<ProductDto> getAllProducts()
    {
        return (productrepo.findAll().stream().map((emp)->ProductMapper.ProductToProductdto(emp))).collect(Collectors.toList());

    }

    @Override
    public ProductDto getProductById(Long ProductId) {
        Product response =  productrepo.findById(ProductId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product is not exists with given id : " + ProductId));
        return ProductMapper.ProductToProductdto(response);
    }

    @Override
    public ProductDto updateProductById(Long ProductId, ProductDto objectto) {
        Product response =  productrepo.findById(ProductId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product is not exists with given id : " + ProductId));
        //plain response with infos found
        return ProductMapper.ProductToProductdto(productrepo.save(ProductMapper.ProductdtoToProduct(response.getId(), objectto)));
    }

    @Override
    public void deleteProductById(Long ProductId) {
        productrepo.findById(ProductId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product is not exists with given id : " + ProductId));

        productrepo.deleteById(ProductId);
    }
}
