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
import lpnu.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToppingServiceImpl implements ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    @Override
    public List<ToppingDTO> getAllItems() {
        return toppingRepository.getAllItems().stream()
                .map(ToppingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ToppingDTO create(ToppingDTO toppingDTO) {
        Topping topping = ToppingMapper.toEntity(toppingDTO);
        toppingRepository.save(topping);

        return ToppingMapper.toDTO(topping);
    }

    @Override
    public void delete(Long id) {
        toppingRepository.delete(id);
    }

    @Override
    public ToppingDTO update(ToppingDTO toppingDTO) {
        Topping topping = ToppingMapper.toEntity(toppingDTO);

        toppingRepository.update(topping);

        return ToppingMapper.toDTO(topping);
    }

    @Override
    public ToppingDTO findById(Long id) {
        return ToppingMapper.toDTO(toppingRepository.findById(id));
    }


}
