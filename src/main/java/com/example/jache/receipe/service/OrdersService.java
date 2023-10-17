package com.example.jache.receipe.service;

import com.example.jache.receipe.dto.ImgUploadDto;
import com.example.jache.receipe.dto.OrdersDto;

import java.io.IOException;

public interface OrdersService {

    boolean orderIsAuthorized(String chefName, Long receipeId);

    OrdersDto.OrdersResDto createOrders(ImgUploadDto orderImgUploadDto, OrdersDto.OrdersReqDto ordersReqDto) throws IOException;
}
