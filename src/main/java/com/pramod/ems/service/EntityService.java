package com.pramod.ems.service;

import com.pramod.ems.helper.EntityHelper;
import com.pramod.ems.model.EMSEntity;
import org.springframework.stereotype.Service;

@Service
public class EntityService {

    public EMSEntity getEntity(String type, String uuid) {
        return EntityHelper.getEntity(toCamelCase(type),uuid);
    }

    public EMSEntity createEntity(String type, EMSEntity entity) {
        return EntityHelper.createEntity(toCamelCase(type),entity);
    }

    public EMSEntity updateEntity(String type, String uuid, EMSEntity entity) {
        return EntityHelper.updateEntity(toCamelCase(type),uuid,entity);
    }

    public void deleteEntity(String type, String uuid) {
        EntityHelper.deleteEntity(toCamelCase(type),uuid);
    }

    private static String toCamelCase(String str){
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
