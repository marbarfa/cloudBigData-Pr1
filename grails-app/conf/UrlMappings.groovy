class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/" {
            controller = "searchMercadoLibre"
            action = "index"
        }
        "/api" {
            controller = "compDistAPI"
            action = "index"
        }

        "/api/query"(controller: 'compDistAPI') {
            action = [GET: "getMasPosts"]
        }

        "500"(view: '/error')
    }
}
