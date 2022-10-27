package lpnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enumeration.Status;

import java.math.BigDecimal;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private BigDecimal price;
    private int available;
    private Status status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
