package lpnu.service.impl;

import lpnu.dto.OrderDTO;
import lpnu.entity.Order;
import lpnu.entity.User;
import lpnu.entity.enumeration.OrderStatus;
import lpnu.mapper.OrderMapper;
import lpnu.mapper.UserMapper;
import lpnu.repository.OrderRepository;
import lpnu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);

        order.setOrderDateTime(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.OPEN);

        orderRepository.save(order);

        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO findById(Long id) {
        return orderMapper.toDTO(orderRepository.findById(id));
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);

        orderRepository.update(order);

        return orderMapper.toDTO(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
    }
}
