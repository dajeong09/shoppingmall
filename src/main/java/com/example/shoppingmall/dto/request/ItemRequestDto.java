package com.example.shoppingmall.dto.request;

import lombok.Getter;

@Getter
public class ItemRequestDto {
    private String itemNm;
    private Integer price;
    private String itemDetail;
    private Integer stockNumber;
}
