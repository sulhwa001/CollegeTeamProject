import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // useNavigate 훅을 임포트
import './Registpage.css';

function RegistPage() {
  const [isVerified, setIsVerified] = useState(false);
  const navigate = useNavigate(); // useNavigate 훅 사용
  const [email, setEmail] = useState('');
  const [numbercode, setNumberCode] = useState('');

  const handleNextClick = () => {
  if (!isVerified) {
    alert("인증을 받아주세요");
  } else {
    navigate('/userinfo', { state: { email } }); // email을 state로 전달
  }
};

  const emailCheck = async () => {
    try {
      const response = await fetch('http://localhost:8080/emailCheck', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email }),
      });

      if (response.ok) {
        alert('인증코드 전송 완료');
      } else {
        alert('전송 실패');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('에러입니다', error);
    }
  };

  const numberCheck = async () => {
    try {
      const response = await fetch('http://localhost:8080/numberCheck', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ numbercode }),
      });

      if (response.ok) {
        alert('인증 성공!');
        setIsVerified(true);
        localStorage.setItem('verifiedEmail', email); // 인증 성공 시 email 저장
      } else {
        alert('인증 실패!');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('에러입니다! ${error.message}');
    }
  };

  return (
    <div className="container">
      <h1 className="mainlogo">ZOOMGO</h1>
      <form className="regist-main">
        <label htmlFor="email">Email:</label>
        <div className="input-button-container">
          <input
            className="regist-input"
            type="text"
            id="email"
            placeholder="zoomgo.gmail.com"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <div className="gogodeta">
            <button type="button" className="send_button" onClick={emailCheck}>
              전송
            </button>
          </div>
        </div>
      </form>

      <form className="regist-main">
        <label htmlFor="verification">인증번호:</label>
        <div className="input-button-container">
          <input
            className="regist-input"
            type="text"
            id="verification"
            placeholder="인증번호를 입력하세요"
            value={numbercode}
            onChange={(e) => setNumberCode(e.target.value)}
          />
          <div className="gogodeta">
            <button type="button" className="number_button" onClick={numberCheck}>
              인증
            </button>
          </div>
        </div>
        <label>메일로 전송한 인증번호를 입력해주세요</label>
      </form>

      <form className="login-form">
        {isVerified && (
          <button
            id="buttons"
            type="button"
            className="login-button"
            onClick={handleNextClick}
          >
            다음
          </button>
        )}
      </form>
    </div>
  );
}

export default RegistPage;
