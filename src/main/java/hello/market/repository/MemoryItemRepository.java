package hello.market.repository;

import hello.market.domain.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryItemRepository implements ItemRepository {

  private static Map<Long, Item> items = new HashMap<>();
  private static long sequence = 0L;

  @Override
  public Item add(Item item) {
    item.setId(++sequence);
    items.put(item.getId(), item);
    return item;
  }

  @Override
  public List<Item> findAll() {
    return new ArrayList<>(items.values());
  }

  @Override
  public void delete(Item item) {
    items.remove(item.getId());
  }

  @Override
  public void update(Item item) {
    items.put(item.getId(), item);
  }


  public void clearStore() {
    items.clear();
  }

}
