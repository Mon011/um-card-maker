package com.monodev.ummaker.deck;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckReactionRepository extends CrudRepository<DeckReaction, Long> {

}
