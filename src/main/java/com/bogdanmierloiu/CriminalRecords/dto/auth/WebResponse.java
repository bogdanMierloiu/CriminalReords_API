package com.bogdanmierloiu.CriminalRecords.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"code", "status", "message"})
public class WebResponse {
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("status")
    private String status;
    @JsonProperty("message")
    private String message;
}
