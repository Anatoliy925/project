package lpnu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToppingDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Min(value = 0, message = "Price should be greater than 0")
    private int price;
}
