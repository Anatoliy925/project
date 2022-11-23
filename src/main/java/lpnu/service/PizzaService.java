package lpnu.service;

import lpnu.dto.AddToppingToPizza;
import lpnu.dto.PizzaDTO;
import lpnu.dto.ToppingDTO;

import java.util.List;

public interface PizzaService {
    List<PizzaDTO> getAllItems();
    PizzaDTO create(PizzaDTO pizzaDTO);
    PizzaDTO findById(Long id);
    PizzaDTO update(PizzaDTO pizzaDTO);
    void addTopping(AddToppingToPizza addDTO);

    void delete(Long id);
}
