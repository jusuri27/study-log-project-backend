package com.study.study_log.problem.repository;

import com.study.study_log.problem.entity.SolvedAcProblem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<SolvedAcProblem, Long> {
}
