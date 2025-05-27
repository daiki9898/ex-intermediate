package com.example.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


/**
 * ホテルの価格が正常か判断するバリデータ.
 */
public class HotelPriceValidator implements ConstraintValidator<HotelPrice, String> {
    /**
     * 入力された価格が半角数字かつ、1000円以上であることを判定する.
     *
     * @param price   価格
     * @param context 　コンテクスト
     * @return 半角数字かつ1000以上の数値であるか
     */
    @Override
    public boolean isValid(String price, ConstraintValidatorContext context) {
        // 未入力の場合は、全件検索を行うため無視する
        if (price.isEmpty()) {
            return true;
        } else {
            return price.matches("^[0-9]+$") && Integer.parseInt(price) >= 1000;
        }
    }
}
