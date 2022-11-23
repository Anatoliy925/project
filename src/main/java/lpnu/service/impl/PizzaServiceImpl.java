package lpnu.service.impl;

import lpnu.dto.PizzaDTO;
import lpnu.entity.Pizza;
import lpnu.entity.enumeration.Status;
import lpnu.mapper.PizzaMapper;
import lpnu.repository.PizzaRepository;
import lpnu.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public List<PizzaDTO> getAllItems() {
        return pizzaRepository.getAllItems().stream()
                        .map(PizzaMapper::toDTO)
                        .collect(Collectors.toList());
    }

    @Override
    public PizzaDTO create(PizzaDTO pizzaDTO) {
        Pizza pizza = PizzaMapper.toEntity(pizzaDTO);
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
    public PizzaDTO findById(Long id) {
        return PizzaMapper.toDTO(pizzaRepository.findById(id));
    }


}
