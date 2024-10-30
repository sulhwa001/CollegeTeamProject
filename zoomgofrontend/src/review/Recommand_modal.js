import React, { useState } from 'react';
import style from './Recommand_modal.module.css';
import keyboardImg from "../image/keyboard.jpeg"

const Recommand = () => {
  const [isOpen, setIsOpen] = useState(false); // Modal을 열고 닫는 상태

  const openModal = () => setIsOpen(true);
  const closeModal = () => setIsOpen(false);

  return (
    <div>
      <button onClick={openModal} className={style.open_modal_button}>거래 평가</button>
    
      {isOpen && (
        <div className={style.modal}> 
          <div className={style.modal_content}> 
            <button className={style.modal_close} onClick={closeModal}>X</button>
            <div className={style.modal_body}>
              <div className={style.recommand_header}></div> 
              <img src={keyboardImg} className={style.recommand}/>
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
