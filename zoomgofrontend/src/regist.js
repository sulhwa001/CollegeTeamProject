import './css/main/header.css'
import './css/regist/regist.css'

import { Link } from 'react-router-dom';
function Regist() {
    return (
        <div className="App">
            <header className="header">
                <div className="banner">
                    <div><a>중고</a></div>
                    <div><a>숨고</a></div>
                </div>
                <div className="Logo">
                    <Link to="/Main"><button>ZOOMGO</button></Link>
                </div>
                <div className="Category">
                    <ul className="CategoryList">
                        <li><a href="#">견적요청</a></li>
                        <li><a href="#">고수찾기</a></li>
                    </ul>
                </div>
                <div className="profile">
                    <ul className="profileList">
                        <li><a href="#">받은 견적</a></li>
                        <li><a href="#">채팅</a></li>
                        <Link to="/Login"><li><button>로그인</button></li></Link>
                        <li><button>고수 전환</button></li>
                    </ul>
                </div>
            </header>
            <div className="regist_section">
                <div className="registBox">
                    <h1>ZOOMGO</h1>
                    <ul className="firstInfo">
                        <li className="password">비밀번호:</li>
                        <li className="name">이름:</li>
                        <li>성:</li>
                    </ul>
                    <div className="firstInput">
                        <input type="text" name="username" className="firstInput_password" />
                        <input type="text" name="userPw" className="firstInput_user_name" />
                        <input type="text" name="user" className="firstInput_user_first_name" />
                    </div>
                    <p className="password_test">※8글자 이상 입력해주세요.</p><br />
                    <ul className="secondInfo">
                        <li className="second_password">비밀번호 확인:</li>
                        <li >닉네임:</li>
                    </ul>
                    <ul className="secondInput">
                        <li className="password_second"><input type="text" name="password_check" className="password_check" /></li>
                        <li><input type="text" name="password_check" className="password_check" /></li>
                    </ul>
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
                        <select aria-selected>
                            <option>Select</option>
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