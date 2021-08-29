package com.devsuperior.bds01.controller;

import com.devsuperior.bds01.dto.EmployeeDTO;
import com.devsuperior.bds01.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<Page<EmployeeDTO>> findAll(
            @PageableDefault(sort = "name", direction = Sort.Direction.ASC, page = 0, size = 12) Pageable pageable) {
        Page<EmployeeDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    private ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}
