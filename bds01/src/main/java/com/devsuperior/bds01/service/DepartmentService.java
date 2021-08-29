package com.devsuperior.bds01.service;

import com.devsuperior.bds01.dto.DepartamentDto;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartamentRepository repository;

    @Transactional(readOnly = true)
    public List<DepartamentDto> findAll() {
        List<Department> list = repository.findAll();
        return list.stream()
                .map(DepartamentDto::new)
                .sorted(Comparator.comparing(DepartamentDto::getName))
                .collect(Collectors.toList());
    }

}
