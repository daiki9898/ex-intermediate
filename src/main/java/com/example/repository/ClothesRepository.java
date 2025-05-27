package com.example.repository;

import com.example.domain.Clothes;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * テーブルclothesを操作するDao.
 */
@Repository
@RequiredArgsConstructor
public class ClothesRepository {
    private final NamedParameterJdbcTemplate template;
    private static final RowMapper<Clothes> CLOTHES_ROW_MAPPER = new BeanPropertyRowMapper<>(Clothes.class);

    /**
     * 性別と色で衣類を検索する.
     *
     * @param gender 性別
     * @param color  色
     * @return 衣類情報一覧
     */
    public List<Clothes> findByGenderAndColor(Integer gender, String color) {
        String sql = """
                SELECT id, category, genre, gender, color, price, size
                 FROM clothes
                WHERE gender = :gender AND color = :color
                 ORDER BY price ASC
                """;
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("gender", gender)
                .addValue("color", color);

        return template.query(sql, param, CLOTHES_ROW_MAPPER);
    }
}
