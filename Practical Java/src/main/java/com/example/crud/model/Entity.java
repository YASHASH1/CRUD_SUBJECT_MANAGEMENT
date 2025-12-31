package com.example.crud.model;

public class Entity {
    
    private Long id;
    private String name;
    private String field2;
    
    public Entity() {
    }
    
    public Entity(String name, String field2) {
        this.name = name;
        this.field2 = field2;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getField2() {
        return field2;
    }
    
    public void setField2(String field2) {
        this.field2 = field2;
    }
    
    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}

