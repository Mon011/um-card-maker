package com.monodev.ummaker.tag;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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
