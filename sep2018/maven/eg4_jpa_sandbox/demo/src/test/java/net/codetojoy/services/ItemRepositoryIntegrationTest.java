
package net.codetojoy.services;

import net.codetojoy.models.Item;

import org.junit.*;
import org.junit.runner.*;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryIntegrationTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ItemRepository itemRepository;
 
    @Test
    public void whenFindByName_thenReturnItem() {
        Item item = new Item();
        item.setName("Van Halen");
        entityManager.persist(item);
        entityManager.flush();
     
        // test
        Item result = itemRepository.findByName(item.getName());
     
        assertThat(result.getName()).isEqualTo(item.getName());
    }
}
