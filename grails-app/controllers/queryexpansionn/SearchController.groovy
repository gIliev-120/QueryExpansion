package queryexpansionn

import org.json.JSONObject
import utils.SpellCheck

class SearchController {

    def index() {
        render(view:'search');
    }

    def search(){
        JSONObject result = SpellCheck.checkWord(params.squery);
        println result.get("suggestion");
        println result.getJSONObject()

        Iterator<String> keys = result.keys();
        while(keys.hasNext()){
            String key = keys.next();
            println(key)
            println result.get(key);
        }



    }
}
