import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import { getTitle } from '../../../../redux/features/titlesCatalog/titlesSlice';

import './TitleDetails.scss';

import SectionHead from '../../../elements/section/section-head/SectionHead';
import SectionFooter from '../../../elements/section/section-footer/SectionFooter';

const TitleDetails = () => {
  const dispatch = useDispatch();
  const currentTitle = useSelector((state) => state.titles.currentTitle);

  useEffect(() => {
    dispatch(getTitle('1'));
  }, []);

  const possibleActions = [
    {
      label: 'Continuer',
      nextPageLink: '/new-title-application/recap',
    },
  ];

  return (
    <div id="title-details">
      <SectionHead
        title={currentTitle.titleName}
        subtitle="Demande d'un nouveau titre"
      />
      <div>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
        veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
        commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
        velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
        occaecat cupidatat non proident, sunt in culpa qui officia deserunt
        mollit anim id est laborum.
      </div>
      <SectionFooter possibleActions={possibleActions} />
    </div>
  );
};

export default TitleDetails;
