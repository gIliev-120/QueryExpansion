package queryexpansionn

import grails.converters.JSON
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

        render(view:'list' ,model:[suggestion: suggestion ,original: params.squery , hasError:hasErrors]);
    }
}
