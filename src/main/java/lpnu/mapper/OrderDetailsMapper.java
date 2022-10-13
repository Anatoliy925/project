package lpnu.mapper;

import lpnu.dto.OrderDetailsDTO;
import lpnu.entity.OrderDetails;
import lpnu.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsMapper {

    @Autowired
    private ItemRepository itemRepository;

    public OrderDetails toEntity(OrderDetailsDTO orderDetailsDTO){
        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setItem(itemRepository.findById(orderDetailsDTO.getItemID()));
        orderDetails.setAmount(orderDetailsDTO.getAmount());

        return orderDetails;
    }

    public OrderDetailsDTO toDTO(OrderDetails orderDetails){
        OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();

        orderDetailsDTO.setItemID(orderDetails.getItem().getId());
        orderDetailsDTO.setItemName(orderDetails.getItem().getName());
        orderDetailsDTO.setAmount(orderDetails.getAmount());

        return orderDetailsDTO;
    }
}
