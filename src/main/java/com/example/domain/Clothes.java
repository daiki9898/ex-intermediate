package com.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 衣服の情報を表すドメイン.
 */
@Getter
@Setter
@ToString
public class Clothes {
    /** 主キー */
    private Integer id;
    /** カテゴリー(例:洋服) */
    private String category;
    /** ジャンル(例:ジャケット) */
    private String genre;
    /** 性別(男0, 女1) */
    private Integer gender;
    /** 価格 */
    private Integer price;
    /** サイズ(S,M,L) */
    private String size;
}
