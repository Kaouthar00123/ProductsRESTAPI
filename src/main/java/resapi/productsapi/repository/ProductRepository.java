package resapi.productsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import resapi.productsapi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
