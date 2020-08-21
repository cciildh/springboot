package com.ldh.service;

import java.util.List;

import com.ldh.entity.ProductCategory;

/**
 * ProductCategoryService
 */
public interface ProductCategoryService {

    List<ProductCategory> ListGetCategoryAll(List<Integer> categoryTypeList);
}