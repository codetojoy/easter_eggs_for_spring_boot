package net.codetojoy.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codetojoy.models.Code;

public interface CodeRepository extends JpaRepository<Code, Long> {
    @Query("SELECT code FROM Code code WHERE code.name = ?1")
    Code findByName(String name);
}
