package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 野球チーム情報を表すドメイン.
 */
@Getter
@Setter
@ToString
public class BaseballTeam {
    /** 主キー(ID) */
    private Integer id;
    /** リーグ名 */
    private String leagueName;
    /** チーム名 */
    private String teamName;
    /** 本拠地 */
    private String headquarters;
    /** 発足日 */
    private String inauguration;
    /** 歴史 */
    private String history;
}
