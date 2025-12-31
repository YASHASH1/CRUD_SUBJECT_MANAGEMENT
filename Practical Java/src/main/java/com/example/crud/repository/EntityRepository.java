package com.example.crud.repository;

import com.example.crud.model.Entity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EntityRepository {
    
    private final List<Entity> entities = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    
    public Entity save(Entity entity) {
        if (entity.getId() == null) {
            entity.setId(idCounter.getAndIncrement());
            entities.add(entity);
        } else {
            Optional<Entity> existing = findById(entity.getId());
            if (existing.isPresent()) {
                int index = entities.indexOf(existing.get());
                entities.set(index, entity);
            } else {
                entities.add(entity);
            }
        }
        return entity;
    }
    
    public List<Entity> findAll() {
        return new ArrayList<>(entities);
    }
    
    public Optional<Entity> findById(Long id) {
        return entities.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }
    
    public void delete(Entity entity) {
        entities.remove(entity);
    }
    
    public void deleteById(Long id) {
        entities.removeIf(e -> e.getId().equals(id));
    }
}

