package com.saha.controller;

import com.saha.persistence.entity.DummyEntity;
import com.saha.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dummies")
public class DummyController {
    @Autowired
    private DummyService dummyService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<DummyEntity> users() {
        return dummyService.dummies();
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public DummyEntity create(@RequestBody DummyEntity dummy) {
        return dummyService.save(dummy);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public DummyEntity create(@RequestBody DummyEntity dummy, @PathVariable Long id) {
        return dummyService.update(dummy, id);
    }


}
