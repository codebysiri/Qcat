package com.Qcat.Qcat.product.controller;

import com.Qcat.Qcat.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductRestController {

    @Autowired
    ProductService productService;

    @PostMapping("/product/search")
    public List<Map<String, Object>> searchProduct(@RequestParam Map<String, String> searchValue) {
        return productService.searchProducts(searchValue);
    }

    @PostMapping("/product/delete/{product_id}")
    public int deleteProduct(@PathVariable("product_id") int product_id) {
        return productService.deleteProduct(product_id);
    }

}
