package lpnu.service.impl;

import lpnu.dto.AddItemToOrderDTO;
import lpnu.dto.OrderDTO;
import lpnu.entity.Pizza;
import lpnu.entity.Order;
import lpnu.entity.OrderDetails;
import lpnu.entity.enumeration.OrderStatus;
import lpnu.exception.ServiceException;
import lpnu.mapper.OrderMapper;
import lpnu.repository.PizzaRepository;
import lpnu.repository.OrderRepository;
import lpnu.service.OrderService;
import lpnu.util.OrderStatusUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PizzaRepository pizzaRepository;


    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);

        order.setOrderDateTime(null);
        order.setOrderStatus(OrderStatus.OPEN);
        order.setOrderDetails(new ArrayList<>());

        orderRepository.save(order);

        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO findById(Long id) {
        return orderMapper.toDTO(orderRepository.findById(id));
    }

    @Override
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId);

        if (!OrderStatusUtil.canBeCancelled(order)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(),
                    "Order can't be moved to CANCELLED state. Current state of order is: " + order.getOrderStatus());
        }

        order.setOrderStatus(OrderStatus.CANCELED);
        order.setOrderDateTime(LocalDateTime.now());

        orderRepository.update(order);
    }

    @Override
    public void closeOrder(Long orderId) {
        Order order = orderRepository.findById(orderId);

        if (!OrderStatusUtil.canBeClosed(order)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(),
                    "Order can't be moved to CLOSED state. Current state of order is: " + order.getOrderStatus());
        }

        order.setOrderStatus(OrderStatus.CLOSED);
        order.setOrderDateTime(LocalDateTime.now());

        orderRepository.update(order);
    }

    @Override
    public void pendingOrder(Long orderId) {
        Order order = orderRepository.findById(orderId);

        if (!OrderStatusUtil.canBePending(order)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(),
                    "Order can't be moved to PENDING state. Current state of order is: " + order.getOrderStatus());
        }

        order.setOrderStatus(OrderStatus.PENDING);
        order.setOrderDateTime(LocalDateTime.now());

        orderRepository.update(order);
    }

    @Override
    public void addItemToOrder(AddItemToOrderDTO addDTO) {

        Order order = orderRepository.findById(addDTO.getOrderId());

        if (order.getOrderStatus() != OrderStatus.OPEN) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "Order can't be changed. Order id: " + order.getId());
        }

        Pizza pizza = pizzaRepository.findById(addDTO.getItemId());



        boolean isItemInOrder = order.getOrderDetails().stream()
                .map(OrderDetails::getPizza)
                .anyMatch(e -> e.equals(pizza));

        if(isItemInOrder){
            OrderDetails savedOrderDetails = order.getOrderDetails().stream()
                    .filter(e -> e.getPizza().equals(pizza))
                    .findFirst().get();

            savedOrderDetails.setAmount(savedOrderDetails.getAmount() + addDTO.getAmount());

            orderRepository.update(order);

        } else {
            OrderDetails orderDetails = new OrderDetails(pizza, addDTO.getAmount());
            order.getOrderDetails().add(orderDetails);

            orderRepository.update(order);
        }
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(id);
    }


    //    @Override
//    public OrderDTO update(OrderDTO orderDTO) {
//        Order order = orderMapper.toEntity(orderDTO);
//
//        orderRepository.update(order);
//
//        return orderMapper.toDTO(order);
//    }
}
