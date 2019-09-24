package org.sergei.microlending.rest.dto.mappers;

import org.sergei.microlending.jpa.model.Loan;
import org.sergei.microlending.rest.dto.LoanDTO;
import org.sergei.microlending.utils.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
@Component
public class LoanDTOListMapper implements IMapper<List<Loan>, List<LoanDTO>> {

    private final LoanDTOMapper loanDTOMapper;

    @Autowired
    public LoanDTOListMapper(LoanDTOMapper loanDTOMapper) {
        this.loanDTOMapper = loanDTOMapper;
    }

    @Override
    public List<LoanDTO> apply(List<Loan> loans) {
        return loanDTOMapper.applyList(loans);
    }
}
