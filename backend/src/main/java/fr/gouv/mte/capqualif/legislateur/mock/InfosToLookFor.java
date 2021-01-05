package fr.gouv.mte.capqualif.legislateur.mock;

import org.springframework.stereotype.Component;

import java.util.*;

// NOTE : in the future, this infos will be built in the DAM module

@Component
public class InfosToLookFor {

    public DataInExistingJsonAPI whatExistingDataInfosToLookFor(String existingDataSource) {
        switch (existingDataSource) {
            case ("administres"):

                DataInExistingJsonAPI administresExistingDataInfos = new DataInExistingJsonAPI(
                        "administres",
                        "https://run.mocky.io/v3/0d730170-47d4-469a-8667-aaf0e60748aa",
                        new Key("mainKey", "dateNaissance"));
                return administresExistingDataInfos;

//              "***REMOVED******REMOVED***",

            case ("esculape"):
                Key esculapeAdditionalWantedKey1 = new Key("expirationKey", "dateFinDeValidite");
                List<Key> esculapeAdditionalWantedKeys = new ArrayList<>();
                esculapeAdditionalWantedKeys.add(esculapeAdditionalWantedKey1);
                DataInExistingJsonAPI esculapeExistingDataInfos = new DataInExistingJsonAPI(
                        "esculape",
                        "***REMOVED***",
                        new Key("mainKey", "libelle", true, Arrays.asList(new ParentKey(Position.POSITION_1, "decisionMedicale"))),
                        esculapeAdditionalWantedKeys);
                return esculapeExistingDataInfos;

//              "http://ws-esculape-capqualif-test.dsi.damgm.i2/esculape/api/v1/aptitudes/",

            case ("amfore"):
                Key amforeAdditionalWantedKey1 = new Key("expirationKey", "dateFinValidite");
                List<Key> amforeAdditionalWantedKeys = new ArrayList<>();
                amforeAdditionalWantedKeys.add(amforeAdditionalWantedKey1);
                DataInExistingJsonAPI amforeExistingDataInfos = new DataInExistingJsonAPI(
                        "amfore",
                        "***REMOVED***",
                        new Key("mainKey", "libelleModuleUv"),
                        amforeAdditionalWantedKeys);
                return amforeExistingDataInfos;

//              "http://ws-amfore-capqualif-test.dsi.damgm.i2/amfore/api/v1/acquisitions/",

            case ("item"):

                // ================= Additional wanted keys =================

                Key itemAdditionalWantedKey1 = new Key("expirationKey", "dateExpiration");

                Key itemAdditionalWantedKey2 = new Key("validityKey", "libelle", true,
                        Arrays.asList(new ParentKey(Position.POSITION_1, "codeEtatTitre")));

                // For testing purpose

//                Key itemAdditionalWantedKey3 = new Key("testKey", "ceQueJeVeuxKey", true,
//                        Arrays.asList(
//                                new ParentKey(Position.POSITION_1, "codeEtatTitre"),
//                                new ParentKey(Position.POSITION_2, "codeExport"),
//                                new ParentKey(Position.POSITION_3, "niveau1"),
//                                new ParentKey(Position.POSITION_4, "niveau2")));

                List<Key> itemAdditionalWantedKeys = new ArrayList<>();
                itemAdditionalWantedKeys.add(itemAdditionalWantedKey1);
                itemAdditionalWantedKeys.add(itemAdditionalWantedKey2);
//                itemAdditionalWantedKeys.add(itemAdditionalWantedKey3);

                // ============================================================


//              "***REMOVED***",


                DataInExistingJsonAPI itemExistingDataInfos = new DataInExistingJsonAPI(
                        "item",
                        "***REMOVED***",
                        new Key("mainKey", "libelle", true, Arrays.asList(new ParentKey(Position.POSITION_1, "codeBrevetMarin"))),
                        itemAdditionalWantedKeys);


//              "***REMOVED***",

                return itemExistingDataInfos;
            default:
                System.out.println("No matching existing source found!");
                return null;
        }
    }
}