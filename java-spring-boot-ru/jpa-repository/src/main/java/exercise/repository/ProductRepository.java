package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;
import java.lang.Integer;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    List<Product> findByPriceBetween(Integer min, Integer max, Sort sort);
    List<Product> findByPriceLessThan(Integer max, Sort sort);
    List<Product> findByPriceGreaterThan(Integer min, Sort sort);
    // END
}
