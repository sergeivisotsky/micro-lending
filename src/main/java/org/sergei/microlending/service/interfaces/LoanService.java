package org.sergei.microlending.service.interfaces;

import org.sergei.microlending.rest.dto.LoanDTO;
import org.sergei.microlending.rest.dto.ResponseDTO;
import org.sergei.microlending.rest.dto.request.LoanRequestDTO;
import org.springframework.stereotype.Service;

/**
 * @author Sergei Visotsky
 */
@Service
public interface LoanService {
    /**
     * Create a loan for the user
     *
     * @param request loan request
     * @return created loan
     */
    ResponseDTO<LoanDTO> createLoan(LoanRequestDTO request);

    /**
     * Get all loans that was created by specific user
     *
     * @param userId by which loans should be found
     * @return Response with all the loans
     */
    ResponseDTO<LoanDTO> getLoansForUser(Long userId);
}
