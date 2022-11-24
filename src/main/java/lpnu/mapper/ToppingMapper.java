package lpnu.mapper;

import lpnu.dto.PizzaDTO;
import lpnu.dto.ToppingDTO;
import lpnu.entity.Pizza;
import lpnu.entity.Topping;

public class ToppingMapper {
    public static ToppingDTO toDTO(Topping topping){
        ToppingDTO toppingDTO = new ToppingDTO();

        toppingDTO.setId(topping.getId());
        toppingDTO.setName(topping.getName());
        toppingDTO.setPrice(topping.getPrice());

        return toppingDTO;
    }

    public static Topping toEntity(ToppingDTO toppingDTO){
        Topping topping = new Topping();

        topping.setId(toppingDTO.getId());
        topping.setName(toppingDTO.getName());
        topping.setPrice(toppingDTO.getPrice());

        return topping;
    }
}
