package org.sergei.microlending.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Sergei Visotsky
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO implements Serializable {
    private static final long serialVersionUID = 2549696363734625909L;

    private Long id;
    private Integer term;
    private Double amount;
}
