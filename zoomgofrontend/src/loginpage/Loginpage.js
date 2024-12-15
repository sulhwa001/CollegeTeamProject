import React, { useState } from 'react';
import './Loginpage.css';

function LoginPage() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async () => {
    try {
      const response = await fetch('http://localhost:8080/auth', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
      });
  

      if (response.ok) {
        const data = await response.json();
        window.localStorage.setItem('zoomgo-token', data.accessToken);
        alert("로그인완료!!");

        window.location.href="/"
        
      } else {
        alert("Login failed!");
      }
    } catch (error) {
      alert("Error:", error);
    }
  };

  return (
    <div className="login">
      <h1 className='mainlogo'>ZOOMGO</h1>
      <form className="loginpage-form" onSubmit={(e) => e.preventDefault()}>
        <label htmlFor="email">Email:</label>
        <div className="login-input">
          <input
            className='login-main-email'
            type="text"
            id="email"
            placeholder="zoomgo@gmail.com"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
      </form>
      <form className="loginpage-form" onSubmit={(e) => e.preventDefault()}>
        <label htmlFor="password">Password:</label>
        <div className="password-input">
          <input
            className='password-main'
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
        <div className='forgot-password-link'>
          <a href="/forgotpassword" className="forgot-password">Forgot Password?</a>
        </div>
      </form>
      <button type="button" className="loginpage-button" onClick={handleLogin}>
        Login
      </button>
      <div className="registgogo">
        <label>Don’t have an account?</label>
        <a href="/regist" className="forgot-password"> Sign Up</a>
      </div>
    </div>
  );
}

export default LoginPage;
