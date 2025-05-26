package com.example.form;

import com.example.validation.HotelPrice;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HotelSearchInput {
    @HotelPrice
    private String price;
}
