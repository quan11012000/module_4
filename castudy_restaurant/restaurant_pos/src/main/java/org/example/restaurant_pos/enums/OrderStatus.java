package org.example.restaurant_pos.enums;


public enum OrderStatus {
        PENDING,    // Đơn hàng mới, chưa xử lý
        PREPARING,  // Đang chuẩn bị món
        READY,      // Món đã sẵn sàng để phục vụ / thanh toán
        COMPLETED   // Đơn đã hoàn tất và thanh toán xong
}

