package lpnu.service.impl;

import lpnu.dto.ItemDTO;
import lpnu.entity.Item;
import lpnu.entity.enumeration.Status;
import lpnu.mapper.ItemMapper;
import lpnu.repository.ItemRepository;
import lpnu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<ItemDTO> getAllItems() {
        return itemRepository.getAllItems().stream()
                        .map(ItemMapper::toDTO)
                        .collect(Collectors.toList());
    }

    @Override
    public ItemDTO create(ItemDTO itemDTO) {
        Item item = ItemMapper.toEntity(itemDTO);
        item.setStatus(Status.ACTIVE);

        itemRepository.save(item);

        return ItemMapper.toDTO(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.delete(id);
    }

    @Override
    public ItemDTO update(ItemDTO itemDTO) {
        Item item = ItemMapper.toEntity(itemDTO);

        itemRepository.update(item);

        return ItemMapper.toDTO(item);
    }

    @Override
    public ItemDTO findById(Long id) {
        return ItemMapper.toDTO(itemRepository.findById(id));
    }


}
