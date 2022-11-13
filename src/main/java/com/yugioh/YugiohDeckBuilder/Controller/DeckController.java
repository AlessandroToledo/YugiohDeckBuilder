package com.yugioh.YugiohDeckBuilder.Controller;

import com.yugioh.YugiohDeckBuilder.Pojos.Card;
import com.yugioh.YugiohDeckBuilder.Pojos.Deck;
import com.yugioh.YugiohDeckBuilder.Service.DeckService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/deck")
public class DeckController extends DeckService {
    @PostMapping(value = "/create")
    public ResponseEntity<?> createDeck(@RequestBody String body) throws Exception {
        try {
            JSONObject payload = new JSONObject(body);
            String deckName = payload.getString("name");
            List<Card> cards = new ArrayList<>();
            JSONArray cardsArray = payload.getJSONArray("cards");
            for (int i = 0; i < cardsArray.length(); i++) {
                Card card = new Card();
                card.setName(cardsArray.getJSONObject(i).getString("name"));
                cards.add(card);
            }
            String response = createDeck(deckName, cards);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro: " + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateDeck(@RequestBody String body, @PathVariable int id) throws Exception {
        try {
            JSONObject payload = new JSONObject(body);
            String deckName = payload.getString("name");
            List<Card> cards = new ArrayList<>();
            JSONArray cardsArray = payload.getJSONArray("cards");
            for (int i = 0; i < cardsArray.length(); i++) {
                Card card = new Card();
                card.setName(cardsArray.getJSONObject(i).getString("name"));
                cards.add(card);
            }
            String response = updateDeck(deckName, cards, id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro: " + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getDeckInfo(@PathVariable int id) throws Exception {
        try {
            Deck deck = getDeckCards(id);
            if (deck != null) {
                return new ResponseEntity<>(getDeckCards(id), HttpStatus.OK);
            }
            return new ResponseEntity<>("Deck not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro: " + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<?> deleteDeck(@PathVariable int id) throws Exception {
        try {
            return new ResponseEntity<>(removeDeck(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro: " + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


