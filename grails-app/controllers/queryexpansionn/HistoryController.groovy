package queryexpansionn

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HistoryController {

    HistoryService historyService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond historyService.list(params), model:[historyCount: historyService.count()]
    }

    def show(Long id) {
        respond historyService.get(id)
    }

}
