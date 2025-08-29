package edu.ijse.lostandfound.controller;

import edu.ijse.lostandfound.dto.ItemDto;
import edu.ijse.lostandfound.service.ItemService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "item")
@NoArgsConstructor
public class ItemController {

    private ItemService itemService;

    @PostMapping
    public ResponseEntity <Void> saveItem(@RequestBody ItemDto itemDto){
        try {
            itemService.saveItem(itemDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping (value = {"/id"})
    public ResponseEntity <Void> updateItem(@PathVariable String id, @RequestBody ItemDto newDto){
        try {
            itemService.updateItem(id,newDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping (value = {"/id"})
    public ResponseEntity <Void> deleteItem(@PathVariable String id){
        try {
            itemService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping (value = {"/id"})
    public ResponseEntity <ItemDto> searchItem(@PathVariable String id){
        try{
            ItemDto itemDto = itemService.searchItem(id);
            if(itemDto == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(itemDto,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
