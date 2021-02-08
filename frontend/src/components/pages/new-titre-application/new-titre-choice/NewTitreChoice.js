import React, { Fragment, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';
import { store } from '../../../../redux/store';

import { getAllTitres } from '../../../../redux/features/titresCatalog/titresSlice';

import './NewTitreChoice.scss';

import SectionHead from '../../../_cq/section/section-head/SectionHead';
// import CqItem from '../../../_cq/cq-item/CqItem';
import CqItemBase from '../../../_cq/cq-item/elements/CqItemBase';
import { OWNER } from '../../../../dictionnary/common';
import Breadcrumb from '../../../_cq/breadcrumb/Breadcrumb';
import { FONT_COLORS } from '../../../../dictionnary/saas/variables';
import CqItemAdvancedDescription from '../../../_cq/cq-item/elements/cq-item-details/cq-items-advanced-description/CqItemAdvancedDescription';
import CqItemCatalog from '../../../_cq/cq-item/catalog/CqItemCatalog';

const NewTitleChoice = () => {
  const dispatch = useDispatch();
  const allTitres = useSelector((state) => state.titresReducer.allTitres);

  const allTitresMock = [
    {
      capacite: 'Monovalence Pont',
      name: 'Certificat de matelot pont',
      id: '1',
      slug: 'certificat-de-matelot-pont',
      details: {
        advancedDescriptions: [
          {
            categoryName: 'Fonctions',
            infos: ["Fonctions d'appui au pont"],
          },
          {
            categoryName: 'Tâches spécialisées',
            infos: [
              'Navigation',
              'Manutention et arrimage de la cargaison',
              "Contrôle de l'exploitation du navire et assistance aux personnes à bord",
              'Entretien et réparation',
            ],
          },
        ],
        arrete: 'Arrêté du 18 août 2015',
        validityDuration: '5 ans',
      },
    },
    {
      capacite: '',
      name: 'Certificat de formation de base à la sécurité',
      id: '2',
      slug: 'certificat-de-formation-de-base-a-la-securite',
      details: {
        advancedDescriptions: [
          {
            categoryName: 'Enseignement',
            infos: [
              'Identifier les situation d’urgence',
              'Identifier les types d’engins de sauvetages',
              'Expliquer la fonction des éléments de l’armement des embarcations et radeaux de sauvetage.',
              'Principes de survie',
            ],
          },
        ],
        arrete: 'Arrêté du 18 août 2015',
        validityDuration: '5 ans',
      },
    },
  ];

  useEffect(() => {
    dispatch(getAllTitres());
  }, [dispatch]);

  return (
    <Fragment>
      <Breadcrumb />
      <div id="new-title-choice" className="rf-container">
        <div className="rf-grid-row">
          <SectionHead
            subtitle="Demande d'un nouveau titre"
            title="Choix du titre"
            color={FONT_COLORS.MARIANNE_BLUE}
          />
        </div>
        <div className="rf-grid-row">
          <div class="rf-search-bar" id="search-input">
            <label class="rf-label" for="search-input-input">
              Rechercher un titre
            </label>
            <input
              class="rf-input"
              placeholder="Rechercher un titre"
              type="search"
              id="search-input-input"
              name="search-input-input"
            />
            <button class="rf-btn" title="Rechercher">
              <span>Rechercher</span>
            </button>
          </div>
        </div>
        <div className="rf-grid-row rf-grid-row--gutters">
          <div class="rf-col">
            <SectionHead
              subtitle="Suggestions pour exercer des"
              title="Fonctions principales"
              color={FONT_COLORS.G800}
            />
            {allTitresMock
              .filter((titre) => titre.capacite !== '')
              .map((titre) => (
                <CqItemCatalog
                  subtitle={titre.capacite}
                  name={titre.name}
                ></CqItemCatalog>
              ))}
          </div>
          <div class="rf-col">
            <SectionHead
              subtitle="Suggestions pour exercer des"
              title="Fonctions spécifiques"
              color={FONT_COLORS.G800}
            />
            {allTitresMock
              .filter((titre) => titre.capacite === '')
              .map((titre) => (
                <CqItemCatalog
                  subtitle={titre.capacite}
                  name={titre.name}
                ></CqItemCatalog>
              ))}
          </div>
        </div>
      </div>
    </Fragment>
  );
};

export default NewTitleChoice;
