package com.Qcat.Qcat.product.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface ProductRepository {

    Map<String, Object> getProduct(int product_id);
    int insertProduct(Map<String, String> insertValue);
    int updateProduct(Map<String, String> updateValue);
    int deleteProduct(int product_id);

}
