package org.sergei.microlending.jpa.model.mappers;

import org.sergei.microlending.jpa.model.Loan;
import org.sergei.microlending.rest.dto.LoanDTO;
import org.sergei.microlending.utils.IMapper;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Visotsky
 */
@Component
public class LoanModelMapper implements IMapper<LoanDTO, Loan> {
    @Override
    public Loan apply(LoanDTO loanDTO) {
        return Loan.builder()
                .term(loanDTO.getTerm())
                .amount(loanDTO.getAmount())
                .build();
    }
}
