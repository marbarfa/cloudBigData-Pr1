package cloudbigdata.pr1

import grails.plugins.rest.client.RestBuilder

class SearchMercadoLibreController {

    private static String SEARCH_API = "https://api.mercadolibre.com/sites/MLU/search?limit=20&q="
    private static String ITEMS_API = "https://api.mercadolibre.com/items/"
//    def rest = new RestBuilder(proxy:['httpproxy.fing.edu.uy':3128]);
    def rest = new RestBuilder();

    def index() {
        def query = params.query
        if (query!=null){
            def resp = rest.get("${SEARCH_API}$query")
            [itemsList: resp.json.results]
        }
    }

    def getVIPPage() {
        def itemId = params.id
        def resp = rest.get("${ITEMS_API}$itemId")
        render(view:'vip', model: [item :resp.json])
    }

}
