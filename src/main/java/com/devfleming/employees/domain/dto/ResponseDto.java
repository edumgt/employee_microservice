package com.devfleming.employees.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * Response class responsible to return information about a success request.
 * @author Rafael Fleming
 */
@Getter @Setter @ToString
@Builder
@AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold HTTP response information"
)
public class ResponseDto {

    @Schema(description = "Http Status Code", example = "200")
    private String statusCode;

    @Schema(description = "Http Status Message", example = "Request processed successfully")
    private String statusMessage;
}
