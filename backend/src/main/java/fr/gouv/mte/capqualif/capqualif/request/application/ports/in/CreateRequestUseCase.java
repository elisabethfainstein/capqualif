package fr.gouv.mte.capqualif.capqualif.request.application.ports.in;

import fr.gouv.mte.capqualif.capqualif.request.domain.marin.request.Request;

public interface CreateRequestUseCase {
    Request createRequest(Request request);
}
