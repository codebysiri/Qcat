package com.Qcat.Qcat.product.service;

import java.util.List;
import java.util.Map;

public interface ProductService {

    // PAGING
    Double getTotal();
    List<Map<String, Object>> getProducts(Integer product_page);
    List<Map<String, Object>> getStore(Integer store_id);

    // SEARCHING
    List<Map<String, Object>> searchProducts(Map<String, String> searchValue);

    // CRUD
    Map<String, Object> getProduct(int product_id);
    int insertProduct(Map<String, String> insertValue);
    int updateProduct(Map<String, String> updateValue);
    int deleteProduct(int product_id);


}
