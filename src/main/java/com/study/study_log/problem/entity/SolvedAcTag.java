package com.study.study_log.problem.entity;

import com.study.study_log.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Solved.ac 및 백준에서 사용하는 태그 정보를 저장하는 엔티티
 * 하나의 태그는 여러 문제에서 사용될 수 있음
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolvedAcTag extends BaseEntity {
    @Id
    @Column(name = "id")
    @Comment("태그 내부 pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_key", nullable = false, unique = true)
    @Comment("solved.ac에서 쓰는 태그 ID")
    private String key;

    @Column(name = "boj_tag_id", nullable = false, unique = true)
    @Comment("백준 온라인 저지에서 쓰는 태그 ID")
    private Long bojTagId;

    @Column(name = "name", nullable = false)
    @Comment("태그 이름")
    private String name;

    /**
     * 태그 - 문제 매핑 관계
     * 중간 엔티티(SolvedAcProblemTag)를 통해 문제와 연결
     */
    @OneToMany(mappedBy = "tag")
    private List<SolvedAcProblemTag> problemTags = new ArrayList<>();

    @Builder
    private SolvedAcTag(String key, Long bojTagId, String name) {
        this.key = key;
        this.bojTagId = bojTagId;
        this.name = name;
    }
}
