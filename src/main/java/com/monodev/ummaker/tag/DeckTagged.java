package com.monodev.ummaker.tag;

import com.monodev.ummaker.deck.Deck;
import jakarta.persistence.*;

@Entity(name = "deck_tagged")
@Table(schema = "deck_tagged")
public class DeckTagged {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    Deck deck;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    Tag tag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
