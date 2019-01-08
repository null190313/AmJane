package org.lxrookie.start.substance.base.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GeneralServices<T> {

    T selectByKey(Object key);

    int save(T entity);

    int saveNotNull(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
