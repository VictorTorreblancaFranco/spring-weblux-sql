package ap1.victor.torreblanca.repository;

import ap1.victor.torreblanca.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT * FROM product WHERE category = :category")
    List<Product> findByCategory(String category);

    @Query("SELECT * FROM product WHERE available = true")
    List<Product> findByAvailableTrue();
}