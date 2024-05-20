package hello.market.repository;

import hello.market.domain.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트는 서로 순서와 관계없이, 의존관계 없이 설계 되어야 한다.
class MemoryItemRepositoryTest {
  MemoryItemRepository repository = new MemoryItemRepository();

  // 테스트 실행이 되고 끝날 때마다 한 번씩 저장소를 비우는 역할
  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void add() {
    //given
    Item item = new Item();
    item.setTitle("spring");

    //when
    repository.add(item);

    //then
    List<Item> result = repository.findAll();
    assertThat(result).contains(item); // 리스트에 아이템이 추가되었는지 확인
  }

  @Test
  public void findByAll() {
    //given
    Item item1 = new Item();
    item1.setTitle("spring1");
    repository.add(item1);

    Item item2 = new Item();
    item2.setTitle("spring2");
    repository.add(item2);

    //when
    List<Item> result = repository.findAll();

    //then
    assertThat(result.size()).isEqualTo(2); // 저장된 아이템 개수가 맞는지 확인
    assertThat(result).contains(item1, item2); // 저장된 아이템이 올바른지 확인
  }

  @Test
  public void delete() {
    //given
    Item item = new Item();
    item.setTitle("spring");
    Item addedItem = repository.add(item); // 아이템 추가

    //when
    repository.delete(addedItem); // 아이템 삭제

    //then
    assertThat(repository.findAll()).doesNotContain(addedItem); // 리스트에 아이템이 삭제되었는지 확인
  }

  @Test
  public void update() {
    //given
    Item item = new Item();
    item.setTitle("spring");
    Item addedItem = repository.add(item); // 아이템 추가

    //when
    addedItem.setTitle("updated title");
    repository.update(addedItem); // 아이템 업데이트

    //then
    assertThat(repository.findAll().get(0).getTitle()).isEqualTo("updated title"); // 아이템이 업데이트되었는지 확인
  }

}
