package cloudbigdata.pr1

import grails.plugins.rest.client.RestBuilder

class VIPMercadoLibreController {


    private static String ITEMS_API = "https://api.mercadolibre.com/items/"
    def rest = new RestBuilder();

    def index() {
        def itemId = params.id
        def resp = rest.get("${ITEMS_API}$itemId")
        render( view: 'index', model: [item :resp.json])
    }

    def renderVipPage(){
        render (view: 'index')
    }

}
