package edu.ijse.lostandfound.service;

import edu.ijse.lostandfound.dto.ItemDto;

import java.util.ArrayList;

public interface ItemService {

    void saveItem(ItemDto itemDto) throws Exception;
    void updateItem(String id, ItemDto newDto) throws Exception;
    void deleteItem(String id) throws Exception;
    ItemDto searchItem(String id) throws Exception;
    ArrayList <ItemDto> getAllItem() throws Exception;

}
