package com.monodev.ummaker.tag;

import com.monodev.ummaker.deck.Deck;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "tags")
@Entity(name = "tag")
public class Tag {

    @Id
    @SequenceGenerator(name = "tag_id_seq", sequenceName = "tag_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tag_id_seq")
    Long id;

    @Column(unique = true, nullable = false)
    @NaturalId
    String name;

    @ManyToMany(mappedBy = "tags")
    Set<Deck> tags;
}
