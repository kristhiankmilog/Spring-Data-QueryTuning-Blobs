package edu.eci.cosw.examples.productorders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("edu.eci.cosw.examples.productorders.repositories")
@EntityScan("edu.eci.cosw.samples.model")
public class ProductordersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductordersApiApplication.class, args);
	}
        
}
