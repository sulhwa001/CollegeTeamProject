import React from 'react';
import { useNavigate } from 'react-router-dom'; // useNavigate 훅을 임포트
import './Registpage.css';

function RegistPage() {
  const navigate = useNavigate(); // useNavigate 훅 사용

  const handleNextClick = () => {
    navigate('/userinfo'); // '/userinfo' 경로로 이동
  };

  return (
    <div className="container">
      <h1 className='mainlogo'>ZOOMGO</h1>
      <form className="regist-main">
        <label htmlFor="email">Email:</label>
        <div className="input-button-container">
          <input
            className='regist-input'
            type="text"
            id="email"
            placeholder="zoomgo.gmail.com" />
            <div className='gogodeta'>
          <button type="button">전송</button>
          </div>
        </div>
      </form>

      <form className="regist-main">
        <label htmlFor="verification">인증번호:</label>
        <div className="input-button-container">
          <input
            className='regist-input'
            type="text"
            id="verification"
            placeholder="인증번호를 입력하세요" />
            <div className='gogodeta'>
          <button type="button">인증</button>
          </div>
        </div>
        <label>메일로 전송한 인증번호를 입력해주세요</label>
      </form>

      <form className="login-form">
        <button
          type="button"
          className="login-button"
          onClick={handleNextClick} // 버튼 클릭 시 handleNextClick 호출
        >
          다음
        </button>
      </form>
    </div>
  );
}

export default RegistPage;
