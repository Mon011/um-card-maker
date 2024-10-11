package com.monodev.ummaker.user;

import com.monodev.ummaker.deck.Deck;
import com.monodev.ummaker.deck.DeckReaction;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "user")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user", cascade = CascadeType.ALL)
    private List<Deck> decks;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DeckReaction> deckReactions;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    public List<DeckReaction> getDeckReactions() {
        return deckReactions;
    }

    public void setDeckReactions(List<DeckReaction> deckReactions) {
        this.deckReactions = deckReactions;
    }
}
