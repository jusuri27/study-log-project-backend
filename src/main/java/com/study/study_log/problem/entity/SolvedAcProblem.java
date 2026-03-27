package com.study.study_log.problem.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolvedAcProblem {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "problem_id", nullable = false)
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

    @Builder
    private SolvedAcProblem(Long problemId, int acceptedUserCount, String koTitle, int level) {
        this.problemId = problemId;
        this.acceptedUserCount = acceptedUserCount;
        this.koTitle = koTitle;
        this.level = level;
    }
}
