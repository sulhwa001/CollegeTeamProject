import { FaAngleLeft, FaAngleRight, FaStar } from "react-icons/fa";
import { FaRegShareFromSquare } from "react-icons/fa6";
import "./css/portfolio/portfolio.css";
import Header from "./header";
import dogs from "./img/dog.png";
function Portfolio() {
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
            <img src={dogs} />
          </div>
        </div>
        <div className="portfolio_details">
          <h3>
            내가 작업한 포토샵 메이크 업 <br />
            헤어 사진
          </h3>
          <br />
          <br />
          <p className="portfolio_view_count">조회 {0}</p>
          <br />
          <div className="portfolio_line"></div>
          <br />
          <br />
          <div style={{ display: "flex", alignItems: "center" }}>
            <div className="portfolio_profile_picture"></div>
            <div className="portfolio_profile_info">
              <h3>&emsp;이름</h3>
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
              <span>피부/미용</span>
            </div>
            <div className="portfolio_info_list">
              <p>지역 정보</p>
              <span>전남 장성군</span>
            </div>
            <div className="portfolio_info_list">
              <p>가격대</p>
              <span>100,000원</span>
            </div>
            <div className="portfolio_info_list">
              <p>작업년도</p>
              <span>2024</span>
            </div>
            <div className="portfolio_explain">
              <p>
                메이크업헤어 + 모델 시간당 포토샵 포함시 10만원으로 진행 합니다
                촬영 끝나고 5일 안에 보정본 보내드립니다 포토샵 as가능합니다
              </p>
              <button>목록</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
export default Portfolio;
