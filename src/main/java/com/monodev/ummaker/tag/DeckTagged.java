package com.monodev.ummaker.tag;

import com.monodev.ummaker.deck.Deck;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "deck_tagged")
@Table(schema = "deck_tagged")
public class DeckTagged {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    private List<Deck> deck;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private List<Tag> tag;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Deck> getDeck() {
        return deck;
    }

    public void setDeck(List<Deck> deck) {
        this.deck = deck;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }
}
