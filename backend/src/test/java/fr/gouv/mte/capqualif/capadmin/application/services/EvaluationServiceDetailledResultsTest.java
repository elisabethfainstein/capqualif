package fr.gouv.mte.capqualif.capadmin.application.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.gouv.mte.capqualif.capadmin.application.services.temp.EvaluationService;
import fr.gouv.mte.capqualif.capadmin.domain.*;
import fr.gouv.mte.capqualif.capadmin.domain.temp.Marin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluationServiceDetailledResultsTest {

    EvaluationService evaluationService;
    JsonPopulator jsonPopulator;

    @BeforeEach
    void init() {
        evaluationService = new EvaluationService(new JsonPopulator());
    }

    //===============================================================================================================================//
    //========================= Tests on conditions populated with marin values ====================================================//


    @Test
    void shouldReturnAllConditionsOKButAge() throws IOException {

        // Given
        Marin marin = new Marin(Arrays.asList(
                new Data<String>("age", "12"),
                new Data<String>("aptitude", "apte"),
                new Data<List<String>>("formations", Arrays.asList(
                        "Module P1-Appui navigation", "Module P2-Appui manutention et arrimage de la cargaison, pêche")),
                new Data<List<String>>("titres", Collections.singletonList("CFBS"))
            )
        );

        // When
        List<ConditionResult> actual = evaluationService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json"), marin).getDetails();

        // Then
        List<ConditionResult> expected = Arrays.asList(
                new ConditionResult("age", "age", "12", false),
                new ConditionResult("aptitude médicale", "aptitude","apte", true),
                new ConditionResult("module de formation modulaire P1", "formations modulaires","[Module P1-Appui navigation, Module P2-Appui manutention et arrimage de la cargaison, pêche]", true),
                new ConditionResult("module de formation modulaire P2", "formations modulaires","[Module P1-Appui navigation, Module P2-Appui manutention et arrimage de la cargaison, pêche]", true),
                new ConditionResult("titre mainstream", "compétences en sécurité mainstream","[CFBS]", true)

        );

        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnCompetenceEnSecuriteError_dynamicallyPopulated() throws IOException {

        // Given
        Marin marin = new Marin(Arrays.asList(
                new Data<String>("age", "26"),
                new Data<String>("aptitude", "apte"),
                new Data<List<String>>("formations", Arrays.asList(
                        "Module P1-Appui navigation", "Module P2-Appui manutention et arrimage de la cargaison, pêche")),
                new Data<List<String>>("titres", Collections.emptyList())
            )
        );

        // When
        List<ConditionResult> actual = evaluationService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json"), marin).getDetails();

//        // Then
//        List<ConditionResult> expected = Arrays.asList(
//                new ConditionResult("titre mainstream", new Group("compétences en sécurité", Operator.OR)),
//                new ConditionResult("document reconnu équivalent au CFBS 2014", new Group("compétences en sécurité", Operator.OR)),
//                new ConditionResult("document reconnu équivalent au CFBS 2015", new Group("compétences en sécurité", Operator.OR))
//        );
//
//        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnAllFormationsError_dynamicallyPopulated() throws IOException {

        // Given
        Marin marin = new Marin(Arrays.asList(
                new Data<String>("age", "26"),
                new Data<String>("aptitude", "apte"),
                new Data<List<String>>("formations", Collections.emptyList()),
                new Data<List<String>>("titres", Arrays.asList("CFBS"))
        )
        );

        // When
        List<ConditionResult> actual = evaluationService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json"), marin).getDetails();


//        // Then
//        List<ConditionResult> expected = Arrays.asList(
//                new ConditionResult("module de formation modulaire P1", new Group("formations modulaires", Operator.AND)),
//                new ConditionResult("module de formation modulaire P2", new Group("formations modulaires", Operator.AND)),
//                new ConditionResult("titre reconnu équivalent à la formation modulaire 2006", new Group("titres reconnus équivalents à la formation modulaire", Operator.OR)),
//                new ConditionResult("titre reconnu équivalent à la formation modulaire 2005", new Group("titres reconnus équivalents à la formation modulaire", Operator.OR))
//        );
//
//        assertEquals(expected, actual);
    }

//    @Test
//    void shouldReturnErrorsForCompetenceSecuButNotForFormation_dynamicallyPopulated() throws IOException {
//
//        // Given
//        Marin marin = new Marin(Arrays.asList(
//                new Data<String>("age", "27"),
//                new Data<String>("aptitude", "inapte"),
//                new Data<List<String>>("formations", Arrays.asList(
//                        "Module P1-Appui navigation", "")),
//                new Data<List<String>>("titres", Collections.emptyList())
//        )
//        );
//
//        // When
//        List<ConditionResult> actual = evaluationService.processTitre(jsonToTitre("src/test/resources/mocks/capAdmin/conditions/toPopulate.json"), marin).getErrors();
//
//
//        // Then
//        List<ConditionResult> expected = Arrays.asList(
//                new ConditionResult("titre mainstream", new Group("compétences en sécurité", Operator.OR),
//                new ConditionResult("document reconnu équivalent au CFBS 2014", "compétences en sécurité"),
//                new ConditionResult("document reconnu équivalent au CFBS 2015", "compétences en sécurité")
//        );
//
//        assertEquals(expected, actual);
//    }

    private Titre jsonToTitre(String location) throws IOException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Titre titre = objectMapper.readValue(new File(location), Titre.class);
        System.out.println(titre);
        return titre;
    }


}