package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2990.entities.Empregado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
    @Query(nativeQuery = true, value = "select e.cpf, e.enome, d.dnome " +
            "from empregados e " +
            "inner join departamentos d on e.dnumero = d.dnumero " +
            "where e.cpf not in (" +
            "select e.cpf " +
            "from empregados e " +
            "inner join trabalha t on t.cpf_emp = e.cpf ) " +
            "order by e.cpf")
    List<EmpregadoDeptProjection> search1();

    @Query(nativeQuery = true, value = "select e.cpf, e.enome, d.dnome " +
            "from empregados e " +
            "inner join departamentos d on e.dnumero = d.dnumero " +
            "left join trabalha t on t.cpf_emp = e.cpf " +
            "where t.cpf_emp is null " +
            "order by e.cpf ")
    List<EmpregadoDeptProjection> search2();

    @Query("select new com.devsuperior.uri2990.dto.EmpregadoDeptDTO(e.cpf, e.enome, e.departamento.dnome) " +
            "from Empregado e " +
            "where e.cpf not in (" +
            "  select e.cpf " +
            "  from Empregado e " +
            "  inner join e.projetosOndeTrabalha ) " +
            "order by e.cpf")
    List<EmpregadoDeptDTO> search3();
}
