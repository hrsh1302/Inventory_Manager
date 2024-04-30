package org.inventory.repositories;

import org.inventory.entities.Category;
import org.inventory.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Override
    Iterable<Product> findAll();

    @Override
    Optional<Product> findById(Integer integer);

    @Override
    Iterable<Product> findAllById(Iterable<Integer> integers);

    @Override
    <S extends Product> S save(S entity);

    @Override
    void delete(Product entity);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);

    Product findProductByName(String name);

}
