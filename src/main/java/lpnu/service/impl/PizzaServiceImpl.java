package lpnu.service.impl;

import lpnu.dto.AddToppingToPizza;
import lpnu.dto.PizzaDTO;
import lpnu.dto.ToppingDTO;
import lpnu.entity.Order;
import lpnu.entity.OrderDetails;
import lpnu.entity.Pizza;
import lpnu.entity.Topping;
import lpnu.entity.enumeration.OrderStatus;
import lpnu.entity.enumeration.Status;
import lpnu.exception.ServiceException;
import lpnu.mapper.PizzaMapper;
import lpnu.mapper.ToppingMapper;
import lpnu.repository.PizzaRepository;
import lpnu.repository.ToppingRepository;
import lpnu.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private ToppingRepository toppingRepository;

    @Override
    public List<PizzaDTO> getAllItems() {
        return pizzaRepository.getAllItems().stream()
                        .map(PizzaMapper::toDTO)
                        .collect(Collectors.toList());
    }

    @Override
    public PizzaDTO create(PizzaDTO pizzaDTO) {
        Pizza pizza = PizzaMapper.toEntity(pizzaDTO);
        pizza.setToppings(new ArrayList<>());
        pizza.setStatus(Status.ACTIVE);

        pizzaRepository.save(pizza);

        return PizzaMapper.toDTO(pizza);
    }

    @Override
    public void delete(Long id) {
        pizzaRepository.delete(id);
    }

    @Override
    public PizzaDTO update(PizzaDTO pizzaDTO) {
        Pizza pizza = PizzaMapper.toEntity(pizzaDTO);

        pizzaRepository.update(pizza);

        return PizzaMapper.toDTO(pizza);
    }

    @Override
    public void addTopping(AddToppingToPizza addDTO) {

        Pizza pizza = pizzaRepository.findById(addDTO.getPizzaId());

        Topping topping = toppingRepository.findById(addDTO.getToppingId());

        pizza.getToppings().add(topping);

        pizzaRepository.update(pizza);
    }

    @Override
    public PizzaDTO findById(Long id) {
        return PizzaMapper.toDTO(pizzaRepository.findById(id));
    }


}
