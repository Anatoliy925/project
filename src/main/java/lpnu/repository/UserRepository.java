package lpnu.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import lpnu.entity.User;
import lpnu.util.JacksonUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private Long id = 0L;


    @PostConstruct
    public void init(){

        final Path file = Paths.get("users.txt");
        try {
            final String savedUsersAsString = Files.readString(file, StandardCharsets.UTF_16);
            users = JacksonUtil.deserialize(savedUsersAsString, new TypeReference<List<User>>() {});


            if (users == null) {
                users = new ArrayList<>();
                return;
            }

            final long maxId = users.stream().mapToLong(User::getId).max().orElse(1);

            this.id = maxId + 1;

        } catch (final Exception e){
            System.out.println("We have an issue");
            users = new ArrayList<>();
        }

    }


    @PreDestroy
    public void preDestroy(){
        final Path file = Paths.get("users.txt");

        try {
            Files.writeString(file, JacksonUtil.serialize(users), StandardCharsets.UTF_16);
        } catch (final Exception e){
            System.out.println("We have an issue");
        }
    }


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
