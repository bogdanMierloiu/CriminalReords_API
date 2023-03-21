package com.bogdanmierloiu.CriminalRecords.service;

import java.util.List;

public interface Crud<T, R> {

    void add(T request);

    List<R> getAll();

    R findById(Long id);

    void update(T request);

    void delete(Long id);
}
