package com.bogdanmierloiu.CriminalRecords.dto.author;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
