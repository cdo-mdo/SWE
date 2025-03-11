package org.edu.miu.cs.cs425.assignment91.studentmgmt.repository;

import org.edu.miu.cs.cs425.assignment91.studentmgmt.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {

}
