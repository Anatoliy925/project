package lpnu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enumeration.Status;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Min(value = 0, message = "Price should be greater than 0")
    private BigDecimal price;
    @NotNull
    @Min(value = 0, message = "Available should be greater than 0")
    private int available;
    private Status status;

}
