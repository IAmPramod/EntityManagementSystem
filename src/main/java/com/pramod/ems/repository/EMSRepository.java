package com.pramod.ems.repository;

import javax.transaction.Transactional;

public interface EMSRepository<T> {
    T findByUuid(String uuid);

    @Transactional
    T deleteByUuid(String uuid);
}
