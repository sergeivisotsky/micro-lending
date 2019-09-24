package org.sergei.microlending.rest.dto.mappers;

import org.sergei.microlending.jpa.model.Loan;
import org.sergei.microlending.rest.dto.LoanDTO;
import org.sergei.microlending.utils.IMapper;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Visotsky
 */
@Component
public class LoanDTOMapper implements IMapper<Loan, LoanDTO> {

    @Override
    public LoanDTO apply(Loan loan) {
        return LoanDTO.builder()
                .id(loan.getId())
                .amount(loan.getAmount())
                .term(loan.getTerm())
                .build();
    }
}
