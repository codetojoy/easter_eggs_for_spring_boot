package net.codetojoy.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.codetojoy.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT item FROM Item item WHERE item.name = ?1")
    Item findByName(String name);
}
