package hello.market.service;

import hello.market.domain.Item;
import hello.market.repository.MemoryItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemServiceTest {

  ItemService itemService;
  MemoryItemRepository itemRepository;

  @BeforeEach
  public void beforeEach() {
    itemRepository = new MemoryItemRepository();
    itemService = new ItemService(itemRepository);
  }

  // 테스트 실행이 되고 끝날 때마다 한 번씩 저장소를 비우는 역할
  @AfterEach
  public void afterEach() {
    itemRepository.clearStore();
  }


  @Test
  void add() {
  // given
  Item item = new Item();
    item.setTitle("Test item");

  // when
  Item addedItem = itemService.add(item);

  // then
  assertThat(addedItem.getId()).isNotNull(); // 아이템이 추가되면 ID가 할당되어 있어야 함
  assertThat(itemRepository.findAll()).contains(addedItem); // 저장소에 추가된 아이템이 있어야 함
}

  @Test
  void findAll() {
    // given
    Item item1 = new Item();
    item1.setTitle("Test item 1");
    Item item2 = new Item();
    item2.setTitle("Test item 2");
    itemService.add(item1);
    itemService.add(item2);

    // when
    List<Item> foundItems = itemService.findAll();

    // then
    assertThat(foundItems).hasSize(2); // 저장소에서 조회된 아이템은 2개여야 함
    assertThat(foundItems).contains(item1, item2); // 저장소에서 조회된 아이템에는 추가한 아이템이 포함되어 있어야 함
  }

  @Test
  void update() {
    // given
    Item item = new Item();
    item.setTitle("Test item");
    Item addedItem = itemService.add(item);
    addedItem.setTitle("Updated title");

    // when
    itemService.update(addedItem);

    // then
    assertThat(itemRepository.findAll()).contains(addedItem); // 업데이트된 아이템이 저장소에 있어야 함
    assertThat(itemRepository.findAll().get(0).getTitle()).isEqualTo("Updated title"); // 저장소에서 조회된 아이템의 제목이 업데이트된 제목과 일치해야 함
  }

  @Test
  void delete() {
    // given
    Item item = new Item();
    item.setTitle("Test item");
    Item addedItem = itemService.add(item);

    // when
    itemService.delete(addedItem);

    // then
    assertThat(itemRepository.findAll()).doesNotContain(addedItem); // 삭제된 아이템은 저장소에 없어야 함
  }
}
