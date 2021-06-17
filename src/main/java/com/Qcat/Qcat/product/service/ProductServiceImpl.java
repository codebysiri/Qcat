package com.Qcat.Qcat.product.service;

import com.Qcat.Qcat.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    // PAGING
    @Override
    public Double getTotal() {
        return productRepository.getTotal();
    }
    @Override
    public List<Map<String, Object>> getProducts(Integer product_page) {
        return productRepository.getProducts(product_page);
    }

    // SEARCHING
    public List<Map<String, Object>> searchProducts(Map<String, String> searchValue) {
        return productRepository.searchProducts(searchValue);
    }

    // CRUD
    @Override
    public Map<String, Object> getProduct(int product_id) {
        return productRepository.getProduct(product_id);
    }

    @Override
    public int insertProduct(Map<String, String> insertValue) {
        return productRepository.insertProduct(insertValue);
    }

    @Override
    public int updateProduct(Map<String, String> updateValue) {
        return productRepository.updateProduct(updateValue);
    }

    @Override
    public int deleteProduct(int product_id) {
        return productRepository.deleteProduct(product_id);
    }

}
