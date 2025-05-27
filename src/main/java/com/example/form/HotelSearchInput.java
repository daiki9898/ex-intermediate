package com.example.form;

import com.example.validation.HotelPrice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ホテル情報を保持するフォーム.
 */
@Getter
@Setter
@ToString
public class HotelSearchInput {
    /**
     * 価格
     */
    @HotelPrice
    private String price;
}
