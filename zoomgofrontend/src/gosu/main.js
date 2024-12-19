import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link } from "react-router-dom";
import "../App.css";
import "../css/main/footer.css";
import "../css/main/gosu_header.css";
import "../css/main/section.css";
import "../css/main/section2.css";
import "../css/main/section3.css";
import "../css/main/section4.css";
import stars from "../img/review_stars.png";
import Header from "./gosu_header";
function Main() {
  
  const [gosu, setGosu] = useState("")
  useEffect(() => {
    try {

      const fetchPortfolio = () => {
        const response = axios.get(`http://localhost:8080/portfolio/`)
        setGosu(response.data)
      }
    }
    catch (err) {
      console.log(err)
    }
  }, [gosu])

  const nameList = ["조은준", "박재찬", "김성근", "황도윤"];
  const picList = ["1", "2", "3", "4"];
  const portfolioList = [
    "포트폴리오1",
    "포트폴리오2",
    "포트폴리오3",
    "포트폴리오4",
  ];

  const gosuCategoryList = [];

  const portfolioNameList = ["박재찬", "조은준"];
  const categoryNameList = ["IT", "예술/미술"];
  const scoreList = ["4.5", "5.0"];
  const contentList = ["내용적기", "내용적기2"];
  for (let i = 0; i < 2; i++) {
    const gosuCategory = {
      name: portfolioNameList[i],
      categoryName: categoryNameList[i],
      score: scoreList[i],
      content: contentList[i],
    };
    gosuCategoryList.push(gosuCategory);
  }

  const gosuList = [];
  for (let i = 0; i < 4; i++) {
    const gosus = {
      name: nameList[i],
      profilePic: picList[i],
      portfolio: portfolioList[i],
    };
    gosuList.push(gosus);
  }
  const gosuAreaList = [];

  const gosuAreaNameList = ["이재한", "박재찬", "김성근"];
  const career = [1, 3, 5];
  const categoryName = ["IT/인터넷", "설비/공사", "운동/PT"];
  const score = ["4.5", "2.0", "1.5"];
  const picture = ["image1.jpg", "image2.jpg", "image3.jpg"];
  for (let i = 0; i < 3; i++) {
    const gosuArea = {
      name: gosuAreaNameList[i],
      career: career[i],
      categoryName: categoryName[i],
      score: score[i],
      picture: picture[i],
    };
    gosuAreaList.push(gosuArea);
  }

  const style = {
    listStyle: "none",
    textDecoration: "none",
    color: "black"
  };
  return (
    <div className="App">
      <Header />
      <div className="section1">
        <div className="title">
          <div>
            <span className="zoomgo">ZOOMGO</span>
          </div>
          <div>
            <span className="article">내가 필요한 서비스를 단 한곳에서</span>
          </div>
        </div>
      </div>
      <div className="section2">
        <div className="title2">
          <h1>숨은고수 포트폴리오</h1>
        </div>
        <div className="pictureList">
          {gosuList.map((index, value) => (
            <ul style={{
              listStyle:"none",
            }}>
              <Link to="/portfolio" style={style}>
                <li
                  style={{
                    width: "200px",
                    height: "200px",
                    marginRight: "30px",
                    border: "1px solid #eaeaea",
                  }}
                  key={value}
                >
                  {index.portfolio}
                </li>
              </Link>
              <div style={{ display: "flex" }}>
                <li
                  key={value}
                  style={{
                    border: "1px solid #eaeaea",
                    width: "20px",
                    height: "20px",
                    borderRadius: "20px 20px 20px 20px",
                  }}
                >
                  {index.profilePic}
                </li>
                <Link to="/profile" style={style}>
                  <li key={value}>{index.name}</li>
                </Link>
              </div>
            </ul>
          ))}
        </div>
      </div>

      <div className="section3">
        <div className="title3">
          <h1>내가 관심있는 카테고리의 숨은고수</h1>
        </div>
        <div className="review">
          {gosuCategoryList.map((value, index) => (
            <div className="review_box">
              <div className="review_top">
                <div className="profile_picture"></div>
                <div className="profile_name">
                  <span style={{ color: "black" }} key={index}>
                    {value.name}
                  </span>
                  <br />
                  <span className="review_work">{value.categoryName}</span>
                </div>
              </div>
              <div className="main_category_score">
                <div style={{ display: "flex", alignItems: "center" }}>
                  <img src={stars} className="score_star" />
                  <img src={stars} className="score_star" />
                  <img src={stars} className="score_star" />
                  <img src={stars} className="score_star" />
                  <img src={stars} className="score_star" />
                  &nbsp;
                  <p className="main_category_review_score">{value.score}</p>
                </div>
                <p className="main_category_review">{value.content}</p>
                <Link
                  to="/portfolio"
                  style={{
                    textDecoration: "none",
                  }}
                >
                  <p className="movePortfolio">더보기</p>
                </Link>
              </div>
            </div>
          ))}
        </div>
      </div>
      <div className="section4">
        <div className="title4">
          <h1>내 지역에 숨어있는 고수</h1>
        </div>

        <ul className="area_content">
          <li>
            <div className="content_user_profile"></div>
            <div className="article_box">
              <span className="people_count">0명</span>의
              <br />
              숨은 고수 찾아보기
              <br />
              <br />
              <br />
              <Link to="/categoryPortfolio">
                <button className="move_gosuporfolio_list">▷</button>
              </Link>
            </div>
          </li>

          {gosuAreaList.map((value, key) => (
            <li style={{marginRight:"25px"}}>
              <Link to="/Profile" style={style}>
                <div className="review_info">
                  <img src={stars} alt="" />
                  <span className="review_score">{value.score}</span>
                </div>
                <div className="review_profile">
                  <div className="profile_picture">{value.picture}</div>
                  <div className="review_profile_name">{value.name}</div>
                  <div className="gosu_experience">
                    경력 {value.career}년 {value.categoryName}
                  </div>
                </div>
              </Link>
            </li>
          ))}
        </ul>
      </div>

      <hr />
    </div>
  );
}

export default Main;
