package com.yugioh.YugiohDeckBuilder.Repository;

import com.yugioh.YugiohDeckBuilder.Pojos.Card;
import com.yugioh.YugiohDeckBuilder.Pojos.Deck;
import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DeckRepository {
    private static List<Deck> decks = new ArrayList<>();

    private String baseUrl = "https://db.ygoprodeck.com/api/v7/cardinfo.php?name=";

    public String addDeck(Deck deck) {
        decks.add(deck);
        return "CREATED: " + deck.getId();
    }

    public String updateDeck(int id, String name, List<Card> cards) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getId() == id) {
                Deck deck = decks.get(i);
                deck.setName(name);
                deck.setCards(cards);
            }
        }
        return "UPDATED";
    }

    public Card getCardInfo(String cardName) throws Exception {

        String url = baseUrl + URLEncoder.encode("%" + cardName + "%", StandardCharsets.UTF_8);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        Card card = new Card();
        JSONObject repositoryResponse = new JSONObject(response.body());
        JSONObject data = (JSONObject) repositoryResponse.getJSONArray("data").get(0);
        card.setAtk(data.getInt("atk"));
        card.setDef(data.getInt("def"));
        card.setLevel(data.getInt("level"));
        card.setName(data.getString("name"));
        return card;
    }

    public Deck getDeckById(int id) {

        Deck deck = new Deck();
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getId() == id) {
                deck = decks.get(i);
            }
        }
        return deck;
    }

    public String removeDeckFromCache(int id) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getId() == id) {
                decks.remove(i);
            }
        }
        return "REMOVED";
    }
}
