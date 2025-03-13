package org.edu.miu.cs.cs425.eregistrar.repository;

import org.edu.miu.cs.cs425.eregistrar.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE " +
            "LOWER(s.studentNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.middleName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "(s.cgpa IS NOT NULL AND CAST(s.cgpa AS string) LIKE CONCAT('%', :keyword, '%')) OR " +
            "CAST(s.enrollmentDate AS string) LIKE CONCAT('%', :keyword, '%') OR " +
            "CAST(s.isInternational AS string) LIKE CONCAT('%', :keyword, '%')")
    Page<Student> searchStudents(@Param("keyword") String keyword, Pageable pageable);

    // Custom delete method for bulk delete
    @Transactional
    void deleteByStudentIdIn(List<Long> studentIds);
}
