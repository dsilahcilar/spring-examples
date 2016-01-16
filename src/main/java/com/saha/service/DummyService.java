package com.saha.service;

import com.saha.persistence.entity.DummyEntity;
import com.saha.persistence.repository.DummyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    public Iterable<DummyEntity> dummies() {
        return dummyRepository.findAll();
    }


    public DummyEntity save(DummyEntity dummyEntity) {
        dummyEntity = dummyRepository.save(dummyEntity);
        return dummyEntity;
    }

    public DummyEntity update(DummyEntity dummy, Long id) {
        if(id == 99) {
            throw new RuntimeException();
        }
        DummyEntity founded = dummyRepository.findOne(id);
        founded.setDescription(dummy.getDescription());
        founded.setUpdatable(dummy.getUpdatable());

        return dummyRepository.save(founded);

    }
}
