import React, { useState } from 'react';
import { unwrapResult } from '@reduxjs/toolkit';
import { useDispatch } from 'react-redux';
import { useHistory } from 'react-router-dom';
// import PropTypes from 'prop-types';
import { DASHBOARD_PATH } from '../../../app/pathes';

import HeaderBrand from '../../_rf/header-brand/HeaderBrand';

import { getSailorBasicData } from '../../../redux/features/sailorData/sailorsSlice';

import './Sign.scss';

const Sign = () => {
  const [localSailorNumber, setLocalSailorNumber] = useState('');
  const dispatch = useDispatch();
  const history = useHistory();

  const handleSubmit = (event) => {
    event.preventDefault();
    dispatch(getSailorBasicData(localSailorNumber))
      .then(unwrapResult)
      .then(() => {
        history.push(DASHBOARD_PATH);
      })
      .catch(() => {
        history.push('/error');
      });
  };

  const handleChange = (event) => {
    setLocalSailorNumber(event.target.value);
  };

  return (
    <div id="sign-in" className="page rf-container">
      <div class="sign-in__container">
        <div class="sign-in__header">
          <div class="logo_gouvfr">
            <HeaderBrand
              administrationLabel1={'Ministère'}
              administrationLabel2={'de la mer'}
            />
          </div>
        </div>
        <div class="sign-in__title">CapQualif</div>
        <div class="sign-in__welcome">
          <div class="welcome">
            Bienvenue sur CapQualif, notre nouvel espace pour faire vos demandes
            de titres.
          </div>
        </div>
        <div class="sign-in__form">
          <form onSubmit={(event) => handleSubmit(event)}>
            <label class="rf-label" for="text-input-text">
              Numéro d'identification
            </label>
            <input
              class="rf-input"
              type="text"
              name="sailor-id"
              placeholder="Exemple : 19780030"
              onChange={(event) => handleChange(event)}
            />

            <button type="submit" class="rf-btn" title="Se connecter">
              Se connecter
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Sign;
