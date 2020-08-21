package com.ldh.repository;

import java.util.List;

import com.ldh.entity.ProductInfo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductInfoRepository
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 查询所有在架的商品
     * @param productStatus 
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    
}