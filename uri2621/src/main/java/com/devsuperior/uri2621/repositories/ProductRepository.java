package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projection.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT p.name " +
            "FROM products p " +
            "INNER JOIN providers pr " +
            "ON p.id_providers = pr.id " +
            "WHERE pr.name LIKE :name% " +
            "AND p.amount BETWEEN :min AND :max")
    List<ProductMinProjection> search1(Long min, Long max, String name);

}
