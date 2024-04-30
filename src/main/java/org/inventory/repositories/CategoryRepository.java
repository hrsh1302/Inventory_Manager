package org.inventory.repositories;

import org.inventory.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Override
    Iterable<Category> findAll();

    @Override
    Optional<Category> findById(Integer integer);

    @Override
    Iterable<Category> findAllById(Iterable<Integer> integers);

    @Override
    <S extends Category> S save(S entity);

    @Override
    void delete(Category entity);

    @Override
    void deleteAll();

    @Override
    void deleteById(Integer integer);
}
