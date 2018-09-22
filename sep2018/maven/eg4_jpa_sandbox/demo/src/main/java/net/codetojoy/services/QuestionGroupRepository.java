package net.codetojoy.services;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codetojoy.models.QuestionGroup;

public interface QuestionGroupRepository extends JpaRepository<QuestionGroup, Long> {
}
