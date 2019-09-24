package org.sergei.microlending.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Sergei Visotsky
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessageDTO {
    private String errorCode;
    private String errorMsg;
    private String stacktrace;
}
