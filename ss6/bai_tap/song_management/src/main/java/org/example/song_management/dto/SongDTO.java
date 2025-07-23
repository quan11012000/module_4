package org.example.song_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongDTO {
    private Long id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 800, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9À-ỹ\\s]+$", message = "Tên không được chứa kí tự đặc biệt")
    private String name;

    @NotBlank(message = "Nghệ sĩ không được để trống")
    @Size(max = 300, message = "Không vượt quá 300 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9À-ỹ\\s]+$", message = "Nghệ sĩ không được chứa kí tự đặc biệt")
    private String artist;

    @NotBlank(message = "Thể loại không được để trống")
    @Size(max = 1000, message = "Không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[a-zA-Z0-9À-ỹ\\s,]+$", message = "Thể loại chỉ được chứa chữ, số, dấu cách và dấu phẩy")
    private String genre;
}