package com.yugioh.YugiohDeckBuilder.Controller;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeckControllerTest {

    private static int id;

    @Test
    public void test1_createDeck_Success() throws Exception {
        DeckController controller = new DeckController();
        String body = "{\n" +
                "    \"name\":\"Master of rites II\",\n" +
                "    \"cards\":[\n" +
                "        {\n" +
                "            \"name\":\"Nekroz of Brionac\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"Nekroz of Trishula\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"Nekroz of Decisive Armor\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"Nekroz of Valkyrus\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        ResponseEntity<?> response = controller.createDeck(body);
        int responseStatusCode = response.getStatusCodeValue();
        id = Integer.parseInt(Objects.requireNonNull(response.getBody()).toString().substring(9));
        Assert.assertEquals(201, responseStatusCode);
    }

    @Test
    public void test2_updateDeck_Success() throws Exception {
        DeckController controller = new DeckController();
        String body = "{\n" +
                "    \"name\":\"Master of rites\",\n" +
                "    \"cards\":[\n" +
                "        {\n" +
                "            \"name\":\"Nekroz of Brionac\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"Nekroz of Trishula\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"Nekroz of Decisive Armor\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"Nekroz of Valkyrus\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"Manju of the Ten\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        ResponseEntity<?> response = controller.updateDeck(body, id);
        int responseStatusCode = response.getStatusCodeValue();
        Assert.assertEquals(200, responseStatusCode);
    }

    @Test
    public void test3_getDeckInfo_Success() throws Exception {
        DeckController controller = new DeckController();
        ResponseEntity<?> response = controller.getDeckInfo(id);
        int responseStatusCode = response.getStatusCodeValue();
        Assert.assertEquals(200, responseStatusCode);
    }

    @Test
    public void test4_deleteDeck_Success() throws Exception {
        DeckController controller = new DeckController();
        ResponseEntity<?> response = controller.deleteDeck(id);
        int responseStatusCode = response.getStatusCodeValue();
        Assert.assertEquals(200, responseStatusCode);
    }
}
