package com.ldh.repository;

import java.util.List;

import com.ldh.entity.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductCategoryRepository
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 根据商品类目查询商品目录
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}