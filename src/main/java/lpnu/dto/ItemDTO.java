package lpnu.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private int available;

    public ItemDTO() {
    }

    public ItemDTO(Long id, String name, BigDecimal price, int available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return available == itemDTO.available && Objects.equals(id, itemDTO.id) && Objects.equals(name, itemDTO.name) && Objects.equals(price, itemDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, available);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
