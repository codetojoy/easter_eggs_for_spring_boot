package net.codetojoy.services;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codetojoy.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
