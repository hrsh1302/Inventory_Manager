package org.inventory;

import org.assertj.core.api.Assertions;
import org.inventory.entities.Product;
import org.inventory.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository repo;

    @Test
    public void testAdd() {
        Product banana = new Product();
        banana.setId(10000);
        banana.setName("nene");
        banana.setCategory("haha");
        banana.setQuantity(100);
        banana.setMinQuantity(1);
        banana.setPrice(1.00);
        banana.setDescription("Red :)");

        Product savedBanana = repo.save(banana);

        Assertions.assertThat(savedBanana).isNotNull();
    }

    @Test
    public void testList() {
        for (Product product : repo.findAll()) {
            System.out.println(product);
        }
    }

    @Test
    public void modifyProduct() {
        String name = "banana";
        for (Product product : repo.findAll()) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.setName("Orange");
                product.setDescription("Orange round and juicy <>");
                repo.save(product);
            }
        }
    }

    @Test
    public void getProductById() {
        Integer userID = 2;
        Optional<Product> optionalProduct = repo.findById(userID);
        Assertions.assertThat(optionalProduct).isPresent();
        System.out.println(optionalProduct.get());
    }

    @Test
    public void removeByID() {
        //Remove if ID is known
        Integer userID = 12;
        repo.deleteById(userID);
        Optional<Product> optionalProduct = repo.findById(userID);
        Assertions.assertThat(optionalProduct).isEmpty();

    }

    @Test
    public void removeByName() {

        //Remove by name
        String name = "Orange";
        for (Product product : repo.findAll()) {
            if (product.getName().equalsIgnoreCase(name))
                repo.delete(product);
            break;
        }
        Optional<Product> optionalProduct1 = Optional.ofNullable(repo.findProductByName(name));
        Assertions.assertThat(optionalProduct1).isEmpty();
    }
}
