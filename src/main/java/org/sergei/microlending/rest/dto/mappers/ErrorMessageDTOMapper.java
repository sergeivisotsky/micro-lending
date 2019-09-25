package org.sergei.microlending.rest.dto.mappers;

import org.sergei.microlending.jpa.model.ErrorMessage;
import org.sergei.microlending.rest.dto.ErrorMessageDTO;
import org.sergei.microlending.utils.IMapper;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Visotsky
 */
@Component
public class ErrorMessageDTOMapper implements IMapper<ErrorMessage, ErrorMessageDTO> {

    @Override
    public ErrorMessageDTO apply(ErrorMessage errorMessage) {
        return ErrorMessageDTO.builder()
                .errorCode(errorMessage.getCode())
                .errorMsg(errorMessage.getMessage())
                .build();
    }
}
