package com.example.repository;

import com.example.domain.BaseballTeam;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * teamsテーブルを操作するリポジトリ.
 */
@Repository
@RequiredArgsConstructor
public class BaseballRepository {
    private final NamedParameterJdbcTemplate template;
    private static final RowMapper<BaseballTeam> BASEBALL_TEAM_ROW_MAPPER = new BeanPropertyRowMapper<>(BaseballTeam.class);

    /**
     * 野球チーム一覧を、発足日(昇順）で取得する.
     *
     * @return 野球チーム一覧
     */
    public List<BaseballTeam> findAll() {
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration ASC";
        return template.query(sql, BASEBALL_TEAM_ROW_MAPPER);
    }

    /**
     * チーム情報を取得する.
     *
     * @param id id
     * @return チーム情報
     */
    public BaseballTeam findById(Integer id) {
        String sql = "SELECT id, league_name, team_name, headquarters, inauguration, history FROM teams WHERE id = :id";
        SqlParameterSource param = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, param, BASEBALL_TEAM_ROW_MAPPER);
    }
}
