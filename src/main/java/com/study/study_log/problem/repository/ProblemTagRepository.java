package com.study.study_log.problem.repository;

import com.study.study_log.problem.entity.SolvedAcTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemTagRepository extends JpaRepository<SolvedAcTag, Long> {
}
