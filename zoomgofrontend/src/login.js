
import { useNavigate, Link } from 'react-router-dom'
import './css/main/header.css'
import './css/Login/login.css'
function Login() {
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
            <div className="section">
                <div className="loginForm">
                    <h1>ZOOMGO</h1><br />
                    Email:<br />
                    <br />
                    <input type = "text" name="userId" className="userId" placeholder='zoomgo@gmail.com'/><br />
                    <br /><br />
                    password:
                    <br /><br />
                    <input type = "password" name="userPw" className="userPw" />
                    <br />
                    <Link to ="/findInfo"><p className="findPw">forgot Password?</p></Link>       
                    <input type ="submit" className='loginSubmit' value ="Login"/>
                    <br />
                    <br />
                    <p className="signup">Don't have an Account? <Link to ="/regist"><span>SignUp</span></Link></p>
                </div>
            </div>
        </div>
    )
}


export default Login;