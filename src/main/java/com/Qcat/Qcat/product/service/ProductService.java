package com.Qcat.Qcat.product.service;

import java.util.Map;

public interface ProductService {

    Map<String, Object> getProduct(int product_id);
    int insertProduct(Map<String, String> insertValue);
    int updateProduct(Map<String, String> updateValue);
    int deleteProduct(int product_id);

}
