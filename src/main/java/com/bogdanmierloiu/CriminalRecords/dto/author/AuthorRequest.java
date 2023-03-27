package com.bogdanmierloiu.CriminalRecords.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String personalCode;

}
