import React, { useState, useEffect } from 'react';
import { useNavigate, useLocation } from 'react-router-dom'; // useLocation 추가
import './userinfo.css';

function Userinfo() {
  const navigate = useNavigate(); 
  const location = useLocation(); // 이전 페이지에서 전달된 데이터를 받음
  const [formData, setFormData] = useState({
    email: '',
    password: '',
    name: '',
    nickName: '',
    address: '',
    detailAddress: '',
    birthDate: '',
    phone: '',
    gender: '',
  });

  useEffect(() => {
    // 이전 페이지에서 전달된 email을 formData에 추가
    if (location.state && location.state.email) {
      setFormData((prev) => ({
        ...prev,
        email: location.state.email,
      }));
    }
  }, [location.state]);

  const handleInputChange = (e) => {
    const { id, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [id]: value,
    }));
  };

  const handleNextClick = async () => {
    if (formData.password !== formData.confirmPassword) {
      alert('비밀번호가 일치하지 않습니다.');
      return;
    }

    try {
      const response = await fetch('http://localhost:8080/api/members/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        alert('회원가입 성공!');
        navigate('/'); 
      } else {
        alert('회원가입 실패. 다시 시도하세요.');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('서버 연결 실패.');
    }
  };

  return (
    <div className='userinfo-form'>
      <h1 className='userinfo-logo'>ZOOMGO</h1>

      <div className="input-container">
        <div className="input-group10">
          <label htmlFor="password" className='password-info'>비밀번호:</label>
          <input
            className='passwordcss'
            type="password"
            id="password"
            value={formData.password}
            onChange={handleInputChange}
          />
        </div>
        <div className="input-group10">
          <label htmlFor="name" className='firstname-info'>이름:</label>
          <input
            className='namecss'
            type="text"
            id="name"
            value={formData.name}
            onChange={handleInputChange}
          />
        </div>
      </div>
      <label className='inputerror'>※8글자 이상 입력하세요</label>
      <div className="input-container">
        <div className="input-group10">
          <label className='password-info'>비밀번호 확인:</label>
          <input
            className='passwordcss'
            type="password"
            id="confirmPassword"
            value={formData.confirmPassword}
            onChange={handleInputChange}
          />
        </div>

        <div className="input-group10">
          <label htmlFor="nickname" className='firstname-info'>닉네임:</label>
          <input
            className='namecss2'
            type="text"
            id="nickName"
            value={formData.nickName}
            onChange={handleInputChange}
          />
        </div>
      </div>
      <label className='inputerror2'>※비밀번호가 올바르지 않습니다</label>

      <div className="input-group3">
        <label htmlFor="address" className='password-info'>주소:</label>
        <input
          className='passwordcss'
          type="text"
          id="address"
          value={formData.address}
          onChange={handleInputChange}
        />
        <button className="address-input">주소검색</button>
      </div>
      <div className='input-container'>
        <div className="input-group10">
          <label htmlFor="birthDate" className='password-info'>생년월일:</label>
          <input
            className='birth-date-input'
            type="date"
            id="birthDate"
            value={formData.birthDate}
            onChange={handleInputChange}
          />
        </div>

        <div className="input-group10">
          <label htmlFor="phone" className='firstname-info'>전화번호:</label>
          <div className="login-input">
            <input
              className='phone_number_info'
              type="text"
              id="phone"
              placeholder="010-0000-0000"
              value={formData.phone}
              onChange={handleInputChange}
            />
          </div>
        </div>
      </div>
      <div className='input-group5'>
        <label htmlFor="gender" className='gender-label'>성별:</label>
        <select
          id="gender"
          className='gender-select'
          value={formData.gender}
          onChange={handleInputChange}
        >
          <option value="">select</option>
          <option value="male">남</option>
          <option value="female">여</option>
        </select>
      </div>
      <div className='gogotsugi_button'>
        <button className="gogotsugi" onClick={handleNextClick}>회원가입</button>
      </div>
    </div>
  );
}

export default Userinfo;
