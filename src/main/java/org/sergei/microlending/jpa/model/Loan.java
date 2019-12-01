package org.sergei.microlending.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Sergei Visotsky
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Loan implements Serializable {
    private static final long serialVersionUID = 4899007606359073524L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "loan_id_seq")
    @SequenceGenerator(name = "loan_id_seq",
            sequenceName = "loan_id_seq", allocationSize = 1)
    private Long id;

    private Integer term;

    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
