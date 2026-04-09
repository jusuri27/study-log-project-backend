package com.study.study_log.problem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 문제와 태그의 다대다 관계를 풀기 위한 중간 엔티티
 * 하나의 문제는 여러 태그를 가질 수 있고
 * 하나의 태그도 여러 문제에 사용될 수 있음
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolvedAcProblemTag {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boj_tag_id")
    private SolvedAcTag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private SolvedAcProblem problem;

    public SolvedAcProblemTag(SolvedAcTag tag, SolvedAcProblem problem) {
        this.tag = tag;
        this.problem = problem;
    }
}
