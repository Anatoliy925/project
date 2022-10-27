package lpnu.util;

import lpnu.entity.Order;
import lpnu.entity.enumeration.OrderStatus;

public class OrderStatusUtil {
    public static boolean canBeCancelled(Order order){
        return order.getOrderStatus() == OrderStatus.OPEN || order.getOrderStatus() == OrderStatus.PENDING;
    }

    public static boolean canBeClosed(Order order){
        return order.getOrderStatus() == OrderStatus.PENDING;
    }

    public static boolean canBePending(Order order){
        return order.getOrderStatus() == OrderStatus.OPEN;
    }
}
