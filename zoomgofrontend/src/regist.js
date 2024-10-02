import { useState } from 'react';
import './css/regist/regist.css';
import Header from './header';
function Regist() {

    const [userFirstName, setUserFirstName] = useState("")
    const [userName, setUserName] = useState("")
    const [userId, setUserId] = useState("")
    const [nickName, setNickName] = useState("")
    const [UserPw, setUserPw] = useState("")
    const [address, setAddress] = useState("")
    const [detailAddress, setDetailAddress] = useState("")
    const [birth, setBirth] = useState("")
    const [phone, setPhone] = useState("")

    return (
        <div className="App">
            <Header />
            <div className="regist_section">
                <div className="registBox">
                    <h1>ZOOMGO</h1>
                    <ul className="firstInfo">
                        <li className="password">이메일:</li>
                        <li className="name">이름:</li>
                        <li>성:</li>
                    </ul>
                    <div className="firstInput">
                        <input type="text" name="userId" className="firstInput_password"
                            onChange={(e) => {
                                setUserId(e.target.value)
                            }}
                        />
                        <input type="text" name="username" className="firstInput_user_name"
                            onChange={(e) => {
                                setUserName(e.target.value)
                            }}
                        />
                        <input type="text" name="userfirstname" className="firstInput_user_first_name"
                            onChange={(e) => {
                            setUserFirstName(e.target.value)
                        }}/>
                    </div>
                    <ul className="secondInfo">
                        <li className="second_password">비밀번호:</li>
                        <li className="nickname">닉네임:</li>
                    </ul>
                    <ul className="secondInput">
                        <li className="password_second">
                            <input type="text" name="password_check" className="password_check"
                                onChange={(e) => {
                                    setUserPw(e.target.value)
                            }}
                            /></li>
                        <li>
                            <input type="text" name="nickname" className="password_check"
                                onChange={(e) => {
                                    setNickName(e.target.value)
                            }}
                            /></li>
                    </ul>
                    <p className="password_test">※8글자 이상 입력해주세요.</p><br />
                    <ul className="addressBox">
                        <li>&nbsp;&nbsp;주소:</li>
                        <li><input type="text" name="address_input" className="address_input" /></li>
                        <button className="address_button">주소검색</button>
                    </ul>
                    <ul className="address_detail">
                        <li>상세주소:</li>
                        <li><input type="text" name="address_detail_input" className="address_detail_input" /></li>
                    </ul>
                    <ul className="birth_phone">
                        <li className="birth">생년월일:</li>
                        <li>전화번호:</li>
                    </ul>
                    <ul className="birth_phone_input">
                        <li><input type="date" name="birth_input" className="birth_input" /></li>
                        <li><input type="text" name="phone_input" className="phone_input" placeholder='000-0000-0000' /></li>
                    </ul>
                    <div className='sex'>
                        성별:<br />
                        <select  selected>
                            <option>male</option>
                            <option>Female</option>
                        </select>
                    </div>
                    <div>
                        <button className="regist_button">회원가입</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Regist;