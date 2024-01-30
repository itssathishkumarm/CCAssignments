package com.cards.util;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class Utils {

    public static void checkBlackjack(Response response, String player) {
        JSONArray cards = new JSONObject(response.asString()).getJSONArray("cards");
        int value = 0;
        boolean ace = false;
      int Cardsdraw = cards.length();
        for (int i = 0; i < cards.length(); i++) {
            JSONObject card = cards.getJSONObject(i);
            String cardValue = card.getString("value");

            switch (cardValue) {
                case "ACE":
                    ace = true;
                    value += 11;

                    break;
                case "KING":
                case "QUEEN":
                case "JACK":
                    value += 10;

                    break;
                default:
                    value += Integer.parseInt(cardValue);

            }

        }
        if (value == 21) {
            System.out.println("In the draw of "+Cardsdraw+" cards, "+player + " has blackjack!");
        }

    }

    public static void checkBlackjackwith2Cards(Response response, String player)
    {
        JSONArray cards = new JSONObject(response.asString()).getJSONArray("cards");
        int value = 0;
        boolean ace = false;
        int Cardsdraw = cards.length();
        for (int i = 0; i <cards.length()-1; i++)
        {
            JSONObject card = cards.getJSONObject(i);
            String cardValue = card.getString("value");

            switch (cardValue)
            {
                case "ACE":
                    ace = true;
                    value += 11;

                    break;
                case "KING":
                case "QUEEN":
                case "JACK":
                    value += 10;

                    break;
                default:
                    value += Integer.parseInt(cardValue);

            }

        }
        if (value == 21) {
            System.out.println("In the draw of "+Cardsdraw+" cards, "+player + " has blackjack!");
        }

    }



    }
