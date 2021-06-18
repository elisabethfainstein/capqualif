import React from 'react';
import { Fragment } from 'react';
import { useHistory, useParams } from 'react-router';
import { useDispatch, useSelector } from 'react-redux';
import PropTypes from 'prop-types';

import commonStyles from '../common.module.scss';

import Step from '../../../../../capqualif/step/Step';
import { addDocument } from '../../../../../../redux/capqualif/mobile/requests/requestsSlice';
import {
  BUTTON_LABELS,
  STEPS,
} from '../../../../../../dictionnary/demandeDeTitre';
import {
  MOBILE,
  NEW_TITRE_REQUEST_ROUTE,
  ADD_DOCUMENT_ROUTE,
  ADD_PICTURE_ROUTE,
} from '../../../../../../app/routesDictionnary';
import ButtonLink from '../../../../../capqualif/buttons/ButtonLink';
import { BUTTON_WIDTH } from '../../../../../../dictionnary/saas/variables';
import ButtonAction from '../../../../../capqualif/buttons/button-action/ButtonAction';

const ConfirmPicture = (props) => {
  const { documentName } = useParams();
  const dispatch = useDispatch();
  const history = useHistory();
  const currentCondition = useSelector((state) => state.currentCondition);

  const confirm = () => {
    const renamedCondition = {
      conditionId: currentCondition.id,
      conditionName: currentCondition.name,
      conditionDocuments: currentCondition.documents,
    };
    dispatch(addDocument(renamedCondition));
    history.push(`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}`);
  };

  return (
    <Fragment>
      <Step label={STEPS.CONFIRM_PICTURE} />
      <div className={`${commonStyles['container']}`}>
        <h3 className="fr-m-2w">{documentName}</h3>
        <div
          className={`${commonStyles['capture-container']} fr-py-4w fr-px-2w`}
        >
          <img src={currentCondition.document} alt="document ajouté" />
          <ButtonLink
            label={BUTTON_LABELS.RETAKE_PICTURE}
            width={BUTTON_WIDTH.FULL}
            isSecondary={true}
            marginInRem={1}
            route={`/${MOBILE}/${NEW_TITRE_REQUEST_ROUTE}/${ADD_DOCUMENT_ROUTE}/${ADD_PICTURE_ROUTE}`}
          />
          <ButtonAction
            label={BUTTON_LABELS.CONFIRM_PICTURE}
            width={BUTTON_WIDTH.FULL}
            actionOnClick={confirm}
          />
        </div>
      </div>
    </Fragment>
  );
};

ConfirmPicture.propTypes = {};

export default ConfirmPicture;
