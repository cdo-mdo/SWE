package org.edu.miu.cs.cs425.assignment91.studentmgmt.repository;

import org.edu.miu.cs.cs425.assignment91.studentmgmt.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
