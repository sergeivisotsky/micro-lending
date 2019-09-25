package org.sergei.microlending.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.sergei.microlending.rest.dto.LoanDTO;
import org.sergei.microlending.rest.dto.ResponseDTO;
import org.sergei.microlending.rest.dto.request.LoanRequestDTO;
import org.sergei.microlending.service.interfaces.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sergei Visotsky
 */
@RestController
@Api(tags = {"Loan crud operations"})
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @ApiOperation(value = "Get all loand made by concrete user")
    @GetMapping(value = "/getloansforuser", produces = "application/json")
    public ResponseEntity<ResponseDTO<LoanDTO>> getLoansForUser(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(loanService.getLoansForUser(userId), HttpStatus.OK);
    }

    @ApiOperation(value = "Create loan for a specific user")
    @PostMapping(value = "/saveloanforuser", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponseDTO<LoanDTO>> saveLoanForUser(@RequestBody LoanRequestDTO request) {
        return new ResponseEntity<>(loanService.createLoan(request), HttpStatus.CREATED);
    }

}
