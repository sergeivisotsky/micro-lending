package org.sergei.microlending.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Sergei Visotsky
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = -4617101805358011208L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq",
            sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Loan> loans;
}
