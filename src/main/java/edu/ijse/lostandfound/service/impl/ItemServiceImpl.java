package edu.ijse.lostandfound.service.impl;

import edu.ijse.lostandfound.dao.ItemDao;
import edu.ijse.lostandfound.dto.ItemDto;
import edu.ijse.lostandfound.entity.ItemEntity;
import edu.ijse.lostandfound.service.ItemService;

import java.util.ArrayList;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {

    private ItemDao itemDao;

    @Override
    public void saveItem(ItemDto itemDto) throws Exception {

        ItemEntity itemEntity = new ItemEntity(
            itemDto.getId(),
            itemDto.getName(),
            itemDto.getDescription(),
            itemDto.getItemTypes()
        );

        itemDao.save(itemEntity);
    }

    @Override
    public void updateItem(String id, ItemDto newDto) throws Exception {

        Optional <ItemEntity> foundedItem = itemDao.findById(id);
        if(!foundedItem.isPresent()){
            throw new Exception("Item Not Found");
        }

        ItemEntity itemEntity = foundedItem.get();
        itemEntity.setName(newDto.getName());
        itemEntity.setDescription(newDto.getDescription());
        itemEntity.setItemTypes(newDto.getItemTypes());

        itemDao.save(itemEntity);

    }

    @Override
    public void deleteItem(String id) throws Exception {

        Optional <ItemEntity> foundedItem = itemDao.findById(id);
        if(!foundedItem.isPresent()){
            throw new Exception("Item Not Found");
        }

        itemDao.deleteById(id);

    }

    @Override
    public ItemDto searchItem(String id) throws Exception {

        Optional <ItemEntity> foundedItem = itemDao.findById(id);
        if(!foundedItem.isPresent()){
            throw new Exception("Item Not Found");
        }

        ItemEntity itemEntity = foundedItem.get();
        ItemDto itemDto = new ItemDto(
                itemEntity.getId(),
                itemEntity.getName(),
                itemEntity.getDescription(),
                itemEntity.getItemTypes()
        );

        return itemDto;
    }

    @Override
    public ArrayList<ItemDto> getAllItem() throws Exception {
        return null;
    }
}
