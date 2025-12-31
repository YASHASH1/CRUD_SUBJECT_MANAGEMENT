package com.example.crud.controller;

import com.example.crud.config.EntityConfig;
import com.example.crud.model.Entity;
import com.example.crud.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${entity.entity-name}s")
public class EntityController {
    
    @Autowired
    private EntityService service;
    
    @Autowired
    private EntityConfig config;
    
    @PostMapping
    public ResponseEntity<Entity> create(@RequestBody Entity entity) {
        Entity created = service.create(entity);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Entity>> getAll() {
        List<Entity> entities = service.getAll();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Entity> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Entity> update(@PathVariable Long id, @RequestBody Entity entity) {
        try {
            Entity updated = service.update(id, entity);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

