package org.edu.miu.cs.cs425.jpaonetoone.repository;

import org.edu.miu.cs.cs425.jpaonetoone.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
