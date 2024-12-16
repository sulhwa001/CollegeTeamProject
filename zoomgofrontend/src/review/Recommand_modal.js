import React, { useEffect, useState } from 'react';
import style from './Recommand_modal.module.css';
import keyboardImg from "../image/keyboard.jpeg"
import axios from 'axios';
import { useSearchParams } from 'react-router-dom';

const Recommand = () => {
  const [isOpen, setIsOpen] = useState(false); // Modal을 열고 닫는 상태

  let [query, setQuery] = useSearchParams();

  let Id = query.get("Id");

  const [userName, setUserName] = useState("")
  const [userRecommend, setUserRecommend] = useState(null)

  const [data, setData] = userState({
    title: null,
    contents: ""
  });

  const openModal = () => setIsOpen(true);
  const closeModal = () => setIsOpen(false);

  useEffect(() => {
    const token = localStorage.getItem('zoomgo-token')
    if(!token){
      alert("로그인이 필요합니다.");
      window.location.href="/login";
      return;
    }
    axios.get("http://localhost:8080/zoomgo/mypage",{
      headers: { Authorization: `Bearer ${token}`}
    })
    .then(res => {
      setUserName(res.data.name);
      })
    .catch(err => console.log(err))
    axios.get(`http://localhost:8080/zoomgo/products/${Id}`,{
      
    })
    .then(res => {
      setData(res.data);
      })
    .catch(err => console.log(err))
  })

  const handleRecommendGood = () => {
    setUserRecommend(1);
    axios.post("http://localhost:8080/zoomgo/review/user",{
      userNo : 1,
      nickname: userName,
      reviewer: data.memberId,
      recommend: userRecommend 
    })
    closeModal();
  }

  const handleRecommendBad = () => {
    setUserRecommend(-1);
    axios.post("http://localhost:8080/zoomgo/review/user",{
      userNo : 1,
      nickname: userName,
      reviewer: data.memberId,
      recommend: userRecommend 
    })
    closeModal();
  }

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
                <span className={style.recommand_nickname}>{userName}</span>님의 의견을 알려주세요.
              </div>
              <div className={style.product_note}> {data.title} </div>
              <div className={style.button_container}>
                <button className={style.button}>
                  <div className={style.button_bg}></div>
                  <div className={style.button_text} onClick={handleRecommendGood}>좋아요</div>
                </button>
                <button className={style.button}>
                  <div className={style.button_bg}></div>
                  <div className={style.button_text} onClick={handleRecommendBad}>싫어요</div>
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
