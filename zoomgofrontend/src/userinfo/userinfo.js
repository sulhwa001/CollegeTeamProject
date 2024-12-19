import React from 'react';
import { useNavigate } from 'react-router-dom'; // useNavigate 훅 임포트
// import './App.css';
import './userinfo.css';

function Userinfo() {
  const navigate = useNavigate(); // useNavigate 훅 사용

  const handleNextClick = () => {
    navigate('/agreement'); // '/agreement' 경로로 이동
  };

  return (
    <div className='userinfo-form'>
      <h1 className='userinfo-logo'>ZOOMGO</h1>

      <div className="input-container">
        <div className="input-group">
          <label htmlFor="password-info" className='password-info'>비밀번호:</label>
          <input className='passwordcss' type="password" id="passwordinfo" />
        </div>

        <div className="input-group">
          <label htmlFor=" -info" className='firstname-info'>이름:</label>
          <input className='namecss' type="text" id="firstnameinfo" />
        </div>

        <div className="input-group">
          <label htmlFor="lastname-info" className='lastname-info'>성:</label>
          <input className='namecss' type="text" id="lastnameinfo" />
        </div>
      </div>
      <label className='inputerror'>※8글자 이상 입력하세요</label>
      <div className="input-container">
        <div className="input-group">
          <label className='password-info'>비밀번호 확인:</label>
          <input className='passwordcss' type="password" id="passwordinfo" />
        </div>

        <div className="input-group">
          <label htmlFor="firstname-info" className='firstname-info'>닉네임:</label>
          <input className='namecss2' type="text" id="firstnameinfo2" />
        </div>
      </div>
      <label className='inputerror2'>※비밀번호가 올바르지 않습니다</label>

      <div className="input-group3">
        <label htmlFor="input-group" className='password-info'>주소:</label>
        <input className='passwordcss' type="password" id="passwordinfo" />
        <button className="address-input">주소검색</button>
      </div>
      <div className="input-group3">
        <label htmlFor="input-group" className='password-info'>상세주소:</label>
        <input className='address-input-add' type="password" id="passwordinfo" />
      </div>
      <div className='input-container'>
        <div className="input-group">
          <label className='password-info'>생년월일:</label>
          <input className='birth-date-input' type="date" id="passwordinfo" />
        </div>

        <div className="input-group">
          <label htmlFor="firstname-info" className='firstname-info'>전화번호:</label>
          <div className="login-input">
            <input
              className='phone_number_info'
              type="text"
              id="phone"
              placeholder="010-0000-0000" />
          </div>
        </div>
      </div>
      <div className='input-group5'>
        <label htmlFor="gender" className='gender-label'>성별:</label>
        <select id="gender" className='gender-select'>
          <option value="">select</option>
          <option value="male">남성</option>
          <option value="female">여성</option>
        </select>
      </div>
      <div className='gogotsugi_button'>
      <button className="gogotsugi" onClick={handleNextClick}>다음</button>
    </div>
    </div>
  );
}

export default Userinfo;
