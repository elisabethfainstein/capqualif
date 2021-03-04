package fr.gouv.mte.capqualif.instruction.application.services;

import fr.gouv.mte.capqualif.instruction.application.ports.out.GetMarinDataPort;
import fr.gouv.mte.capqualif.instruction.domain.ComparisonResult;
import fr.gouv.mte.capqualif.instruction.domain.ExtractionResult;
import fr.gouv.mte.capqualif.legislateur.mock.*;
import fr.gouv.mte.capqualif.marin.domain.marin.Marin;
import fr.gouv.mte.capqualif.titre.application.ports.out.GetTitrePort;
import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.Titre;
import fr.gouv.mte.capqualif.titre.domain.Value;
import fr.gouv.mte.capqualif.titre.domain.enums.ComparisonRule;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CompareMarinDataToConditionsTitreServiceTest {

    @Autowired
    ExistingDataSource existingDataSource;

    @MockBean
    private GetTitrePort getTitrePort;

    @MockBean
    private GetMarinDataPort getMarinDataPort;

    private CompareMarinDataToConditionsTitreService compareMarinDataToConditionsTitreService;

    ConditionTitre conditionTitre;
    Titre titre;
    Marin marin;
    CorrespondingDataInExistingDataSource data;


    @BeforeEach
    void setUp() {
        compareMarinDataToConditionsTitreService =
                new CompareMarinDataToConditionsTitreService(getTitrePort, getMarinDataPort, existingDataSource);

        conditionTitre = new ConditionTitre(
                "Aptitude médicale",
                new Value("Aptitude toutes fonctions, toutes navigations", ComparisonRule.STRICT_EQUALITY)
        );

        titre = new Titre(
                "1",
                "Certificat de matelot pont (CMP9525)",
                Collections.singletonList(conditionTitre),
                null
        );

        marin = new Marin(
                "0",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        data = new CorrespondingDataInExistingDataSource(
                ExistingDataSourceName.ESCULAPE,
                "***REMOVED***",
                new EntryInExistingDataSource(
                        new KeyInExistingDataSource(
                                conditionTitre.getJuridicalDesignation(),
                                "libelle",
                                DataType.STRING),
                        new ValueInExistingDataSource("Apte TF/TN"), DataType.STRING
                ),
                Arrays.asList(new KeyInExistingDataSource(
                        // TO DO : I don't like the juridicalName being hard coded. Replace.
                        "Date de fin de validité",
                        "dateFinDeValidite",
                        DataType.DATE))
        );

    }

    @Test
    void shouldReturnAPositiveComparisonResultWhenMarinDataMeetConditionTitre_stringCondition_strictEquality() {
        // Given :
        // Set up made in @BeforeEach
        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), data))
                .thenReturn(Arrays.asList(new ExtractionResult("Aptitude médicale", "Apte TF/TN", DataType.STRING)));

        // When
        List<ComparisonResult> actualResultats =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(), marin.getNumeroDeMarin());

        // Then
        List<ComparisonResult> expectedResults = Collections.singletonList(new ComparisonResult("Aptitude médicale",
                true));

        assertEquals(expectedResults, actualResultats);
    }

    @Test
    void shouldReturnAFalseComparisonResultWhenMarinDataDoNotMeetConditionTitre_stringCondition_strictEquality() {
        // Given :
        // Set up made in @BeforeEach
        Mockito.when(getTitrePort.findTitreById(titre.getId())).thenReturn(titre);
        Mockito.when(getMarinDataPort.getMarinData(marin.getNumeroDeMarin(), data))
                .thenReturn(Arrays.asList(new ExtractionResult("Aptitude médicale", "Apte TF/TN sf C/V avec restriction", DataType.STRING)));

        // When
        List<ComparisonResult> actualResultats =
                compareMarinDataToConditionsTitreService.compareMarinDataToConditionsTitre(titre.getId(), marin.getNumeroDeMarin());

        // Then
        List<ComparisonResult> expectedResults = Collections.singletonList(new ComparisonResult("Aptitude médicale",
                false));

        assertEquals(expectedResults, actualResultats);
    }
}
