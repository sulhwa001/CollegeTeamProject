
import { useNavigate, Link } from 'react-router-dom'
import Header from './header'
import './css/Login/login.css'
function Login() {
    return (
        <div className="App">
            <Header />
            <div className="section">
                <div className="loginForm">
                    <h1>ZOOMGO</h1><br /><br /><br />
                    Email:<br />
                    <input type = "text" name="userId" className="userId" placeholder='zoomgo@gmail.com'/><br />
                    <br /><br />
                    password:
                    <br />
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