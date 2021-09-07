package com.devsuperior.uri2737.repositories;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2737.entities.Lawyer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
    @Query(nativeQuery = true, value = "(select l.name, l.customers_number as customersNumber " +
            "from lawyers l " +
            "order by l.customers_number desc " +
            "limit 1) " +
            "union all " +
            "(select l.name, l.customers_number " +
            "from lawyers l " +
            "order by l.customers_number asc " +
            "limit 1) " +
            "union all " +
            "select 'Average', round( avg(l.customers_number ), 0) " +
            "from lawyers l")
    List<LawyerMinProjection> search1();

    @Query(nativeQuery = true, value = "(select l.name, l.customers_number as customersNumber "+
            "from lawyers l " +
            "where l.customers_number = ( " +
            "select MAX(l2.customers_number) " +
            "from lawyers l2 " +
            ")) " +
            "union all " +
            "(select l.name, l.customers_number " +
            "from lawyers l " +
            "where l.customers_number = (" +
            "select MIN(l2.customers_number) " +
            "from lawyers l2 " +
            ")) " +
            "union all " +
            "select 'Average', round( avg(l.customers_number ), 0)" +
            "from lawyers l ;")
    List<LawyerMinProjection> search2();

}
