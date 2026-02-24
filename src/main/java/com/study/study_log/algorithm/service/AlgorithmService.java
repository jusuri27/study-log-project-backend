package com.study.study_log.algorithm.service;

import com.study.study_log.algorithm.dto.AlgorithmCreateReq;
import com.study.study_log.algorithm.dto.AlgorithmUpdateReq;
import com.study.study_log.algorithm.entity.Algorithm;
import com.study.study_log.algorithm.repository.AlgorithmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlgorithmService {

    private final AlgorithmRepository algorithmRepository;

    public void createAlgorithm(AlgorithmCreateReq request) {
        Algorithm algorithm = Algorithm.builder()
                .lv(request.getLv())
                .name(request.getName())
                .tryCount(request.getTryCount())
                .build();
        algorithmRepository.save(algorithm);
    }

    public List<Algorithm> getAlgorithm() {
        List<Algorithm> result = algorithmRepository.findAll();
        return result;
    }

    @Transactional
    public void modifyAlgorithm(Long algorithmId, AlgorithmUpdateReq request) {
        Algorithm algorithm = algorithmRepository.findById(algorithmId).orElseThrow(() -> new IllegalArgumentException("알고리즘이 존재하지 않습니다."));
        algorithm.update(request.getLv(), request.getName(), request.getTryCount());
    }

    public void removeAlgorithm(Long algorithmId) {
        algorithmRepository.deleteById(algorithmId);
    }
}
