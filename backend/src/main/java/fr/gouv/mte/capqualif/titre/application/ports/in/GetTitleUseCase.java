package fr.gouv.mte.capqualif.titre.application.ports.in;

import fr.gouv.mte.capqualif.titre.domain.Titre;

public interface GetTitleUseCase {

    Titre getTitle(String titleId);

}
