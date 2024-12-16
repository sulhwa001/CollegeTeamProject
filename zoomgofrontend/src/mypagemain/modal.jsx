import React from 'react';
import './history-modal.css';  // 모달에 대한 스타일을 따로 관리

const Modal = ({ isOpen, closeModal, content }) => {
  if (!isOpen) {
    return null;  // 모달이 열리지 않으면 아무것도 렌더링하지 않음
  }

  return (
    <div className="modal-overlay">
      <div className="modal-content">
        <label className="close-btn" onClick={closeModal}>→</label>
        {/* 조건부 렌더링으로 판매 내역 또는 구매 내역을 렌더링 */}
        {content === '판매 내역' ? (
          <>
            <h1>판매 내역</h1>
            <div className='legend-joeunjun'>
              <div className='la-option'>
                <h2>총 1개</h2>
              </div>
              <div className='history-1'></div>
            </div>
            <h4>총 1개</h4>
            <h4>10,000원</h4>
          </>
        ) : content === '구매 내역' ? (
          <>
            <h1>구매 내역</h1>
            <div className='legend-joeunjun'>
              <div className='la-option'>
                <h2>총 1개</h2>
              </div>
              <div className='history-1'></div>
            </div>
            <h4>총 1개</h4>
            <h4>10,000원</h4>
            <a href="/write-review" className="review-link">
              리뷰 쓰러 가기
            </a>
          </>
        ) : null}
      </div>
    </div>
  );
};

export default Modal;
