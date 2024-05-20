package hello.market.repository;

import hello.market.domain.Item;

import java.util.List;

public interface ItemRepository {
  Item add(Item item);
  void update(Item item);
  void delete(Item item);
  List<Item> findAll();
}
