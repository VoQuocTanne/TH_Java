package Lab2.QuanLySach.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @NotNull(message = "ID không được để trống")
    @Min(value = 1, message = "ID phải là một số nguyên dương lớn hơn không")
    private int id;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 100, message = "Tiêu đề không được vượt quá 100 ký tự")
    private String title;

    @NotBlank(message = "Tác giả không được để trống")
    @Size(max = 100, message = "Tác giả không được vượt quá 100 ký tự")
    private String author;

    @NotNull(message = "Giá không được để trống")
    @Min(value = 1, message = "Giá phải là một số không âm")
    private Double price;

    @NotBlank(message = "Thể lại không được để trống")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Thể loại chỉ chấp nhận chữ cái và khoảng trống")
    private String category;
}
