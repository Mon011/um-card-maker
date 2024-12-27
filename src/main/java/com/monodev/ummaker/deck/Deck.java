package com.monodev.ummaker.deck;

import com.monodev.ummaker.tag.Tag;
import com.monodev.ummaker.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity(name = "deck")
@Table(name = "decks")
public class Deck {

    @Id
    @SequenceGenerator(name = "deck_id_seq", sequenceName = "deck_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "deck_id_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    private User user;

    private String name;

    private String description;

    //TODO JSON Object Mapper
    private String content;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @JoinTable(name = "decks_tagged",
            joinColumns = @JoinColumn(name = "deck_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    private Set<Tag> tags = new HashSet<>();


    @JoinTable(name = "deck_reactions",
            joinColumns = @JoinColumn(name = "deck_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    private Set<User> deckReactions = new HashSet<>();

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getDecks().add(this);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getDecks().remove(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Deck))
            return false;

        return id != null && id.equals(((Deck) obj).getId());
    }
}
