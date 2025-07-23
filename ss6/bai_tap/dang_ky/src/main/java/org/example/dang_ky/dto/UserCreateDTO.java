package org.example.dang_ky.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dang_ky.validator.DuplicateEmail;
import org.example.dang_ky.validator.DuplicatePhoneNumber;


@Getter
@Setter
@NoArgsConstructor
public class UserCreateDTO {

    @NotBlank(message = "Họ không được để trống")
    @Size(min = 5, max = 45, message = "Họ phải từ 5 đến 45 ký tự")
    private String firstName;

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 45, message = "Tên phải từ 5 đến 45 ký tự")
    private String lastName;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(
            regexp = "^(\\+84|0)(3[2-9]|5[6|8|9]|7[06-9]|8[1-9]|9[0-9])[0-9]{7}$",
            message = "Số điện thoại không hợp lệ"
    )
    @DuplicatePhoneNumber
    private String phoneNumber;

    @Min(value = 18, message = "Tuổi phải lớn hơn hoặc bằng 18")
    private int age;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @DuplicateEmail
    private String email;
}

