package com.devsuperior.bds01.service;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.entities.Employee;
import com.devsuperior.bds01.repository.DepartamentRepository;
import com.devsuperior.bds01.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DepartamentRepository departamentRepository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<Employee> list = repository.findAll(pageable);
        return list.map(EmployeeDTO::new);
    }

    @Transactional
    public EmployeeDTO insert(EmployeeDTO dto) {
        Employee entity = new Employee();
        converterDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new EmployeeDTO(entity);
    }

    private void converterDtoToEntity(EmployeeDTO dto, Employee entity) {
        entity.setEmail(dto.getEmail());
        entity.setName(dto.getName());
        Optional<Department> department = departamentRepository.findById(dto.getDepartmentId());
        department.ifPresent(entity::setDepartment);
    }
}
