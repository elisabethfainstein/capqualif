import React, { useState } from 'react';
import PropTypes from 'prop-types';
import { useDispatch } from 'react-redux';

import './Editor.scss';

import Condition from './condition/Condition';
import { createConditions } from '../../../../redux/capadmin/features/conditions/conditionsSlice';

const Editor = () => {
  const dispatch = useDispatch();

  const [formData, setFormData] = useState({
    titre: '',
    conditions: [],
  });
  const [shouldSendCondition, setShouldSendCondition] = useState(false);
  const [conditionsBlocks, setConditionsBlocks] = useState([]);
  let conditionsListUICounter = 0;
  const conditionsToAdd = [];

  const handleChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    resetConditionsList();
    tellChildToSendConditions(); // this will trigger handleConditionFromChild()
    dispatch(createConditions(formData));
  };

  const addSubconditionFromChild = (condition) => {
    conditionsToAdd.push(condition);
    setFormData({ ...formData, conditions: conditionsToAdd });
    tellChildrenToStopSending();
  };

  const tellChildToSendConditions = () => {
    setShouldSendCondition(true);
  };

  const tellChildrenToStopSending = () => {
    setShouldSendCondition(false);
  };

  const resetConditionsList = () => {
    conditionsToAdd.length = 0;
  };

  // TO DO : refactor to a more elegant solution
  const displayNewConditionBlock = () => {
    setConditionsBlocks(conditionsBlocks.concat('condition'));
  };

  return (
    <div id="editor">
      <form onSubmit={handleSubmit}>
        <label>
          Intitulé du titre :
          <input
            value={formData.titre || ''}
            aria-label="name-input"
            name="titre"
            onChange={(e) => handleChange(e)}
          />
        </label>
        {conditionsBlocks.map((condition) => {
          return (
            <Condition
              tellParentToAddSubcondition={addSubconditionFromChild}
              shouldISendCondition={shouldSendCondition}
              key={conditionsListUICounter++}
            />
          );
        })}
        <button
          type="button"
          className="add"
          onClick={() => displayNewConditionBlock()}
        >
          Ajouter des conditions
        </button>
        <input type="submit" value="Génerer" data-testid="submit-input" />
      </form>
    </div>
  );
};

Editor.propTypes = {};

export default Editor;
