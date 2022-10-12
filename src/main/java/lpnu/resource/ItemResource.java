package lpnu.resource;

import lpnu.dto.ItemDTO;
import lpnu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemResource {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<ItemDTO> getAllItems() {
        System.out.println(itemService.getAllItems());
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemDTO findById(@PathVariable Long id) {
        System.out.println(itemService.findById(id));
        return itemService.findById(id);
    }

    @PostMapping
    public ItemDTO createItem(@RequestBody ItemDTO itemDTO) {
        ItemDTO createdItem = itemService.create(itemDTO);

        System.out.println(createdItem);
        return createdItem;
    }


    @PutMapping
    public ItemDTO updateItem(@RequestBody ItemDTO itemDTO) {
        ItemDTO updatedItem = itemService.update(itemDTO);

        System.out.println(updatedItem);
        return updatedItem;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        itemService.delete(id);
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
