package lpnu.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import lpnu.entity.Item;
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
public class ItemRepository {
    private List<Item> items;
    private Long id = 0L;

    @PostConstruct
    public void init(){

        final Path file = Paths.get("items.txt");
        try {
            final String savedItemsAsString = Files.readString(file, StandardCharsets.UTF_16);
            items = JacksonUtil.deserialize(savedItemsAsString, new TypeReference<List<Item>>() {});

            if (items == null) {
                items = new ArrayList<>();
                return;
            }

            final long maxId = items.stream().mapToLong(Item::getId).max().orElse(1);

            this.id = maxId + 1;

        } catch (final Exception e){
            System.out.println("We have an issue");
            items = new ArrayList<>();
        }
    }


    @PreDestroy
    public void preDestroy(){
        final Path file = Paths.get("items.txt");

        try {
            Files.writeString(file, JacksonUtil.serialize(items), StandardCharsets.UTF_16);
        } catch (final Exception e){
            System.out.println("We have an issue");
        }
    }

    public List<Item> getAllItems(){
        return new ArrayList<>(items);
    }

    public Item save(Item item){
        ++id;
        item.setId(id.longValue());

        items.add(item);

        return item;
    };

    public Item findById(Long id){
        return items.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item not found by id: " + id));
    }

    public void delete(Long id){
        items = items.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public Item update(Item item){
        Item saved = findById(item.getId());

        saved.setName(item.getName());
        saved.setPrice(item.getPrice());
        saved.setAvailable(item.getAvailable());

        return saved;
    }
}
