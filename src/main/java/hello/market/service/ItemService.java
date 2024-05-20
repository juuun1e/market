package hello.market.service;

import hello.market.domain.Item;
import hello.market.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

  private final ItemRepository itemRepository;

  public ItemService(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  // 게시글 작성
  public Item add(Item item) {
    return itemRepository.add(item);
  }

  // 전체 게시글 조회
  public List<Item> findAll() {
    return itemRepository.findAll();
  }

  // 게시글 수정
  public void update(Item item) {
    itemRepository.update(item);
  }

  // 게시글 삭제
  public void delete(Long itemId) {
    itemRepository.delete(itemId);
  }
}
