package com.study.study_log.common.util;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Solved.ac API 요청 공통 유틸 클래스
 * 다양한 응답 DTO(태그, 문제 등)를 재사용하기 위해 제네릭 타입으로 반환한다.
 * ex) SolvedAcTagRes, SolvedAcProblemRes
 */
public class SolvedAcApi {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public static <T> T requestSolvedAcApi(String uri, Class<T> clazz) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("x-solvedac-language", "ko")
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), clazz);
    }
}
