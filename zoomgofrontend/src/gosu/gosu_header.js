import { useState } from "react";
import { Link, Route, useNavigate } from "react-router-dom";
import "../css/main/gosu_header.css";
import ProfileInput from "./profile.input";
function Header() {
  const [member, setMember] = useState({});
  // useEffect(() => {
  //     const token = localStorage.getItem('zoomgo-token'); // 저장된 JWT 가져오기
  //   console.log(token)
  //   const fetchMember = async () => {
  //     try {
  //       const response = await axios.get(
  //         `http://localhost:8080/api/members/profile`,{
  //           headers: {Authorization: `Bearer ${token}`}
  //       });
  //       console.log(response.data);

  //       setMember(response.data);

  //     }
  //      catch (err) {
  //       console.log(err);
  //     }
  //   };

  //   fetchMember();
  // }, []);

  const navigate = useNavigate();

  const gosuChange = async () => {
    const check = window.confirm("고수로 전환하시겠습니까?");
    if (check) {
      <Route path="/ProfileInput" element={<ProfileInput />} />;
    }
  };

  return (
    <header className="gosu_header">
      <div className="gosu_banner">
        <Link to="/">
          <button className="banner_button">중고</button>
        </Link>
        <Link to="/gosupage">
          <button className="banner_button">고수</button>
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
            <Link to="">
              <p>견적요청</p>
            </Link>
          </li>
          <li>
            <Link to="/categoryPorfolio">
              <p>고수찾기</p>
            </Link>
          </li>
        </ul>
      </div>
      <div className="gosu_profile">
        <ul className="gosu_profileList">
          <li>
            <a>받은 견적</a>
          </li>
          <li>
            <a>채팅</a>
          </li>

          <Link to="/Login">
            <li>
              <button>로그인</button>
            </li>
          </Link>

          <li>
            <button onClick={gosuChange}>고수 전환</button>
          </li>
        </ul>
      </div>
    </header>
  );
}

export default Header;
