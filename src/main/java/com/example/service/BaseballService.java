package com.example.service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 野球チーム情報を操作するサービス.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BaseballService {
    private final BaseballRepository baseballRepository;

    /**
     * チーム一覧を取得する.
     *
     * @return チーム一覧
     */
    public List<BaseballTeam> findAll() {
        return baseballRepository.findAll();
    }

    /**
     * チーム情報を取得する.
     *
     * @param id id
     * @return チーム情報
     */
    public BaseballTeam findById(Integer id) {
        return baseballRepository.findById(id);
    }
}
