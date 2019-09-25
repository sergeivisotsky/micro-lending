package org.sergei.microlending.jpa.repository;

import org.sergei.microlending.jpa.model.ErrorMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Sergei Visotsky
 */
@Repository
public interface ErrorMessageRepository extends JpaRepository<ErrorMessage, Long> {
    /**
     * Select error message by code
     *
     * @param code message code
     * @return Error wrapped into the collection
     */
    @Query("SELECT em FROM ErrorMessage em WHERE em.code = :code")
    List<ErrorMessage> findErrorMessageByCode(@Param("code") String code);
}
