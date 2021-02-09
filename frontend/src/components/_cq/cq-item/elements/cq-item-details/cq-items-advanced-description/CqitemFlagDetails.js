import React, { Fragment } from 'react';

import './CqItemFlagDetails.scss';

const CqItemFlagDetails = ({ categoryName, infos }) => {
  return (
    <Fragment>
      <div class="cq-item__attribute cq-helpers__full-width rf-mt-3w rf-mb-1w">
        {categoryName}
      </div>
      <div id="cq-item-single-detail__details-container">
        {Array.isArray(infos) ? (
          infos.map((info) => (
            <div class="cq-item__lined-element cq-item__detail rf-p-1w rf-my-1w">
              {info}
            </div>
          ))
        ) : (
          <div>{infos}</div>
        )}
      </div>
    </Fragment>
  );
};

export default CqItemFlagDetails;
