package fr.gouv.mte.capqualif.capqualif.request.adapters.in.web;

import fr.gouv.mte.capqualif.capqualif.request.application.ports.in.CreateRequestUseCase;
import fr.gouv.mte.capqualif.capqualif.request.domain.marin.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
@CrossOrigin(origins = "http://localhost:3000")
public class RequestsController {

    @Autowired
    private CreateRequestUseCase createRequestUseCase;

    @PostMapping
    public Request createRequest(@PathVariable("request") Request request) {
        return createRequestUseCase.createRequest(request);
    }

}
