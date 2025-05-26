package com.example.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ホテル情報を表すドメイン.
 */
@Getter
@Setter
@ToString
public class Hotel {
    /** 主キー(ID) */
    private Integer id;
    /** エリア名 */
    private String areaName;
    /** ホテル名 */
    private String hotelName;
    /** 住所 */
    private String address;
    /** 最寄り駅 */
    private String nearestStation;
    /** 価格 */
    private Integer price;
    /** 駐車場の有無 */
    private String parking;
}
