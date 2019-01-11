package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.net.URLEncoder;
import org.apache.http.client.utils.URIUtils;
import org.json.JSONArray;
import org.json.JSONObject;



public class SpellCheck {
    private static final String URL = "https://montanaflynn-spellcheck.p.mashape.com/check/?text=";
    private static final String DATAMUSE_URL = "https://api.datamuse.com/words?ml=";

    public static JSONObject checkWord(String text) throws Exception{

        HttpResponse<JsonNode> response = Unirest.get(URL+URLEncoder.encode(text,"UTF-8"))
                .header("X-Mashape-Key", "HR8dDXUztRmshkLp0LuLTlfZCJZDp19HMBdjsniQZZhJo6bGza")
                .header("Accept", "application/json")
                .asJson();

        return response.getBody().getObject();
    }

    public static JSONArray findSynonymsAndRelatedWords(String text) throws Exception{
        HttpResponse<JsonNode> response = Unirest.get(DATAMUSE_URL+URLEncoder.encode(text,"UTF-8"))
                .header("Accept","application/json").asJson();

        return response.getBody().getArray();
    }




}
