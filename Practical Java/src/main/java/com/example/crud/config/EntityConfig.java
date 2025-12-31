package com.example.crud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "entity")
public class EntityConfig {
    
    private String entityName = "student";
    private String field1Name = "name";
    private String field2Name = "course";
    
    public String getEntityName() {
        return entityName;
    }
    
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    
    public String getField1Name() {
        return field1Name;
    }
    
    public void setField1Name(String field1Name) {
        this.field1Name = field1Name;
    }
    
    public String getField2Name() {
        return field2Name;
    }
    
    public void setField2Name(String field2Name) {
        this.field2Name = field2Name;
    }
    
    public String getEntityNamePlural() {
        return entityName + "s";
    }
    
    public String getEntityNameCapitalized() {
        return entityName.substring(0, 1).toUpperCase() + entityName.substring(1);
    }
}

