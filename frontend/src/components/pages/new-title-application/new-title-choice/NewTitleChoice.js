import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Link } from 'react-router-dom';

import { getAllTitles } from '../../../../redux/features/titlesCatalog/titlesSlice';

import './NewTitleChoice.scss';

import SectionHead from '../../../elements/section/section-head/SectionHead';
import TitleCard from '../../../elements/cards/title-card/TitleCard';

const NewTitleChoice = () => {
  const dispatch = useDispatch();
  const allTitles = useSelector((state) => state.titles.allTitles);

  useEffect(() => {
    // TO DO : implement dispatch(getSuggestedTitles());
    dispatch(getAllTitles());
  }, [dispatch]);

  return (
    <div id="new-title-choice">
      <SectionHead
        title="Demande d'un nouveau titre"
        subtitle="Choisissez le titre"
      />
      <div>
        <h3>Titres recommandés pour vous</h3>
        {allTitles.map((title) => (
          <Link to={`/new-title-application/details/`}>
            <TitleCard key={title.id} title={title} titleType="fromCatalog" />
          </Link>
        ))}
      </div>
      <div>
        <h3>Tous les titres</h3>
        <input type="text"></input>
        {allTitles.map((title) => (
          <Link to={`/new-title-application/details/`}>
            <TitleCard key={title.id} title={title} titleType="fromCatalog" />
          </Link>
        ))}
      </div>
    </div>
  );
};

export default NewTitleChoice;
