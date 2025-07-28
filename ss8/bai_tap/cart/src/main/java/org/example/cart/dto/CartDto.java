package org.example.cart.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<Long, CartItemDto> items = new HashMap<>();

    public Map<Long, CartItemDto> getItems() {
        return items;
    }

    public void setItems(Map<Long, CartItemDto> items) {
        this.items = items;
    }
}
