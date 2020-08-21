package com.ldh;

import java.util.Arrays;
import java.util.List;

import com.ldh.entity.ProductCategory;
import com.ldh.entity.ProductInfo;
import com.ldh.repository.ProductCategoryRepository;
import com.ldh.repository.ProductInfoRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Test
	public void tetsprotinf() {
		List<ProductInfo> list = this.productInfoRepository.findByProductStatus(0);
		System.out.println(list.size());
	}


	@Test
	public void tetsprotCategory() {
		List<ProductCategory> list = this.productCategoryRepository.findByCategoryTypeIn(Arrays.asList(1,12));
		System.out.println(list.size());
	}

}
