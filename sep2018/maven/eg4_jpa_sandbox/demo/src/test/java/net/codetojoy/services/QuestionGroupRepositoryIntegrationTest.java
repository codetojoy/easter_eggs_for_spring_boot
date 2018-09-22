
package net.codetojoy.services;

import net.codetojoy.models.*;

import java.util.*;

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
public class QuestionGroupRepositoryIntegrationTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private QuestionGroupRepository questionGroupRepository;

    @Autowired
    private CodeRepository codeRepository;

    private Code code = null;

    // TODO: use mocks for these lower objects
    // TODO: Code/Value ownership is really weird 

    private Code buildCode() {
        if (code == null) {
            code = new Code();
            code.setName("");
            entityManager.persist(code);
            entityManager.flush();
            List<Code> codes = codeRepository.findAll();
            code = codes.get(0);
        }

        return code;
    }

    private QuestionGroup buildQuestionGroup(Long questionId, String prefix, int sequence) {
        QuestionGroup qGroup = new QuestionGroup();

        Code code = buildCode();

        Question question = new Question();
        question.setDesc("" + questionId);
        question.setCode(code);
        entityManager.persist(question);
        entityManager.flush();

        qGroup.setQuestion(question);
        qGroup.setPrefix(prefix);
        qGroup.setSequence(sequence);
        qGroup.setTier(1);
        qGroup.setActivationThreshold(2);
        qGroup.setComments(false);
        qGroup.setMandatory(false);
        qGroup.setMutex(false);

        return qGroup;
    }
 
    @Test
    public void whenFindAllWithOrder_thenReturnQuestionGroup() {
        /*
        QuestionGroup qGroup3 = buildQuestionGroup(30L, "q3", 3);
        QuestionGroup qGroup2 = buildQuestionGroup(20L, "q2", 2);
        QuestionGroup qGroup1 = buildQuestionGroup(10L, "q1", 1);

        entityManager.persist(qGroup3);
        entityManager.persist(qGroup2);
        entityManager.persist(qGroup1);
        entityManager.flush();
        */

        // this loads from data.sql !!
 
        // test
        List<QuestionGroup> results = questionGroupRepository.findAllWithOrder();

        assertThat(results.size()).isEqualTo(5);
        assertThat(results.get(0).getSequence()).isEqualTo(1);
        assertThat(results.get(1).getSequence()).isEqualTo(2);
        assertThat(results.get(2).getSequence()).isEqualTo(3);
        assertThat(results.get(3).getSequence()).isEqualTo(4);
        assertThat(results.get(4).getSequence()).isEqualTo(5);

        /*
        for (QuestionGroup qGroup : results) {
            System.out.println("TRACER # qGroup prefix: " + qGroup.getPrefix() + " seq: " + qGroup.getSequence());
        }
        */
    }
}
