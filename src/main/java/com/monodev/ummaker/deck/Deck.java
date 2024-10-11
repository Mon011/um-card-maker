package com.monodev.ummaker.deck;

import com.monodev.ummaker.tag.DeckTagged;
import com.monodev.ummaker.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "deck")
@Table(name = "decks")
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "deck_name")
    private String name;

    @Column(name = "deck_name")
    private String description;

    //TODO JSON Object Mapper
    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DeckTagged> deckTagged;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DeckReaction> deckReactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DeckTagged> getDeckTagged() {
        return deckTagged;
    }

    public void setDeckTagged(List<DeckTagged> deckTagged) {
        this.deckTagged = deckTagged;
    }

    public List<DeckReaction> getDeckReactions() {
        return deckReactions;
    }

    public void setDeckReactions(List<DeckReaction> deckReactions) {
        this.deckReactions = deckReactions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
