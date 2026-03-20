package ap1.victor.torreblanca.service.impl;

import ap1.victor.torreblanca.model.Product;
import ap1.victor.torreblanca.repository.ProductRepository;
import ap1.victor.torreblanca.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Mono<Product> create(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        return Mono.just(productRepository.save(product));
    }

    @Override
    public Flux<Product> findAll() {
        return Flux.fromIterable(productRepository.findAll());
    }

    @Override
    public Mono<Product> findById(Long id) {
        return Mono.justOrEmpty(productRepository.findById(id));
    }

    @Override
    public Mono<Product> update(Long id, Product product) {
        return Mono.justOrEmpty(productRepository.findById(id))
                .flatMap(existing -> {
                    existing.setName(product.getName());
                    existing.setDescription(product.getDescription());
                    existing.setPrice(product.getPrice());
                    existing.setStock(product.getStock());
                    existing.setCategory(product.getCategory());
                    existing.setBrand(product.getBrand());
                    existing.setSku(product.getSku());
                    existing.setAvailable(product.getAvailable());
                    existing.setRating(product.getRating());
                    return Mono.just(productRepository.save(existing));
                });
    }

    @Override
    public Mono<Void> delete(Long id) {
        return Mono.fromRunnable(() -> productRepository.deleteById(id));
    }

    @Override
    public Flux<Product> findByCategory(String category) {
        return Flux.fromIterable(productRepository.findByCategory(category));
    }

    @Override
    public Flux<Product> findAvailable() {
        return Flux.fromIterable(productRepository.findByAvailableTrue());
    }
}