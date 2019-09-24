package org.sergei.microlending.service;

import org.sergei.microlending.jpa.model.Loan;
import org.sergei.microlending.jpa.model.User;
import org.sergei.microlending.jpa.model.mappers.LoanModelMapper;
import org.sergei.microlending.jpa.repository.LoanRepository;
import org.sergei.microlending.jpa.repository.UserRepository;
import org.sergei.microlending.rest.dto.LoanDTO;
import org.sergei.microlending.rest.dto.mappers.LoanDTOListMapper;
import org.sergei.microlending.rest.dto.mappers.LoanDTOMapper;
import org.sergei.microlending.rest.dto.request.LoanRequestDTO;
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

    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final LoanDTOMapper loanDTOMapper;
    private final LoanDTOListMapper loanDTOListMapper;
    private final LoanModelMapper loanModelMapper;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository,
                           UserRepository userRepository,
                           LoanDTOMapper loanDTOMapper,
                           LoanDTOListMapper loanDTOListMapper, LoanModelMapper loanModelMapper) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.loanDTOMapper = loanDTOMapper;
        this.loanDTOListMapper = loanDTOListMapper;
        this.loanModelMapper = loanModelMapper;
    }

    @Override
    public LoanDTO createLoan(LoanRequestDTO request) {
        final Integer maxLoanAmount = 1_000_000;
        LocalTime time = LocalTime.now();
        Double amount = request.getAmount();
        boolean timeLimit = time.isAfter(LocalTime.of(0, 0, 0, 0));
        if (amount <= maxLoanAmount) {
            if (timeLimit) {
                Optional<User> user = userRepository.findById(request.getUserId());
                if (user.isPresent()) {
                    Loan loan = Loan.builder()
                            .term(request.getTerm())
                            .amount(request.getAmount())
                            .user(user.get())
                            .build();
                    Loan savedLoan = loanRepository.save(loan);
                    return loanDTOMapper.apply(savedLoan);
                } else {
                    throw new RuntimeException("User with this ID not found");
                }
            } else {
                throw new RuntimeException("Loan cannot be made before 00:00");
            }
        } else {
            throw new RuntimeException("Loan amount is greater than max allowed loan amount");
        }
    }

    @Override
    public List<LoanDTO> getLoansForUser(Long userId) {
        List<Loan> loans = loanRepository.findAllByUserId(userId);
        if (loans == null) {
            throw new RuntimeException("User has not done any loan");
        }
        return loanDTOListMapper.apply(loans);
    }
}
