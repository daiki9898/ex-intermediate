package com.example.service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ホテル情報を操作するサービス.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    /**
     * 指定された価格以下のホテルを検索する.
     *
     * @param price 価格
     * @return ホテル一覧
     */
    public List<Hotel> searchByLessThanPrice(String price) {
        if (price.isEmpty()) { // 何も入力されなかった場合、全件検索を行う
            return hotelRepository.findAll();
        } else {
            return hotelRepository.findByLessThanPrice(Integer.parseInt(price));
        }
    }

    /**
     * 全ホテルを価格(降順)で取得する.
     *
     * @return ホテル一覧
     */
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }
}
