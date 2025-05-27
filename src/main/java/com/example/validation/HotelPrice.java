package com.example.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ホテルの価格が正常か判定するアノテーション.
 */
@Constraint(validatedBy = HotelPriceValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HotelPrice {
    String message() default "1000以上の数値を半角で入力してください";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
