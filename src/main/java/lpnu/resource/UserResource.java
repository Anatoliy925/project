package lpnu.resource;

import lpnu.dto.UserDTO;
import lpnu.service.UserService;
import lpnu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        System.out.println(userService.getAllUsers());
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Long id) {
        System.out.println(userService.findById(id));
        return userService.findById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.create(userDTO);

        System.out.println(createdUser);
        return createdUser;
    }


    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        UserDTO updateduUser = userService.update(userDTO);

        System.out.println(updateduUser);
        return updateduUser;
    }



    // api/v1/user/7
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.delete(id);
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
