import React, { useState } from 'react';
import './forgotpassword.css';

function ForgotPassword() {
  const [email, setEmail] = useState('');
  const [isCodeSent, setIsCodeSent] = useState(false);
  const [numbercode, setNumbercode] = useState(''); // 인증 코드 상태

  const handleSendCode = async () => {
    try {
      const response = await fetch('http://localhost:8080/emailCheck', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email }),
      });

      if (response.ok) {
        alert('인증 코드가 전송되었습니다.');
        setIsCodeSent(true); // 인증 코드 입력 폼 표시
        // 이메일을 로컬 스토리지에 저장
        localStorage.setItem('resetEmail', email);
      } else {
        alert('이메일 전송 실패. 다시 시도해주세요.');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('서버 연결 실패.');
    }
  };

  const handleConfirmCode = async () => {
    try {
      const response = await fetch('http://localhost:8080/numberCheck', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ numbercode }), // numbercode 키로 데이터 전송
      });

      if (response.ok) {
        alert('인증 코드가 확인되었습니다.');
        window.location.href = 'forgotpasswordpage';
      } else {
        alert('인증 코드가 잘못되었습니다. 다시 시도하세요.');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('서버 연결 실패.');
    }
  };

  return (
    <div className="forgotpassword1">
      <h1 className="mainlogo">ZOOMGO</h1>
      <h2 className="forgotpassword">비밀번호 변경</h2>
      <div className="forgot-password3">
        <input
          type="text"
          id="email"
          placeholder="입력하신 이메일로 인증번호를 전송해 드립니다."
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <button className="send-button" onClick={handleSendCode}>
          전송
        </button>
      </div>
      {isCodeSent && (
        <>
          <h2 className="email-password">이메일 인증코드</h2>
          <div className="forgot-password3">
            <input
              type="text"
              id="numbercode"
              placeholder="인증코드를 입력하세요."
              value={numbercode}
              onChange={(e) => setNumbercode(e.target.value)}
              className="code-input"
            />
          </div>
          <div className="button-container">
            <button className="confirm-button" onClick={handleConfirmCode}>
              확인
            </button>
          </div>
        </>
      )}
    </div>
  );
}

export default ForgotPassword;
