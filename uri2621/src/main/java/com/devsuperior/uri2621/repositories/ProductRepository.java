package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDTO;
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
            "WHERE pr.name LIKE CONCAT(:name, '%') " +
            "AND p.amount BETWEEN :min AND :max")
    List<ProductMinProjection> search1(Integer min, Integer max, String name);

    @Query("SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(p.name) " +
            "FROM Product p " +
            "WHERE p.provider.name LIKE CONCAT(:name, '%')" +
            "AND p.amount BETWEEN :min AND :max")
    List<ProductMinDTO> search2(Integer min, Integer max, String name);

}
