package com.monodev.ummaker.user;

import com.monodev.ummaker.deck.Deck;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "user")
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.UUID, generator = "user_id_seq")
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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "deck_reactions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "deck_id")
    )
    private Set<Deck> deckReactions = new HashSet<>();
}
