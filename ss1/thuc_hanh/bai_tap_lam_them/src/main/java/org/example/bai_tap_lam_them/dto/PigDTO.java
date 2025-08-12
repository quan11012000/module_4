package org.example.bai_tap_lam_them.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bai_tap_lam_them.entity.Country;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PigDTO {
    private String id;
    @NotNull(message = "Ngày nhập chuồng không được để trống")
    @PastOrPresent(message = "Ngày nhập chuồng không được là tương lai")
    private LocalDate timeIn;

    @Positive(message = "Trọng lượng nhập phải lớn hơn 0")
    private double weightIn;

    @PastOrPresent(message = "Ngày xuất chuồng không được là tương lai")
    private LocalDate timeOut;

    @Positive(message = "Trọng lượng nhập phải lớn hơn 0")
    private double weightOut;

    @NotNull(message = "Vui lòng chọn xuất xứ")
    private Country country;
}
