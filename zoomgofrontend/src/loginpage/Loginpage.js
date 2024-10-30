import React from 'react';
import './Loginpage.css';

function loginpage() {
  return (
    <div className="login">
      <h1 className='mainlogo'>ZOOMGO</h1>
      <form className="loginpage-form">
        <label htmlFor="email">Email:</label>
        <div className="login-input">
          <input
            className='login-main-email'
            type="text"
            id="email"
            placeholder="zoomgo@gamil.com"/>
        </div>
      </form>
      <form className="loginpage-form">
        <label htmlFor="verification">password:</label>

        <div className="password-input">
          <input
            className='password-main'
            type="text"
            id="verification"/>
            </div>
            <div className='forgot-password-link'>
            <a href="/forgotpassword" className="forgot-password">Forgot Password?</a>
            </div>
      </form>
      <form className="loginpage-button-form">
        <button type="button" className="loginpage-button">Login</button>
      </form>
      <form className="registgogo">
        <label>Don’t have an account?</label><a href="/regist" className="forgot-password">  Sign Up</a>
      </form>
      </div>
      
  );
}

export default loginpage;
