
package net.codetojoy.services;

import net.codetojoy.models.Code;

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
public class CodeRepositoryIntegrationTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private CodeRepository codeRepository;
 
    @Test
    public void whenFindByName_thenReturnCode() {
        Code code = new Code();
        code.setName("Van Halen");
        entityManager.persist(code);
        entityManager.flush();
     
        // test
        Code result = codeRepository.findByName(code.getName());
     
        assertThat(result.getName()).isEqualTo(code.getName());
    }
}
