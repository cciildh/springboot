package com.ldh.service.impl;

import java.util.List;

import com.ldh.entity.ProductCategory;
import com.ldh.repository.ProductCategoryRepository;
import com.ldh.service.ProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductCategoryServiceimpl
 */
@Service
public class ProductCategoryServiceimpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> ListGetCategoryAll(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

}