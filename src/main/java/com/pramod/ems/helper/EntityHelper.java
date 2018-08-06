package com.pramod.ems.helper;

import com.pramod.ems.builder.EMSBuilder;
import com.pramod.ems.exception.EntityNotFoundException;
import com.pramod.ems.exception.ServiceException;
import com.pramod.ems.model.EMSEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityHelper {

    private static final String BASE_BUILDER_PACKAGE = "com.pramod.ems.builder.";
    private static final String BUILDER_SUFFIX = "Builder";
    private static final Logger logger = LoggerFactory.getLogger(EntityHelper.class);

    public static EMSEntity getEntity(String type, String uuid){
        EMSBuilder builder = getBuilderClass(type);
        validateExistingEntity(type, uuid, builder);
        try{
            return (EMSEntity)builder.getRepository().findByUuid(uuid);
        } catch (Exception ex){
            logger.error("Unable to retrieve entity for type: "+type+ " uuid:"+uuid+" with error: "+ex.getMessage());
            throw new ServiceException("Unable to retrieve entity for type: "+type+ " uuid:"+uuid);
        }
    }

    public static EMSEntity createEntity(String type, EMSEntity entity){
        EMSEntity emsEntity;
        EMSBuilder builder = getBuilderClass(type);
        try{
            emsEntity = builder.saveEntity(entity);
        } catch (Exception ex){
            logger.error("Unable to create entity for type: "+type+" with error: "+ex.getMessage());
            throw new ServiceException("Unable to create entity for type: "+type);
        }
        return emsEntity;
    }

    public static EMSEntity updateEntity(String type, String uuid, EMSEntity entity) {
        EMSEntity emsEntity;
        EMSBuilder builder = getBuilderClass(type);
        validateExistingEntity(type, uuid, builder);
        try {
            emsEntity =  builder.saveEntity(entity);
        } catch (Exception ex){
            logger.error("Unable to update entity for type: "+type+ " with error: "+ex.getMessage());
            throw new ServiceException("Unable to update entity for type: "+type);
        }
        return emsEntity;
    }

    public static void deleteEntity(String type, String uuid){
        EMSBuilder builder = getBuilderClass(type);
        validateExistingEntity(type, uuid, builder);
        try{
            builder.getRepository().deleteByUuid(uuid);
        } catch (Exception ex){
            logger.error("Unable to delete entity for type: "+type+ " uuid:"+uuid+ " with error: "+ex.getMessage());
            throw new ServiceException("Unable to delete entity for type: "+type+ " uuid:"+uuid);
        }
    }

    private static void validateExistingEntity(String type, String uuid, EMSBuilder builder){
        EMSEntity existingEntity = (EMSEntity)builder.getRepository().findByUuid(uuid);
        if(existingEntity==null){
            logger.warn("Entity not found for type: "+type+" uuid: "+uuid);
            throw new EntityNotFoundException("Entity not found for type: "+type+" uuid: "+uuid);
        }
    }

    private static EMSBuilder getBuilderClass(String type){
        try{
            return (EMSBuilder)Class.forName(getBuilderClassName(type)).newInstance();
        } catch (ClassNotFoundException ex) {
            logger.error("Builder Class Not Found for type: " + type + "with error: " + ex.getMessage());
            throw new ServiceException("Builder Class Not Found for type: " + type);
        } catch (InstantiationException | IllegalAccessException ex){
            logger.error("Unable to instantiate Builder Class for type: " + type + "with error: " + ex.getMessage());
            throw new ServiceException("Unable to instantiate Builder Class for type: " + type);
        }
    }

    private static String getBuilderClassName(String type){
        return BASE_BUILDER_PACKAGE+type+BUILDER_SUFFIX;
    }
}
