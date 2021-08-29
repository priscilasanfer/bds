package com.devsuperior.bds01.controller;

import com.devsuperior.bds01.dto.DepartamentDto;
import com.devsuperior.bds01.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public ResponseEntity<List<DepartamentDto>> findAll() {
        List<DepartamentDto> list = service.findAll();
        return ResponseEntity.ok(list);
    }

}
