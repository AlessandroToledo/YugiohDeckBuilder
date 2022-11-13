package com.yugioh.YugiohDeckBuilder.Service;

import com.yugioh.YugiohDeckBuilder.Pojos.Card;
import com.yugioh.YugiohDeckBuilder.Pojos.Deck;
import com.yugioh.YugiohDeckBuilder.Repository.DeckRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckService extends DeckRepository {
    public String createDeck(String name, List<Card> cards) {
        Random random = new Random();
        int id = random.nextInt(Integer.MAX_VALUE);
        while (getDeckById(id).getId() != 0) {
            id = random.nextInt(Integer.MAX_VALUE);
        }
        Deck deck = new Deck(id, name, cards);
        return addDeck(deck);

    }

    public String updateDeck(String name, List<Card> cards, int id) {
        return updateDeck(id, name, cards);
    }

    public Deck getDeckCards(int id) throws Exception {
        Deck deck = getDeckById(id);
        if (deck.getId() == 0)
            return null;
        List<Card> deckCards = deck.getCards();
        List<Card> cardResponse = new ArrayList<>();

        for (Card card : deckCards) {
            cardResponse.add(getCardInfo(card.getName()));
        }
        deck.setCards(cardResponse);
        return deck;
    }

    public String getNameDeck(int id) {
        Deck deck = getDeckById(id);
        return deck.getName();
    }

    public String removeDeck(int id) {
        return removeDeckFromCache(id);
    }
}
