package lpnu.repository;

import lpnu.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private Long id = 0L;

    public List<User> getAllUsers(){
        return new ArrayList<>(users);
    }

    public User save(User user){
        ++id;
        user.setId(id.longValue());

        users.add(user);

        return user;
    };

    public User findById(Long id){
        return users.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User not found by id: " + id));
    }

    public void delete(Long id){
        users = users.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public User update(User user){
        User saved = findById(user.getId());

        saved.setName(user.getName());
        saved.setSurname(user.getSurname());
        saved.setEmail(user.getEmail());
        saved.setBirthday(user.getBirthday());

        return saved;
    }
}
