import axios from "axios";
import { useEffect, useState } from "react";
import { FaAngleLeft, FaAngleRight, FaStar } from "react-icons/fa";
import { FaRegShareFromSquare } from "react-icons/fa6";
import "../css/portfolio/portfolio.css";
import Header from "./gosu_header";
function Portfolio() {
  const [member, setMember] = useState({})
  const [portfolio, setportfolio] = useState({});
  useEffect(() => {
    const token = localStorage.getItem("zoomgo-token"); // 저장된 JWT 가져오기
    
    const fetchMember = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/members/profile`,{
            headers: {Authorization: `Bearer ${token}`}
        });
        console.log(response.data);
        
        setMember(response.data);
        
      }
       catch (err) {
        console.log(err);
      }
    };

    const fetchPortfolio = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/portfolio/getPortfolio`, {
            headers: {Authorization: `Bearer ${token}`}
        });
        console.log(response)
        setportfolio(response.data);
      } catch (err) {
        console.log(err);
      }
    };

    fetchMember();
    fetchPortfolio();
  }, []);
  return (
    <div className="App">
      <Header />
      <div className="portfolio_section">
        <div className="portfolio_background">
          <div className="portfolio_pictures">
            <div className="left_button">
              <FaAngleLeft
                color="white"
                style={{ marginLeft: "1.8vh", marginTop: "1.8vh" }}
              />
            </div>
            <div className="right_button">
              <FaAngleRight
                color="white"
                style={{ marginLeft: "1.8vh", marginTop: "1.8vh" }}
              />
            </div>
            {/* <img src={portfolio.pic} /> */}
          </div>
        </div>
        <div className="portfolio_details">
          <h3>
            내가 작업한 포토샵 메이크 업 <br />
            헤어 사진
          </h3>
          <br />
          <br />
          <p className="portfolio_view_count" style={{ marginTop: "-20px" }}>
            조회{" "}
          </p>
          <br />
          <div className="portfolio_line"></div>
          <br />
          <br />
          <div
            style={{
              display: "flex",
              alignItems: "center",
              marginTop: "-50px",
            }}
          >
            <div className="portfolio_profile_picture"></div>
            <div className="portfolio_profile_info">
              <h3>&emsp;{portfolio.userNo === member.userNo ? (member.name) : ("")}</h3>
              &emsp;&nbsp;
              <FaStar color="orange" className="review_stars_img" />
              &nbsp;
              <FaStar color="orange" className="review_stars_img" />
              &nbsp;
              <FaStar color="orange" className="review_stars_img" />
              &nbsp;
              <FaStar color="orange" className="review_stars_img" />
              &nbsp;
              <FaStar color="orange" className="review_stars_img" />
            </div>
            <div style={{ width: "00px" }}>
              <FaRegShareFromSquare
                style={{ width: "220px", height: "30px" }}
              />
            </div>
          </div>
          <br />
          <br />
          <div className="portfolio_estimate">
            <button>견적 요청하기</button>
          </div>
          <div className="portfolio_estimate_info">
            <div className="portfolio_info_list">
              <p>숨고 카테고리</p>
              {/* <span>{portfolio.category}</span> */}
            </div>
            <div className="portfolio_info_list">
              <p>지역 정보</p>
              <span>{portfolio && portfolio.area ? portfolio.area : ""}</span>
            </div>
            <div className="portfolio_info_list">
              <p>가격대</p>
              <span>
                {portfolio && portfolio.price ? portfolio.price : ""}원
              </span>
            </div>
            <div className="portfolio_info_list">
              <p>작업년도</p>
              <span>{portfolio.year}년</span>
            </div>
            <div className="portfolio_explain">
              <p>{portfolio && portfolio.article ? portfolio.article : ""}</p>
              <button>목록</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Portfolio;
