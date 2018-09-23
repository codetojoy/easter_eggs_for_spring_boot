package net.codetojoy.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codetojoy.models.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    Score findByQuestionIdAndValueId(Long questionId, Long valueId);
    // TODO: fix this !
    // @Query("SELECT s FROM Score s JOIN s.question q WHERE q.id = ?1 JOIN q.value v WHERE v.id = ?2")
    // Score findByQuestionIdAndValueId(Long questionId, Long valueId);
}
