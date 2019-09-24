package org.sergei.microlending.service;

import org.sergei.microlending.rest.dto.LoanDTO;
import org.sergei.microlending.rest.dto.request.LoanRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
@Service
public interface LoanService {
    LoanDTO createLoan(LoanRequestDTO request);

    List<LoanDTO> getLoansForUser(Long userId);
}
