package com.api.ecommerce.purchase_orders.service;

import java.util.List;

import com.api.ecommerce.cart.models.CartProduct;
import com.api.ecommerce.cart.repository.CartRepository;
import com.api.ecommerce.jwt.JwtTokenUtil;
import com.api.ecommerce.purchase_orders.models.PurchaseOrder;
import com.api.ecommerce.purchase_orders.repository.PurchaseOrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PurchaseOrdersService {
    
    @Autowired
    PurchaseOrdersRepository purchaseOrdersRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    public PurchaseOrder generate() {
        String userEmail = jwtTokenUtil.getEmailFromToken();
        List<CartProduct> cartProducts = cartRepository.findByUserEmail(userEmail);
        if(cartProducts == null || cartProducts.size() == 0) {
            log.warn("There are no products added to cart yet");
            return null;
        }
        PurchaseOrder order = new PurchaseOrder(); 
        for(CartProduct product : cartProducts){
            order.setTotalPrice(order.getTotalPrice() + product.getPrice() * product.getAmount());
            order.getProducts().add(product);
        }
        order.setStatus("generated");

        return purchaseOrdersRepository.create(order);
    }

    
}
