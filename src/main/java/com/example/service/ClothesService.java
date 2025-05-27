package com.example.service;

import com.example.domain.Clothes;
import com.example.repository.ClothesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 衣類情報を操作するサービス.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ClothesService {
    private final ClothesRepository clothesRepository;

    /**
     * 性別と色で衣類を検索する.
     *
     * @param gender 性別
     * @param color 色
     * @return 衣類情報一覧
     */
    public List<Clothes> searchByGenderAndColor(Integer gender, String color) {
        return clothesRepository.findByGenderAndColor(gender, color);
    }
}
