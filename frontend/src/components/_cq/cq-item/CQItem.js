import React from 'react';
import './CqItem.scss';

// level = Appui, Execution, Direction
// type = ?

const CqItem = ({
  level,
  capacite,
  itemName,
  timeline,
  delivranceDate,
  expirationDate,
  status,
}) => {
  const topTitle = () => {
    if (!level || level === undefined || level === '') {
      return capacite;
    } else {
      return level + ' • ' + capacite;
    }
  };

  const timelineElement = () => {
    if (timeline) {
      return (
        <div class="cq-item__timeline">
          <div class="start-date">{delivranceDate}</div>
          <div class="timeline-graphic">
            <div class="line"></div>
            <div class="cursor"></div>
          </div>
          <div class="end-date">{expirationDate}</div>
        </div>
      );
    } else {
      return '';
    }
  };
  return (
    <div class="cq-item cq-title cq-item--default">
      <div class="cq-item__header">
        <div class="cq-item__name-container">
          <div class="cq-item__main-attributes">{topTitle()}</div>
          <div class="cq-item__name">{itemName}</div>
        </div>
        <div class="cq-item__right-header">
          {timelineElement()}

          <div class="cq-item__status cq-item__status--valid">{status}</div>

          <div class="cq-item__document-links">
            <div class="cq-item__document-item">
              <span class="rf-fi-file-line rf-fi--lg"></span>
            </div>
          </div>

          <div class="cq-item__extend">
            <span class="rf-fi-arrow-down-s-line rf-fi--lg"></span>
          </div>
        </div>
      </div>

      <div class="cq-item__content">{/* TODO */}</div>
    </div>
  );
};

export default CqItem;
