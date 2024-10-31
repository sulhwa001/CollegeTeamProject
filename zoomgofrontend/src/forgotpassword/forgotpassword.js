import React from 'react';
import './forgotpassword.css';

function forgotpassword() {
  return (
    <div className='forgotpassword1'>
      <h1 className='mainlogo'>ZOOMGO</h1>
      <h2 className='forgotpassword'>비밀번호 변경</h2>
      <div className="forgot-password3">
        <input
          type="text"
          id="email"
          placeholder="입력하신 이메일로 비밀번호를 전송해 드립니다." />
        <button className="send-button">전송</button>
      </div>
      <h2 className='email-password'>이메일 인증코드</h2>
      <div className="verification-code">
            <input type="text" maxlength="1" class="code-input" placeholder=" " />
            <input type="text" maxlength="1" class="code-input" placeholder=" " />
            <input type="text" maxlength="1" class="code-input" placeholder=" " />
            <input type="text" maxlength="1" class="code-input" placeholder=" " />
            <input type="text" maxlength="1" class="code-input" placeholder=" " />
            <input type="text" maxlength="1" class="code-input" placeholder=" " />
        </div>
        <div class="button-container">
            <button class="confirm-button">확인</button>
        </div>
    </div>
  );
}

export default forgotpassword;
