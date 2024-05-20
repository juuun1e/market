package hello.market.repository;

import hello.market.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
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
  public void delete(Long itemId) {
    items.remove(itemId);
  }

  @Override
  public void update(Item item) {
    items.put(item.getId(), item);
  }


  public void clearStore() {
    items.clear();
  }

}
