package com.monodev.ummaker.deck;

import com.monodev.ummaker.tag.DeckTagged;
import com.monodev.ummaker.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
}
