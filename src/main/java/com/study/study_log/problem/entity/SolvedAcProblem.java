package com.study.study_log.problem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Solved.ac 문제 정보를 저장하는 엔티티
 * 하나의 문제는 여러 개의 태그를 가질 수 있으며
 * SolvedAcProblemTag를 통해 태그와 다대다 관계를 관리
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolvedAcProblem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "problem_id", nullable = false, unique = true)
    @Comment("백준 문제 번호로, 문제마다 고유합니다.")
    private Long problemId;

    @Column(name = "accepted_user_count")
    @Comment("맞은 사람 수입니다.")
    private int acceptedUserCount;

    @Column(name = "ko_title", nullable = false)
    @Comment("한국어 문제 제목입니다.")
    private String koTitle;

    @Column(name = "level", nullable = false)
    @Comment("문제 난이도입니다")
    private int level;

    /**
     * 문제 - 태그 매핑 테이블
     * SolvedAcProblemTag를 통해 태그와 다대다 관계를 중간 엔티티로 관리
     */
    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SolvedAcProblemTag> problemTags = new ArrayList<>();

    @Builder
    private SolvedAcProblem(Long problemId, int acceptedUserCount, String koTitle, int level, List<SolvedAcProblemTag> problemTags) {
        this.problemId = problemId;
        this.acceptedUserCount = acceptedUserCount;
        this.koTitle = koTitle;
        this.level = level;
    }

    public void addTag(SolvedAcTag tag) {
        SolvedAcProblemTag problemTag = new SolvedAcProblemTag(tag, this);
        this.problemTags.add(problemTag);
    }

}
