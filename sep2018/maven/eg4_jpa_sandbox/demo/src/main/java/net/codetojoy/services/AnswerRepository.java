package net.codetojoy.services;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codetojoy.models.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
