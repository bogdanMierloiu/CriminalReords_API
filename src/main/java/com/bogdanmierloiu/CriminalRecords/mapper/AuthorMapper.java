package com.bogdanmierloiu.CriminalRecords.mapper;

import com.bogdanmierloiu.CriminalRecords.dto.author.AuthorRequest;
import com.bogdanmierloiu.CriminalRecords.dto.author.AuthorResponse;
import com.bogdanmierloiu.CriminalRecords.entity.Author;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {
    Author map(AuthorRequest request);
    AuthorResponse map(Author author);
    List<AuthorResponse> map(List<Author> authorList);
}
