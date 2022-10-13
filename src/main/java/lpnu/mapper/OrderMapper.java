package lpnu.mapper;

import lpnu.dto.OrderDTO;
import lpnu.entity.Order;
import lpnu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    public Order toEntity(OrderDTO orderDTO){
        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setUser(userRepository.findById(orderDTO.getUserId()));
        order.setOrderDetails(orderDTO.getOrderDetails().stream().map(orderDetailsMapper::toEntity).collect(Collectors.toList()));
        order.setOrderDateTime(orderDTO.getOrderDateTime());
        order.setOrderStatus(orderDTO.getOrderStatus());

        return order;
    }
    public OrderDTO toDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setUserId(order.getUser().getId());
        orderDTO.setOrderDateTime(order.getOrderDateTime());
        orderDTO.setOrderDetails(order.getOrderDetails().stream().map(orderDetailsMapper::toDTO).collect(Collectors.toList()));
        orderDTO.setOrderStatus(order.getOrderStatus());

        return orderDTO;
    }
}
