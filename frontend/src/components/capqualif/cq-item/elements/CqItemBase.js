import React, { Fragment, useState } from 'react';
import { PropTypes } from 'prop-types';

import styles from './CqItemBase.module.scss';

import CqItemHeader from './cq-item-header/CqItemHeader';
import CqItemStatus from './cq-item-status/CqItemStatus';

const CqItemBase = ({ subtitle, name, status, date, details }) => {
  const [isDetailVisible, setIsDetailVisible] = useState(false);

  return (
    <div className={`${styles['cq-item']} fr-mb-2w fr-py-3w`}>
      <div className="fr-container fr-grid-row fr-grid-row--middle">
        <div className="fr-col fr-pr-4w">
          <CqItemHeader subtitle={subtitle} name={name} />
        </div>
        <div className={`fr-col-3 fr-mr-1w`}>{status}</div>
        {date && <div className="fr-col">{date}</div>}
        {details && (
          <div className={`${styles['expand-container']} fr-col-1 fr-px-2w`}>
            <span
              class={`${styles['expand-container']} fr-ml-1w fr-fi-arrow-up-s-line cq-helpers__clickable`}
              onClick={() => setIsDetailVisible(!isDetailVisible)}
            ></span>
          </div>
        )}
      </div>
      {details && (
        <Fragment>
          {React.cloneElement(details, { isVisible: isDetailVisible })}
        </Fragment>
      )}
    </div>
  );
};

CqItemBase.propTypes = {
  subtitle: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  status: PropTypes.element.isRequired,
  date: PropTypes.element.isRequired,
  action: PropTypes.element.isRequired,
  details: PropTypes.object.isRequired,
};

export default CqItemBase;
