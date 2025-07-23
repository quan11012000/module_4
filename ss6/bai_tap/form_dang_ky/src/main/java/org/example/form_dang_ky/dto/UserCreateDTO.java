package org.example.form_dang_ky.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateDTO {
    @NotBlank(message = "Tên không được để trống")
    @Pattern(
            regexp = "^[\\p{L}]+( [\\p{L}]+)*$",
            message = "Tên chỉ chứa chữ cái (có dấu hoặc không) và 1 dấu cách giữa các từ"
    )
    private String username;
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$",
            message = "Mật khẩu phải chứa ít nhất 1 chữ hoa, 1 chữ thường và 1 chữ số"
    )
    private String password;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;
    @NotNull(message = "Giới tính bắt buộc phải chọn")
    private Boolean gender;
    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(min = 5, message = "Địa chỉ phải có ít nhất 5 ký tự")
    private String address;
}
