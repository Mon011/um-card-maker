package com.monodev.ummaker.tag;

import com.monodev.ummaker.deck.Deck;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tags")
public class Tag {

    @Id
    @SequenceGenerator(name = "tag_id_seq", sequenceName = "tag_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tag_id_seq")
    Long id;

    @NaturalId
    String name;

    @ManyToMany(mappedBy = "tags")
    Set<Deck> decks = new HashSet<>();
}
