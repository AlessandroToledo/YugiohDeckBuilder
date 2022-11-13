package com.yugioh.YugiohDeckBuilder.Pojos;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import java.util.List;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Deck {

    private int id;
    private String name;
    private List<Card> cards;

    public Deck() {
    }

    public Deck(int id, String name, List<Card> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}