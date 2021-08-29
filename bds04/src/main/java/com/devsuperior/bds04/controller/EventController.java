package com.devsuperior.bds04.controller;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @PostMapping
    public ResponseEntity<EventDTO> insert(@RequestBody @Valid EventDTO dto) {
        EventDTO event = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(event);
    }

    @GetMapping
    public ResponseEntity<Page<EventDTO>> findAll(
        @PageableDefault(sort = "name", direction = Sort.Direction.ASC, page = 0, size = 12) Pageable pageable) {
        Page<EventDTO> list = service.findAll(pageable);
        return ResponseEntity.ok().body(list);

    }
}
