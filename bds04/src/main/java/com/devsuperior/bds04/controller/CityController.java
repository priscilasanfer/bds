package com.devsuperior.bds04.controller;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService service;

    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody @Valid CityDTO dto) {
        CityDTO city = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(city);
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){
        List<CityDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }
}
