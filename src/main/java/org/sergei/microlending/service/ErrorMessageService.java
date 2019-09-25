package org.sergei.microlending.service;

import org.sergei.microlending.rest.dto.ErrorMessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
@Service
public interface ErrorMessageService {
    /**
     * Get error message list by code
     *
     * @param code error code
     * @return collection with all the errors
     */
    List<ErrorMessageDTO> responseErrorListByCode(String code);
}
