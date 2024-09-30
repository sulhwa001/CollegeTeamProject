import React, { useState } from 'react';
import style from './Recommand_modal.module.css';

const Recommand = () => {
  const [isOpen, setIsOpen] = useState(false); // Modal을 열고 닫는 상태

  const openModal = () => setIsOpen(true);
  const closeModal = () => setIsOpen(false);

  return (
    <div>
      <button onClick={openModal} className={style.open_modal_button}>거래 평가</button>
    
      {isOpen && (
        <div className={style.modal}> {/*중고거래 후 유저 추천 모달 자체*/}
          <div className={style.modal_content}> {/*추천 모달안의 태그들*/}
            <button className={style.modal_close} onClick={closeModal}>X</button> {/*추천 모달 닫기 버튼*/}
            <div className={style.modal_body}>{/*추천 모달 바디*/}
              <div className={style.recommand_header}></div> {/*추천 모달 헤더*/}
              <div className={style.recommand}></div>
              <div className={style.top_note}>방금 거래 어떠셨나요?</div>
              <div className={style.title}>
                <span className={style.recommand_nickname}>조은준</span>님의 의견을 알려주세요.
              </div>
              <div className={style.product_note}>[팝니다] 기계식 키보드 / 네고불가</div>
              <div className={style.button_container}>
                <button className={style.button}>
                  <div className={style.button_bg}></div>
                  <div className={style.button_text}>좋아요</div>
                </button>
                <button className={style.button}>
                  <div className={style.button_bg}></div>
                  <div className={style.button_text}>싫어요</div>
                </button>
              </div>
              <div className={style.note}>의견은 매너 점수에 반영됩니다.</div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default Recommand;
