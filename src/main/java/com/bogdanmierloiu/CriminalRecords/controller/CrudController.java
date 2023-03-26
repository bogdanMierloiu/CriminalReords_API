package com.bogdanmierloiu.CriminalRecords.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudController<T, K> {

    ResponseEntity<?> add(T request);

    ResponseEntity<List<K>> getAll();

    ResponseEntity<K> findById(Long id);

    ResponseEntity<?> update(T request);

    ResponseEntity<?> delete(Long id);
}
