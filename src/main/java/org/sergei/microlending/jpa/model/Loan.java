package org.sergei.microlending.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Sergei Visotsky
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class Loan implements Serializable {
    private static final long serialVersionUID = 4899007606359073524L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "loan_id_seq")
    @SequenceGenerator(name = "loan_id_seq",
            sequenceName = "loan_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "term")
    private Integer term;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
