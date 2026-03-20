package ap1.victor.torreblanca.service;

import ap1.victor.torreblanca.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> create(Product product);
    Flux<Product> findAll();
    Mono<Product> findById(Long id);
    Mono<Product> update(Long id, Product product);
    Mono<Void> delete(Long id);
    Flux<Product> findByCategory(String category);
    Flux<Product> findAvailable();
}