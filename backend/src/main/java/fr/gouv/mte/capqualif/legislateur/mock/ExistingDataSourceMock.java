package fr.gouv.mte.capqualif.legislateur.mock;

import fr.gouv.mte.capqualif.titre.domain.ConditionTitre;
import fr.gouv.mte.capqualif.titre.domain.enums.DataType;
import fr.gouv.mte.capqualif.titre.domain.enums.ExistingDataSourceName;
import fr.gouv.mte.capqualif.titre.domain.enums.ReferenceDate;
import fr.gouv.mte.capqualif.titre.domain.enums.ReferenceString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

@Component
public class ExistingDataSourceMock implements ExistingDataSource {

    public CorrespondingDataInExistingDataSource findByConditionValue(ConditionTitre conditionTitre) {
        switch (conditionTitre.getMainValueToCheck().getValueExpressedInLegalTerms()) {
            case "Âge supérieur ou égal à 16 ans":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.ADMINISTRES,
                        "https://run.mocky.io/v3/23493c22-70dd-4b8b-9e54-19aa5108c66b",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                    conditionTitre.getJuridicalDesignation(),
                                    "dateNaissance", DataType.DATE,
                                    conditionTitre.getMainValueToCheck().getHowToCompare(),
                                    new ReferenceDate(LocalDate.now())
                                ),
                                null,
                                DataType.DATE),
                        null
                );
            case "Aptitude toutes fonctions, toutes navigations":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.ESCULAPE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelle",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ReferenceString("Apte TF/TN"),
                                        true,
                                        Collections.singletonList(new ParentKey(Position.POSITION_1, "decisionMedicale"))
                                ),
                                new ValueInExistingDataSource("Apte TF/TN"), DataType.STRING
                        ),
                        Arrays.asList(
                                new KeyInExistingDataSource(
                                        // TO DO : I don't like the juridicalName being hard coded. Replace.
                                        "Date de fin de validité",
                                        "dateFinDeValidite",
                                        DataType.DATE,
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getHowToCompare(),
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getReferenceData()
                                        )
                        )
                );
            case "Module P1-Appui":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                    conditionTitre.getJuridicalDesignation(),
                                    "libelleModuleUv",
                                    DataType.STRING,
                                    conditionTitre.getMainValueToCheck().getHowToCompare(),
                                    new ReferenceString("P1–Appui-Navigation")
                                ),
                                new ValueInExistingDataSource("P1–Appui-Navigation"), DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE,
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getHowToCompare(),
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getReferenceData()
                                )
                        )
                );
            case "Module P2-Appui":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ReferenceString("P2–Appui-Manutention/arrimage cargaison/pêche")
                                ),
                                new ValueInExistingDataSource("P2–Appui-Manutention/arrimage cargaison/pêche"),
                                DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE,
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getHowToCompare(),
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getReferenceData()
                                )
                        )
                );
            case "Module P3-Appui":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ReferenceString("P3–Appui-Exploitation/assist/entretien/répar")
                                ),
                                new ValueInExistingDataSource("P3–Appui-Exploitation/assist/entretien/répar"),
                                DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE,
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getHowToCompare(),
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getReferenceData())
                        )
                );
            case "Module NP-Appui":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.AMFORE,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelleModuleUv",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ReferenceString("NP–Appui-Module Nation Pont")
                                ),
                                new ValueInExistingDataSource("NP–Appui-Module Nation Pont"),
                                DataType.STRING
                        ),
                        Collections.singletonList(
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateFinValidite",
                                        DataType.DATE,
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getHowToCompare(),
                                Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                        .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                        .findFirst().orElse(null)).getReferenceData())
                        )
                );
            case "Certificat de formation de base à la sécurité (CFBS)":
                return new CorrespondingDataInExistingDataSource(
                        ExistingDataSourceName.ITEM,
                        "***REMOVED***",
                        new EntryInExistingDataSource(
                                new KeyInExistingDataSource(
                                        conditionTitre.getJuridicalDesignation(),
                                        "libelle",
                                        DataType.STRING,
                                        conditionTitre.getMainValueToCheck().getHowToCompare(),
                                        new ReferenceString("Certificat de formation de base à la sécurité (STCW10)"),
                                        true,
                                        Collections.singletonList(
                                                new ParentKey(Position.POSITION_1, "codeBrevetMarin")
                                        )
                                ),
                                new ValueInExistingDataSource(
                                        "Certificat de formation de base à la sécurité (STCW10)"
                                ), DataType.STRING
                        ),
                        Arrays.asList(
                                new KeyInExistingDataSource(
                                        "Statut",
                                        "libelle",
                                        DataType.STRING,
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Statut".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getHowToCompare(),
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Statut".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getReferenceData(),
                                        true,
                                        Collections.singletonList(new ParentKey(Position.POSITION_1, "codeEtatTitre"))
                                ),
                                new KeyInExistingDataSource(
                                        "Date de fin de validité",
                                        "dateExpiration",
                                        DataType.DATE,
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getHowToCompare(),
                                        Objects.requireNonNull(conditionTitre.getAdditionalValuesToCheck().stream()
                                                .filter(additionalValue -> "Date de fin de validité".equals(additionalValue.getValueExpressedInLegalTerms()))
                                                .findFirst().orElse(null)).getReferenceData()
                                )
                        )
                );
            default:
                return null;
        }
    }

//    private List<KeyInExistingDataSource> buildAdditionalKeysList(List<Value> additionalValuesToCheck) {
//        List<KeyInExistingDataSource> additionalKeys = new ArrayList<KeyInExistingDataSource>();
//        for (Value additionalValue : additionalValuesToCheck) {
//            return new KeyInExistingDataSource(
//                    additionalValue.getValueExpressedInLegalTerms(),
//                    additionalValue.
//            )
//        }
//        return additionalKeys;
//    }

}
