package com.monodev.ummaker.tag;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.List;


@Table(name = "tags")
@Entity(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<DeckTagged> deckTagged;
}
