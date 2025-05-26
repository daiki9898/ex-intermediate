package com.example.repository;

import com.example.domain.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * テーブルhotelsを操作するリポジトリ.
 */
@Repository
@RequiredArgsConstructor
public class HotelRepository {
    private final NamedParameterJdbcTemplate template;
    private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

    /**
     * 指定された価格以下のホテルを検索する.
     *
     * @param price 価格
     * @return ホテル一覧
     */
    public List<Hotel> findByLessThanPrice(Integer price) {
        String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels WHERE price <= :price ORDER BY price DESC";
        SqlParameterSource param = new MapSqlParameterSource("price", price);
        return template.query(sql, param, HOTEL_ROW_MAPPER);
    }

    /**
     * 全ホテルを価格(降順)で取得する.
     *
     * @return ホテル一覧
     */
    public List<Hotel> findAll() {
        String sql = "SELECT id, area_name, hotel_name, address, nearest_station, price, parking FROM hotels ORDER BY price DESC";
        return template.query(sql, HOTEL_ROW_MAPPER);
    }
}
