import { useState } from 'react';
import style from './Gosu_review.module.css'; // CSS 파일을 가져옵니다.
import avatar from "../image/avatar.png"
import logo1 from "../image/logo_design.jpg"
import logo2 from "../image/logo_design2.jpg"

const GosuReview = () => {
  const [isOpen, setIsOpen] = useState(false); // 모달 상태 관리

  const openModal = () => setIsOpen(true);
  const closeModal = () => setIsOpen(false);

  return (
    <div>
      <button onClick={openModal} className={style.open_modal_button}>리뷰 작성</button>

      {isOpen && (
        <div className={style.modal}>
          <div className={style.modal_content}>
            <button className={style.modal_close} onClick={closeModal}>X</button>
            <div className={style.modal_body}>
              <div className={style.gosu_header}>
                <img src={avatar} className={style.profile_placeholder}/>
                <div className={style.gosu_title}>
                  <div className={style.gosu_subtitle}>
                    <span className={style.font_bold}>박재찬 </span>
                    <span className={style.font_medium}>님에게 리뷰를 남겨주세요</span>
                  </div>
                  <div className={style.role}>로고 디자이너・디자이너</div>
                </div>                
              </div>
              <div className={style.review_prompt}>
                <span className={style.font_bold}>조은준 </span>
                <span className={style.font_medium}>님, 리뷰를 작성해주세요.</span>
              </div>
              <div className={style.gosu_recommand}>5.0</div>
              <textarea className={style.input_content} placeholder="내용을 입력 해주세요." />
              <div className={style.attachment_contaier}>
                <div className={style.gosu_img_title}></div>
                <div className={style.attachment}>
                  <span className={style.attachment_label}>파일 첨부</span>
                </div>
              </div>
              <div className={style.file_preview_section}>
                <div className={style.file_preview_container}>
                  <div className={style.img_container}>
                    <img src={logo1} className={style.file_preview}/>
                    <span>logo.jpg</span>
                  </div>
                  <div className={style.img_container}>
                    <img src={logo2} className={style.file_preview}/>
                    <span>logo2.jpg</span>
                  </div>
                </div>
              </div>
              <div className={style.gosu_recommand_button_container}>
                <button className={style.gosu_recommand_button}># 사장님이 친절해요</button>
                <button className={style.gosu_recommand_button}># 시간을 잘 맞춰줘요</button>
                <button className={style.gosu_recommand_button}># 잘 가르쳐주세요</button>
                <button className={style.gosu_recommand_button}># 가격이 싸요</button>
                <button className={style.gosu_recommand_button}># 만족할때까지 해줘요</button>
                <button className={style.gosu_recommand_button}># 강사님이 친절해요</button>
              </div>
              <div className={style.button_container}>
                <button className={style.submit_button}>작성</button>
                <button className={style.cancel_button} onClick={closeModal}>취소</button>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default GosuReview;

