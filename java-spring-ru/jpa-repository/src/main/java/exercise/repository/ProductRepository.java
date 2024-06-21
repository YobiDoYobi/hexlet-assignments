package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    List<Product> findAllByPriceBetweenOrderByPrice(int min, int max);
    List<Product> findAllByPriceGreaterThanOrderByPrice(int min);
    List<Product> findAllByPriceLessThanOrderByPrice(int max);
    // END
}
