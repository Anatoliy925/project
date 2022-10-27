package lpnu.entity.enumeration;

public enum OrderStatus {
    OPEN, PENDING, CLOSED, CANCELED
}



/*
        OPEN -> CANCELED
        OPEN -> PENDING -> CANCELED
        OPEN -> PENDING -> CLOSED

        OPEN - створене замовлення, можна редагувати товари у ньому
        PENDING - чекає на перевірку менеджером
        CLOSED - оплачене замовлення, неможна ніяк міняти
        CANCELED - скасоване замовлення, неможна ніяк міняти


        State Machine -
 */
