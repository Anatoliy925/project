package lpnu.resource;

import lpnu.dto.AddItemToOrderDTO;
import lpnu.dto.AddToppingToPizza;
import lpnu.dto.PizzaDTO;
import lpnu.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pizza")
public class PizzaResource {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping
    public List<PizzaDTO> getAllItems() {
        return pizzaService.getAllItems();
    }

    @GetMapping("/{id}")
    public PizzaDTO findById(@PathVariable Long id) {
        return pizzaService.findById(id);
    }

    @PostMapping
    public PizzaDTO createItem(@RequestBody @Validated PizzaDTO pizzaDTO) {
        return pizzaService.create(pizzaDTO);
    }

    @PostMapping("/add-ingredient")
    public void addIngredientToPizza(@RequestBody @Validated AddToppingToPizza addDTO) {
        pizzaService.addTopping(addDTO);
    }

    @PutMapping
    public PizzaDTO updateItem(@RequestBody @Validated PizzaDTO pizzaDTO) {
        return pizzaService.update(pizzaDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        pizzaService.delete(id);
        return ResponseEntity.ok().build();
    }
}







/*
Postman

    500 - проблема сервера, погано написаний код. Наприклад впав NullPointer

    200 - OK
    201 - created - об'єкт був створений


    400 - Bad request   - юзер прислав погані дані
    401 - Unauthorized  - не залогінилися але хоче щось зробити
    403 - Forbidden     - не залогінилися але хоче щось зробити. Але навіть якщо залогінитеся то не маєте права нічого робити
    404 - page not found / resource not found


    GET - отримати один або багато ресурсів

    POST - зберегти один ресурс

    PUT - оновлює повністю один ресурс

    PATCH - оновлює частково один ресурс

    DELETE - видалити один або багато ресурсів



    {
        "id" : 8
        "name" : "N",
        "surname" : "S",
        "email" : "E@E"
    }
     + by PUT
    {
        "id" : 8
        "name" : "123",
        "surname" : "456"
    }

    =
     {
        "id" : 8
        "name" : "123",
        "surname" : "456",
        "email" : null
    }

    ==========================================

       {
        "id" : 8
        "name" : "N",
        "surname" : "S",
        "email" : "E@E"
    }
     + by PATCH
    {
        "id" : 8
        "name" : "123",
        "surname" : "456"
    }

    =
     {
        "id" : 8
        "name" : "123",
        "surname" : "456",
        "email" : "E@E"
    }

 */
