package lpnu.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import lpnu.entity.Pizza;
import lpnu.entity.Topping;
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
public class ToppingRepository {
    private List<Topping> toppings;
    private Long id = 0L;

    @PostConstruct
    public void init(){

        final Path file = Paths.get("toppings.txt");
        try {
            final String savedItemsAsString = Files.readString(file, StandardCharsets.UTF_16);
            toppings = JacksonUtil.deserialize(savedItemsAsString, new TypeReference<List<Topping>>() {});

            if (toppings == null) {
                toppings = new ArrayList<>();
                return;
            }

            final long maxId = toppings.stream().mapToLong(Topping::getId).max().orElse(1);

            this.id = maxId + 1;

        } catch (final Exception e){
            System.out.println("We have an issue");
            toppings = new ArrayList<>();
        }
    }


    @PreDestroy
    public void preDestroy(){
        final Path file = Paths.get("toppings.txt");

        try {
            Files.writeString(file, JacksonUtil.serialize(toppings), StandardCharsets.UTF_16);
        } catch (final Exception e){
            System.out.println("We have an issue");
        }
    }

    public List<Topping> getAllItems(){
        return new ArrayList<>(toppings);
    }

    public Topping save(Topping topping){
        ++id;
        topping.setId(id);

        toppings.add(topping);

        return topping;
    };

    public Topping findById(Long id){
        return toppings.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Topping not found by id: " + id));
    }

    public void delete(Long id){
        toppings = toppings.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public Topping update(Topping topping){
        Topping saved = findById(topping.getId());

        saved.setName(topping.getName());
        saved.setPrice(topping.getPrice());

        return saved;
    }
}
