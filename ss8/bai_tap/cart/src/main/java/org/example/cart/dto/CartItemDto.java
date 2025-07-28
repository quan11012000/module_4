package org.example.cart.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.cart.entity.Product;
@Getter
@Setter
@NoArgsConstructor
public class CartItemDto {
    private Product product;
    private int quantity;
    public CartItemDto(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
