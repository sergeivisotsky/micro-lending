package org.sergei.microlending.jpa.repository;

import org.sergei.microlending.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sergei Visotsky
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
