package ma.enset.store.repository;

import ma.enset.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findProductByPriceGreaterThan(double p);
}
