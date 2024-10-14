package com.monodev.ummaker.user;

import com.monodev.ummaker.deck.Deck;
import com.monodev.ummaker.deck.DeckReaction;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

    @Column(unique = true, nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "user", cascade = CascadeType.ALL)
    private List<Deck> decks;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DeckReaction> deckReactions;
}
