package org.edu.miu.cs.cs425.jpaonetoone.repository;

import org.edu.miu.cs.cs425.jpaonetoone.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
