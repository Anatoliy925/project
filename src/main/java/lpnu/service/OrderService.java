package lpnu.service;


import lpnu.dto.AddItemToOrderDTO;
import lpnu.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO create(OrderDTO orderDTO);
    OrderDTO findById(Long id);
//    OrderDTO update(OrderDTO orderDTO);

    void delete(Long id);
    void cancelOrder(Long orderId);
    void closeOrder(Long orderId);
    void pendingOrder(Long orderId);

    void addItemToOrder(AddItemToOrderDTO addDTO);
    //todo

    /*
          addItemToOrder(Long orderId, Long itemId, int amount);
          deleteItemFromOrder(Long orderId, Long itemId);
          changeItemAmountInOrder(Long orderId, Long itemId, int amount);
     */

}
