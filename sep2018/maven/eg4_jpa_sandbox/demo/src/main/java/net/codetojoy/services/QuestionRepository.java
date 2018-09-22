package net.codetojoy.services;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codetojoy.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
