package com.example.crud.service;

import com.example.crud.model.Entity;
import com.example.crud.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityService {
    
    @Autowired
    private EntityRepository repository;
    
    public Entity create(Entity entity) {
        return repository.save(entity);
    }
    
    public List<Entity> getAll() {
        return repository.findAll();
    }
    
    public Optional<Entity> getById(Long id) {
        return repository.findById(id);
    }
    
    public Entity update(Long id, Entity entityDetails) {
        Entity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        
        entity.setName(entityDetails.getName());
        entity.setField2(entityDetails.getField2());
        
        return repository.save(entity);
    }
    
    public void delete(Long id) {
        Entity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
        repository.delete(entity);
    }
}

