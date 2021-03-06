package org.sergei.microlending.service;

import org.sergei.microlending.jpa.model.Loan;
import org.sergei.microlending.jpa.model.User;
import org.sergei.microlending.jpa.repository.LoanRepository;
import org.sergei.microlending.jpa.repository.UserRepository;
import org.sergei.microlending.rest.dto.ErrorMessageDTO;
import org.sergei.microlending.rest.dto.LoanDTO;
import org.sergei.microlending.rest.dto.ResponseDTO;
import org.sergei.microlending.rest.dto.mappers.LoanDTOListMapper;
import org.sergei.microlending.rest.dto.mappers.LoanDTOMapper;
import org.sergei.microlending.rest.dto.request.LoanRequestDTO;
import org.sergei.microlending.service.interfaces.ErrorMessageService;
import org.sergei.microlending.service.interfaces.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Sergei Visotsky
 */
@Service
public class LoanServiceImpl implements LoanService {

    private final ErrorMessageService errorMessageService;
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final LoanDTOMapper loanDTOMapper;
    private final LoanDTOListMapper loanDTOListMapper;

    @Autowired
    public LoanServiceImpl(ErrorMessageService errorMessageService,
                           LoanRepository loanRepository,
                           UserRepository userRepository,
                           LoanDTOMapper loanDTOMapper,
                           LoanDTOListMapper loanDTOListMapper) {
        this.errorMessageService = errorMessageService;
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.loanDTOMapper = loanDTOMapper;
        this.loanDTOListMapper = loanDTOListMapper;
    }

    @Override
    public ResponseDTO<LoanDTO> createLoan(LoanRequestDTO request) {
        final Integer maxLoanAmount = 1_000_000;
        LocalTime time = LocalTime.now();
        Double amount = request.getAmount();
        // Time limit - 00:00 before which loan cannot be created
        boolean timeLimit = time.isAfter(LocalTime.of(0, 0, 0, 0));
        if (amount <= maxLoanAmount) { // Check if provided amount is less than max loan amount
            if (timeLimit) { // Check for the time limit
                Optional<User> user = userRepository.findById(request.getUserId());
                if (user.isPresent()) {
                    Loan loan = Loan.builder()
                            .term(request.getTerm())
                            .amount(request.getAmount())
                            .user(user.get())
                            .build();
                    Loan savedLoan = loanRepository.save(loan);
                    return ResponseDTO.<LoanDTO>builder()
                            .errors(List.of())
                            .response(List.of(loanDTOMapper.apply(savedLoan)))
                            .build();
                } else {
                    List<ErrorMessageDTO> errorMessages = errorMessageService.responseErrorListByCode("USR_001");
                    return new ResponseDTO<>(errorMessages, List.of());
                }
            } else {
                List<ErrorMessageDTO> errorMessages = errorMessageService.responseErrorListByCode("LON_001");
                return new ResponseDTO<>(errorMessages, List.of());
            }
        } else {
            List<ErrorMessageDTO> errorMessages = errorMessageService.responseErrorListByCode("LON_002");
            return new ResponseDTO<>(errorMessages, List.of());
        }
    }

    @Override
    public ResponseDTO<LoanDTO> getLoansForUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<Loan> loans = loanRepository.findAllByUserId(user.get().getId());
            if (loans.isEmpty()) {
                List<ErrorMessageDTO> errorMessages = errorMessageService.responseErrorListByCode("USR_002");
                return new ResponseDTO<>(errorMessages, List.of());
            }
            return ResponseDTO.<LoanDTO>builder()
                    .errors(List.of())
                    .response(loanDTOListMapper.apply(loans))
                    .build();
        } else {
            List<ErrorMessageDTO> errorMessages = errorMessageService.responseErrorListByCode("USR_001");
            return new ResponseDTO<>(errorMessages, List.of());
        }
    }
}
