import React, { useState } from 'react';
import axios from 'axios';
import './forgotpasswordpage.css';

function ForgotPasswordPage() {
  const [newpassword, setPassword] = useState('');
  const email = localStorage.getItem('resetEmail');

  const handleResetPassword = async () => {
    if (!email) {
      alert('인증된 이메일이 없습니다. 다시 시도해주세요.');
      return;
    }

    try {
      const data = {
        newPassword: newpassword,
        email: email,
      };
      const response = await axios.put('http://localhost:8080/resetpassword', data);

      if (response.status === 200) {
        alert('비밀번호가 성공적으로 변경되었습니다.');
        localStorage.removeItem('resetEmail');
        window.location.href = '/login';
      }
    } catch (error) {
      console.error('Error:', error);
      if (error.response && error.response.status === 400) {
        alert('잘못된 요청입니다. 다시 시도해주세요.');
      } else {
        alert('서버 연결 실패.');
      }
    }
  };

  return (
    <div className="forgotpasswordpage">
      <h1>비밀번호 변경</h1>
      <div className="reset-password">
        <input
          type="password"
          placeholder="새 비밀번호를 입력하세요"
          value={newpassword}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button onClick={handleResetPassword}>비밀번호 변경</button>
      </div>
    </div>
  );
}

export default ForgotPasswordPage;
