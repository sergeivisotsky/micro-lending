package org.sergei.microlending.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Sergei Visotsky
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequestDTO implements Serializable {

    private static final long serialVersionUID = -6893326476884676305L;

    private Long userId;
    private Integer term;
    private Double amount;

}
