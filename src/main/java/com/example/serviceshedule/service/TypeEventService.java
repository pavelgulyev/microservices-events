package com.example.serviceshedule.service;


import com.example.serviceshedule.entity.TypeEvent;
import com.example.serviceshedule.repository.TypeEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeEventService {
    @Autowired
    private TypeEventRepository repository;
    public TypeEvent createTypeEvent(TypeEvent mytypeEvent) {
        TypeEvent typeEvent = new TypeEvent();
        typeEvent.setNametype_event(mytypeEvent.getNametype_event());
        return repository.save(typeEvent);
    }
    public List<TypeEvent> readAll() {
        return repository.findAll();
    }
    public TypeEvent update(TypeEvent typeEvent) {
        return repository.save(typeEvent);
    }
    public TypeEvent getFacultyById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
