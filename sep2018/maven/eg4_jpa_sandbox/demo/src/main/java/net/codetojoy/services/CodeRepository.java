package net.codetojoy.services;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codetojoy.models.Code;

public interface CodeRepository extends JpaRepository<Code, Long> {
}