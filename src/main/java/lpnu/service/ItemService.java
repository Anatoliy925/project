package lpnu.service;

import lpnu.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getAllItems();
    ItemDTO create(ItemDTO itemDTO);
    ItemDTO findById(Long id);
    ItemDTO update(ItemDTO itemDTO);

    void delete(Long id);
}
