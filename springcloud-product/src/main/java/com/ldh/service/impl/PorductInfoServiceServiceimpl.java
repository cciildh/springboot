package com.ldh.service.impl;

import java.util.List;

import com.ldh.entity.ProductInfo;
import com.ldh.enums.ProductStatusEnum;
import com.ldh.repository.ProductInfoRepository;
import com.ldh.service.PorductInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PorductInfoServiceServiceimpl
 */
@Service
public class PorductInfoServiceServiceimpl implements PorductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> getUpAll() {
        return this.productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

}