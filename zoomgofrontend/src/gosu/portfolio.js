import { FaAngleLeft, FaAngleRight, FaStar } from "react-icons/fa";
import { FaRegShareFromSquare } from "react-icons/fa6";
import "../css/portfolio/portfolio.css";
import dogs from "../img/dog.png";
import Header from "./gosu_header";
function Portfolio() {
  const portfolio = {
    title: "내가 작업한 포토샵 메이크 업 헤어 사진",
    preview: 0,
    name: "김강민",
    category: "피부/미용",
    area: "전남 장성군",
    price: 100000,
    workYear: 2024,
    article: "메이크업헤어 + 모델 시간당 포토샵 포함시 10만원으로 진행 합니다 촬영 끝나고 5일 안에 보정본 보내드립니다 포토샵 as가능합니다",
    pic:dogs,
  }
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
            <img src={portfolio.pic} />
          </div>
        </div>
        <div className="portfolio_details">
          <h3>
            내가 작업한 포토샵 메이크 업 <br />
            헤어 사진
          </h3>
          <br />
          <br />
          <p className="portfolio_view_count" style={{marginTop:"-20px"}}>조회 {portfolio.preview}</p>
          <br />
          <div className="portfolio_line"></div>
          <br />
          <br />
          <div style={{ display: "flex", alignItems: "center" ,marginTop:"-50px" }}>
            <div className="portfolio_profile_picture"></div>
            <div className="portfolio_profile_info">
              <h3>&emsp;{portfolio.name}</h3>
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
              <span>{portfolio.category}</span>
            </div>
            <div className="portfolio_info_list">
              <p>지역 정보</p>
              <span>{portfolio.area}</span>
            </div>
            <div className="portfolio_info_list">
              <p>가격대</p>
              <span>{portfolio.price}원</span>
            </div>
            <div className="portfolio_info_list">
              <p>작업년도</p>
              <span>{portfolio.workYear}</span>
            </div>
            <div className="portfolio_explain">
              <p>
                {portfolio.article}
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
