import React, { useEffect, useState } from 'react';
import { PropTypes } from 'prop-types';

import './CqItemBase.scss';

import CqItemHeader from './cq-item-header/CqItemHeader';

const CqItemBase = ({ subtitle, name, infos, detailsComponent }) => {
  const [isDetailVisible, setIsDetailVisible] = useState(false);
  const [nbOfElements, setNbOfElements] = useState(2);

  useEffect(() => {
    adjustHeaderColumns();
    console.log(nbOfElements);
  }, []);

  const adjustHeaderColumns = () => {
    if (infos) setNbOfElements(3);
  };

  return (
    <div
      className="cq-item cq-title cq-item--default rf-container rf-my-2w"
      onClick={() => setIsDetailVisible(!isDetailVisible)}
      style={{ cursor: isDetailVisible ? 'default' : 'cursor' }}
    >
      <div class="cq-item__header">
        <div className="rf-grid-row rf-grid-row--gutters">
          <div className={`${nbOfElements === 3 ? 'rf-col-5' : 'rf-col-11'}`}>
            <CqItemHeader subtitle={subtitle} name={name} />
          </div>
          {infos && (
            <div className="rf-col-6 infos-container">
              {/* {React.cloneElement(children, { isDetailVisible: isDetailVisible })} */}
              {infos}
            </div>
          )}
          <div className="rf-col-1 expand-container rf-px-2w">
            <span
              class="rf-fi-arrow-down-s-line cq-helpers__clickable"
              onClick={() => setIsDetailVisible(!isDetailVisible)}
            ></span>
          </div>
        </div>

        <div className="rf-grid-row rf-grid-row--gutters">
          {detailsComponent}
        </div>
      </div>
    </div>
  );
};

CqItemBase.propTypes = {
  subtitle: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  children: PropTypes.element.isRequired,
};

export default CqItemBase;
