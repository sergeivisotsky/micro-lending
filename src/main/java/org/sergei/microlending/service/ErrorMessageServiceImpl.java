package org.sergei.microlending.service;

import org.sergei.microlending.jpa.model.ErrorMessage;
import org.sergei.microlending.jpa.repository.ErrorMessageRepository;
import org.sergei.microlending.rest.dto.ErrorMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Visotsky
 */
@Service
public class ErrorMessageServiceImpl implements ErrorMessageService {

    private final ErrorMessageRepository errorMessageRepository;

    @Autowired
    public ErrorMessageServiceImpl(ErrorMessageRepository errorMessageRepository) {
        this.errorMessageRepository = errorMessageRepository;
    }

    @Override
    public List<ErrorMessageDTO> responseErrorListByCode(String code) {
        List<ErrorMessage> responseMessageList = errorMessageRepository.findErrorMessageByCode(code);

        List<ErrorMessageDTO> responseErrorList = new ArrayList<>();
        responseMessageList.forEach(
                errorMessage ->
                        responseErrorList.add(
                                new ErrorMessageDTO(errorMessage.getCode(), errorMessage.getMessage()))
        );

        return responseErrorList;
    }
}
