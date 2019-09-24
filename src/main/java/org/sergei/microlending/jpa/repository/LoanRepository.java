package org.sergei.microlending.jpa.repository;

import org.sergei.microlending.jpa.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l WHERE l.user.id = :userId")
    List<Loan> findAllByUserId(@Param("userId") Long userId);

}
