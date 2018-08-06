package com.pramod.ems.builder;

import com.pramod.ems.model.EMSEntity;
import com.pramod.ems.repository.EMSRepository;

public interface EMSBuilder {
    EMSRepository<?> getRepository();
    EMSEntity saveEntity(EMSEntity emsEntity);
}
