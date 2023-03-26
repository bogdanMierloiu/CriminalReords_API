package com.bogdanmierloiu.CriminalRecords.service;

import com.bogdanmierloiu.CriminalRecords.dto.author.AuthorRequest;
import com.bogdanmierloiu.CriminalRecords.dto.author.AuthorResponse;
import com.bogdanmierloiu.CriminalRecords.entity.Author;
import com.bogdanmierloiu.CriminalRecords.exception.NotFoundException;
import com.bogdanmierloiu.CriminalRecords.mapper.AuthorMapper;
import com.bogdanmierloiu.CriminalRecords.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService implements Crud<AuthorRequest, AuthorResponse> {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    @Override
    public void add(AuthorRequest request) {
        authorRepository.save(authorMapper.map(request));
    }

    @Override
    public List<AuthorResponse> getAll() {
        return authorMapper.map(authorRepository.findAll());
    }

    @Override
    public AuthorResponse findById(Long id) {
        return authorMapper.map(authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The author with id " + id + " not found!")
        ));
    }

    @Override
    public void update(AuthorRequest request) {
        Author authorToUpdate = authorRepository.findById(request.getId()).orElseThrow(
                () -> new NotFoundException("The author with id " + request.getId() + " not found!")
        );
        authorToUpdate.setFirstName(request.getFirstName() != null ? request.getFirstName() : authorToUpdate.getFirstName());
        authorToUpdate.setMiddleName(request.getMiddleName() != null ? request.getMiddleName() : authorToUpdate.getMiddleName());
        authorToUpdate.setLastName(request.getLastName() != null ? request.getLastName() : authorToUpdate.getLastName());
        authorToUpdate.setPersonalCode(request.getPersonalCode() != null ? request.getPersonalCode() : authorToUpdate.getPersonalCode());
        authorRepository.save(authorToUpdate);
    }
    @Override
    public void delete(Long id) {
        Author authorToDelete = authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("The author with id " + id + " not found!")
        );
        authorRepository.delete(authorToDelete);
    }
}
