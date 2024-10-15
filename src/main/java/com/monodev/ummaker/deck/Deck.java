package com.monodev.ummaker.deck;

import com.monodev.ummaker.tag.Tag;
import com.monodev.ummaker.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "deck")
@Table(name = "decks")
public class Deck {

    @Id
    @SequenceGenerator(name = "deck_id_seq", sequenceName = "deck_id_seq")
    @GeneratedValue(strategy = GenerationType.UUID, generator = "deck_id_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "deck_name")
    private String name;

    @Column(name = "description")
    private String description;

    //TODO JSON Object Mapper
    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @JoinTable(name = "deck_tagged",
            joinColumns = @JoinColumn(name = "deck_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    private Set<Tag> tags;


    @JoinTable(name = "deck_tagged",
            joinColumns = @JoinColumn(name = "deck_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    private Set<Deck> deckReactions;
}
