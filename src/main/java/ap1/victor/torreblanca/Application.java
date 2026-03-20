package ap1.victor.torreblanca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("🚀 Spring WebFlux + PostgreSQL (Neon)");
		System.out.println("📝 http://localhost:8080/api/products");
	}

}