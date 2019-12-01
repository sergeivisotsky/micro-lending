package org.sergei.microlending.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Sergei Visotsky
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "error_messages")
public class ErrorMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "error_messages_id_seq")
    @SequenceGenerator(name = "error_messages_id_seq",
            sequenceName = "error_messages_id_seq", allocationSize = 1)
    private Long id;

    private String code;

    private String message;
}
