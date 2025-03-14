package org.edu.miu.cs.cs425.eregistrarwebapi.repository;

import org.edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
