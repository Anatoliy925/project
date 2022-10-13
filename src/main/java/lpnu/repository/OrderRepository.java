package lpnu.repository;

import lpnu.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    private Long id = 0L;

    public List<Order> getAllOrders(){
        return new ArrayList<>(orders);
    }

    public Order save(Order item){
        ++id;
        item.setId(id.longValue());

        orders.add(item);

        return item;
    };

    public Order findById(Long id){
        return orders.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Order not found by id: " + id));
    }

    public void delete(Long id){
        orders = orders.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public Order update(Order item){
        Order saved = findById(item.getId());

        saved.setUser(item.getUser());
        saved.setOrderDetails(item.getOrderDetails());
        saved.setOrderDateTime(item.getOrderDateTime());

        return saved;
    }
}
