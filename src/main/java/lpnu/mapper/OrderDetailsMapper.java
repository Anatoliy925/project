package lpnu.mapper;

import lpnu.dto.OrderDetailsDTO;
import lpnu.entity.OrderDetails;
import lpnu.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsMapper {

    @Autowired
    private PizzaRepository pizzaRepository;

    public OrderDetails toEntity(OrderDetailsDTO orderDetailsDTO){
        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setPizza(pizzaRepository.findById(orderDetailsDTO.getItemID()));
        orderDetails.setAmount(orderDetailsDTO.getAmount());

        return orderDetails;
    }

    public OrderDetailsDTO toDTO(OrderDetails orderDetails){
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        orderDetailsDTO.setItemID(orderDetails.getPizza().getId());
        orderDetailsDTO.setItemName(orderDetails.getPizza().getName());
        orderDetailsDTO.setAmount(orderDetails.getAmount());

        return orderDetailsDTO;
    }
}
