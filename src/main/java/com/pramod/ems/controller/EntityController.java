package com.pramod.ems.controller;

import com.pramod.ems.model.EMSEntity;
import com.pramod.ems.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/entity")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @RequestMapping(value = "/{type}/{uuid}", method = RequestMethod.GET)
    public ResponseEntity<EMSEntity> getEntity(@PathVariable String type, @PathVariable String uuid){
        return new ResponseEntity<>(entityService.getEntity(type,uuid), HttpStatus.OK);
    }

    @RequestMapping(value = "/{type}", method = RequestMethod.POST)
    public ResponseEntity<EMSEntity> createEntity(@PathVariable String type, @RequestBody EMSEntity entity){
        return new ResponseEntity<>(entityService.createEntity(type, entity), HttpStatus.OK);
    }

    @RequestMapping(value = "/{type/{uuid}", method = RequestMethod.PUT)
    public ResponseEntity<EMSEntity> updateEntity(@PathVariable String type, @PathVariable String uuid, @RequestBody EMSEntity entity){
        return new ResponseEntity<>(entityService.updateEntity(type,uuid, entity), HttpStatus.OK);
    }

    @RequestMapping(value = "/{type}/{uuid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEntity(@PathVariable String type, @PathVariable String uuid){
        entityService.deleteEntity(type, uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
