package lpnu.mapper;


import lpnu.dto.ItemDTO;
import lpnu.entity.Item;

public class ItemMapper {
    public static ItemDTO toDTO(Item item){
        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setAvailable(item.getAvailable());

        return itemDTO;
    }

    public static Item toEntity(ItemDTO itemDTO){
        Item item = new Item();

        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setAvailable(itemDTO.getAvailable());

        return item;
    }
}
