package ma.enset.store;

import ma.enset.store.entities.Product;
import ma.enset.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StoreApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(StoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",2000,10));
        productRepository.save(new Product(null,"tablet",2500,20));
        productRepository.save(new Product(null,"cable",100,50));
        productRepository.save(new Product(null,"Phone",3000,15));
        List<Product> products = productRepository.findAll();
        products.forEach(p ->{System.out.println(p.toString());} );
        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("************************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("************************");
        product.setQuantity(15);
        productRepository.save(product);
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("************************");
        productRepository.deleteById(2L);
        products = productRepository.findAll();
        products.forEach(p ->{System.out.println(p.toString());} );
        System.out.println("************************");
        products = productRepository.findProductByPriceGreaterThan(2000);
        products.forEach(p ->{System.out.println(p.toString());} );
    }
}
