package net.elyaacoubi.mvcspring;

import net.elyaacoubi.mvcspring.entities.Product;
import net.elyaacoubi.mvcspring.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MvcSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcSpringApplication.class, args);
    }

    //bean ce sont les methodes qui seront executer au demarage
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            //utilisation du builder c est plus pratique puisqon a pas besoin de se souvenir d'ordre du param
            Product product = Product.builder()
                            .name("computer").price(5000).quantity(50)
                            .build();
            productRepository.save(product);
            productRepository.save(Product.builder().name("Printer").price(4500).quantity(4).build());
            productRepository.save(Product.builder().name("Smartphone").price(15000).quantity(5).build());
            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };
    }
}
