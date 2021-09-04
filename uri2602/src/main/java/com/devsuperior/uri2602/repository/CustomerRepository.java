package com.devsuperior.uri2602.repository;

import com.devsuperior.uri2602.projection.CustomerMinProjection;
import com.devsuperior.uri2602.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true, value = "select c.name from customers c where c.state = :state")
    List<CustomerMinProjection> search1(String state);
}
