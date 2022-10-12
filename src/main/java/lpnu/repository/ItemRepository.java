package lpnu.repository;

import lpnu.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {
    private List<Item> items = new ArrayList<>();
    private Long id = 0L;

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
