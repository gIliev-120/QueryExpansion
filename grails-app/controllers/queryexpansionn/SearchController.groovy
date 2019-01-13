package queryexpansionn

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

import models.DatamuseWord
import org.json.JSONArray
import org.json.JSONObject
import utils.SpellCheck

class SearchController {

    def index() {
        render(view:'search');
    }

    def search(){
        JSONObject result = SpellCheck.checkWord(params.squery);
        println result.toString();
        String suggestion =  result.get("suggestion");


        println suggestion;
        println result.get("corrections") == null
        boolean hasErrors = result.get("corrections").length()==0 ? false : true

        ObjectMapper mapper = new ObjectMapper();
        JSONArray relatedWordsResult = SpellCheck.findSynonymsAndRelatedWords(params.squery);
        ArrayList<DatamuseWord> words = mapper.readValue(relatedWordsResult.toString(),new TypeReference<List<DatamuseWord>>(){});

        new History(user:session.user,searchedSentence:params.squery).save();
        render(view:'list' ,model:[suggestion: suggestion ,original: params.squery , hasError:hasErrors,relatedWords:words.subList(0,20)]);
    }

}
