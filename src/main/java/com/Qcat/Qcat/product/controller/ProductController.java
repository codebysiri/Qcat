package com.Qcat.Qcat.product.controller;

import com.Qcat.Qcat.member.service.MemberService;
import com.Qcat.Qcat.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = {"/product/{store_id}/{product_page}", "/product"})
    public String getProduct(@PathVariable(required = false) Integer store_id, @PathVariable(required = false) Integer product_page, Model model) {
        Double total = productService.getTotal();
        int totalPage = (int) Math.ceil(total / 20);

        if(product_page != null) {
            model.addAttribute("store", productService.getStore(store_id));
            model.addAttribute("products", productService.getProducts((product_page - 1) * 10 * 2));
            model.addAttribute("totalPage", totalPage);
        } else {
            product_page = 1;
            model.addAttribute("store", productService.getStore(store_id));
            model.addAttribute("products", productService.getProducts((product_page - 1) * 10 * 2));
            model.addAttribute("totalPage", totalPage);
        }
        return "/product/board";
    }

    @GetMapping("/product/detail/{product_id}")
    public String getDetail(@PathVariable("product_id") int product_id, Model model) {

        model.addAttribute("product", productService.getProduct(product_id));
        return "/product/detail";
    }

    @GetMapping("/product/insert")
    public String insertGet(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("member_id") != null) {
            return "/product/insert";
        } else {
            return "/member/login";
        }
    }

    @PostMapping("/product/insert")
    public String insertPOST(@RequestParam Map<String, String> insertValue) {
        productService.insertProduct(insertValue);
        return "redirect:/product";
    }

    @GetMapping("/product/update/{product_id}")
    public String updateGet(@PathVariable("product_id") int product_id, Model model) {
        model.addAttribute("product", productService.getProduct(product_id));
        return "/product/productUpdate";
    }

    @PostMapping("/product/update")
    public String updatePOST(@RequestParam Map<String, String> updateValue) {
        productService.updateProduct(updateValue);
        return "redirect:/product";
    }

}
