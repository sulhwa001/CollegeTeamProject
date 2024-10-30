import './css/main/header.css'
import {Link} from 'react-router-dom'


function Header() {
    return (
        <header className="header">
            <div className="banner">
                <div><a>중고</a></div>
                <div><a>숨고</a></div>
            </div>
            <div className="Logo">
                <Link to="/"><button>ZOOMGO</button></Link>
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
    )
}

export default Header;