package com.Qcat.Qcat.product.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductRepository {

    // PAGING
    Double getTotal();
    List<Map<String, Object>> getProducts(Integer product_page);

    // SEARCHING
    List<Map<String, Object>> searchProducts(Map<String, String> searchValue);

    // CRUD
    Map<String, Object> getProduct(int product_id);
    int insertProduct(Map<String, String> insertValue);
    int updateProduct(Map<String, String> updateValue);
    int deleteProduct(int product_id);

}
