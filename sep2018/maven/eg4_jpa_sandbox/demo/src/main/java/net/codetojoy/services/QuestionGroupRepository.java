package net.codetojoy.services;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codetojoy.models.QuestionGroup;

public interface QuestionGroupRepository extends JpaRepository<QuestionGroup, Long> {
    @Query("SELECT qGroup FROM QuestionGroup qGroup ORDER BY qGroup.sequence ASC")
    List<QuestionGroup> findAllWithOrder();
}
