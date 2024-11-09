package com.devfleming.employees.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Error response class, to return information about the session and the error description, handled by exceptions.
 * @author Rafael Fleming
 */
@Getter @Setter @ToString
@Builder
@AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {

    @Schema(description = "Endpoint path", example = "/v1/api/employee/create-employee")
    private String apiPath;

    @Schema(description = "Http Status Error Code", example = "500")
    private HttpStatus errorCode;

    @Schema(description = "Http Status Error Message", example = "HTTP Status Internal Server Error")
    private String errorMessage;

    @Schema(description = "Error Time", example = "2024-09-08T20:49:33.624Z")
    private LocalDateTime errorTime;
}
