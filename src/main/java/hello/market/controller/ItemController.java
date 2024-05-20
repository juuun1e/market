package hello.market.controller;

import hello.market.domain.Item;
import hello.market.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

  private final ItemService itemService;

  @Autowired
  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @PostMapping
  public ResponseEntity<Item> addItem(@RequestBody Item item) {
    Item addedItem = itemService.add(item);
    return new ResponseEntity<>(addedItem, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Item>> getAllItems() {
    List<Item> items = itemService.findAll();
    return new ResponseEntity<>(items, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateItem(@PathVariable Long id, @RequestBody Item item) {
    item.setId(id);
    itemService.update(item);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
    itemService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
