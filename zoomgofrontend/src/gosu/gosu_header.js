import { Link } from "react-router-dom";
import "../css/main/gosu_header.css";

function Header() {
  return (
    <header className="gosu_header">
      <div className="gosu_banner">
        <Link to="/">
          <button className="banner_button">중고</button>
        </Link>
        <Link to="/gosupage">
          <button className="banner_button">숨고</button>
        </Link>
      </div>
      <div className="gosu_Logo">
        <Link to="/">
          <button className="logo_button">ZOOMGO</button>
        </Link>
      </div>
      <div className="gosu_Category">
        <ul className="gosu_CategoryList">
          <li>
            <a href="#">견적요청</a>
          </li>
          <li>
            <a href="#">고수찾기</a>
          </li>
        </ul>
      </div>
      <div className="gosu_profile">
        <ul className="gosu_profileList">
          <li>
            <a href="#">받은 견적</a>
          </li>
          <li>
            <a href="#">채팅</a>
          </li>
          <Link to="/Login">
            <li>
              <button>로그인</button>
            </li>
          </Link>
          <li>
            <button>고수 전환</button>
          </li>
        </ul>
      </div>
    </header>
  );
}

export default Header;
