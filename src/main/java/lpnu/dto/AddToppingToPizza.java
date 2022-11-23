package lpnu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToppingToPizza {
    @Positive
    @NotNull
    private Long pizzaId;
    @Positive
    @NotNull
    private Long toppingId;
    @Positive
    private int amount;
}
