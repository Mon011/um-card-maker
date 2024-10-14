package com.monodev.ummaker.tag;

import com.monodev.ummaker.deck.Deck;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "deck_tagged")
@Table(schema = "deck_tagged")
public class DeckTagged {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    private List<Deck> deck;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private List<Tag> tag;

}
