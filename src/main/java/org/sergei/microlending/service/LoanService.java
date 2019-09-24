package org.sergei.microlending.service;

import org.sergei.microlending.rest.dto.LoanDTO;
import org.sergei.microlending.rest.dto.ResponseDTO;
import org.sergei.microlending.rest.dto.request.LoanRequestDTO;
import org.springframework.stereotype.Service;

/**
 * @author Sergei Visotsky
 */
@Service
public interface LoanService {
    ResponseDTO<LoanDTO> createLoan(LoanRequestDTO request);

    ResponseDTO<LoanDTO> getLoansForUser(Long userId);
}
