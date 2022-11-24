package lpnu.service;

import lpnu.dto.AddToppingToPizza;
import lpnu.dto.PizzaDTO;
import lpnu.dto.ToppingDTO;

import java.util.List;

public interface ToppingService {
    List<ToppingDTO> getAllItems();
    ToppingDTO create(ToppingDTO toppingDTO);
    ToppingDTO findById(Long id);
    ToppingDTO update(ToppingDTO toppingDTO);

    void delete(Long id);
}