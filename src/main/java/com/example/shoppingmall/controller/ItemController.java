package com.example.shoppingmall.controller;

import com.example.shoppingmall.constant.ItemSellStatus;
import com.example.shoppingmall.dto.request.ItemRequestDto;
import com.example.shoppingmall.dto.response.ItemResponseDto;
import com.example.shoppingmall.entity.Item;
import com.example.shoppingmall.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemRepository itemRepository;  // 추후에 service 로 바꾸기

    @PostMapping(value = "/api/auth/item")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto requestDto) {
        Item item = Item.builder()
                .itemNm(requestDto.getItemNm())
                .price(requestDto.getPrice())
                .itemDetail(requestDto.getItemDetail())
                .itemSellStatus(ItemSellStatus.SELL)
                .stockNumber(requestDto.getStockNumber())
                .build();
        Item savedItem = itemRepository.save(item);
        ItemResponseDto responseDto = ItemResponseDto.builder()
                .id(savedItem.getId())
                .itemNm(savedItem.getItemNm())
                .price(savedItem.getPrice())
                .itemDetail(savedItem.getItemDetail())
                .sellStatCd(savedItem.getItemSellStatus().toString())
                .regTime(savedItem.getRegTime())
                .updateTime(savedItem.getUpdateTime())
                .build();
        return responseDto;
    }
}
