import axios from "axios";
import { useEffect, useState } from "react";
import "../css/portfolio/portfolio_input.css";
import Header from "./gosu_header";
function InputPortfolio() {
  const [gosu, setGosu] = useState(null);

  useEffect(() => {
    const token = localStorage.getItem("zoomgo-token"); // 저장된 JWT 가져오기
    console.log(token)
    const fetchGosu = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/gosu/selectGosuId`,
          {
            headers: { Authorization: `Bearer ${token}` },
          }
        );
        setGosu(response.data || {}); // 데이터가 없을 경우 빈 객체로 초기화\
      } catch (err) {
        console.log(err);
      }
    };
    fetchGosu();
  }, []); // 의존성 배열에 gosuId 추가
  const [title, setTitle] = useState("");
  const [textCount, setTextCount] = useState("");
  const [price, setPrice] = useState(0);
  const [portfolioYear, setPortfolioYear] = useState(2000);
  const [portfolioTime, setPortfolioTime] = useState(0);
  const [portfolioTimeList, setPortfolioTimeList] = useState("시간");
  const [area, setArea] = useState("");
  const [detailImage, setDetailImage] = useState({
    pic1: "",
    pic2: "",
    pic3: "",
    pic4: "",
  });
  const [mainImage, setMainImage] = useState("");
  const portfolioSubmit = async (e) => {
    e.preventDefault();
    const workTime = `${portfolioTime}${portfolioTimeList}`;
    const data = {
      gosuId: gosu.gosuId,
      userNo: gosu.userNo,
      title: title,
      price: price,
      area: area,
      year: portfolioYear,
      workTime: workTime,
      workArticle: textCount,
      mainImage: mainImage,
      detailImage: detailImage,
    };
    try {
      const response = await axios.post(
        `http://localhost:8080/portfolio`,
        data
      );
      if (response.status === 200 || response.status === 303) {
        alert("포트폴리오 생성 완료");
      }

      console.log(response);
    } catch (err) {
      alert(err);
      console.log(err);
    }
  };
  console.log(title);
  console.log(portfolioTime, portfolioTimeList);
  const handleDetailImageChange = (index) => (e) => {
    setDetailImage((prev) => ({
      ...prev,
      [`pic${index}`]: e.target.value,
    }));
  };

  const gosuInputPortfolio = {
    categoryName: "도어 시공",
  };
  const years = [];

  for (let i = 2000; i < 2025; i++) {
    years.push(i);
  }

  return (
    <div className="App">
      <Header />
      <div className="portfolio_input_section">
        <br />
        <br />
        <br />
        <h2 className="portfolio_input_h2">포트폴리오 등록</h2>
        <br />
        <br />
        <h3>필수 정보*</h3>
        <br />
        <br />
        <br />
        <h4>서비스 종류</h4>
        <br />
        <p>{gosuInputPortfolio.categoryName}</p>
        <br />
        <br />
        <br />
        <h3>포트폴리오 제목</h3>
        <br />
        <div>
          <input
            type="text"
            placeholder="포트폴리오 제목을 입력해주세요"
            name="portfolio_title"
            className="portfolio_title"
            minLength={1}
            maxLength={30}
            onChange={(e) => {
              setTitle(e.target.value);
            }}
          />
          <label className="portfolio_title_count">{title.length}/30자</label>
        </div>
        <br />
        <br />
        <br />
        <div>
          <h3>대표 이미지 등록</h3>
          <br />
          <div className="image_guide">
            이미지는 가로, 세로 600px 이상 1:1 비율로 권장합니다.
          </div>
        </div>
        <label className="portfolio_main_image">
          <span className="click1">클릭</span>
          <input
            type="file"
            onChange={(e) => {
              setMainImage(e.target.value);
            }}
          />
        </label>
        <br />
        <h3>상세이미지 등록(1개 필수, 최대 4개)</h3>
        <br />
        <div className="image_guide2">
          최대 4MB의 JPG, PNG 이미지 파일을 업로드할 수 있습니다. (이미지 사이즈
          가로, 세로 최소
          <br />
          600px / 최대 5000px)
        </div>
        <div style={{ width: "710px", display: "flex" }}>
          <label className="portfolio_detail_image">
            <span className="click2">클릭</span>
            <input type="file" />
          </label>
          <label className="portfolio_detail_image">
            <input type="file" onChange={handleDetailImageChange(1)} />
          </label>
          <label className="portfolio_detail_image">
            <input type="file" onChange={handleDetailImageChange(2)} />
          </label>
          <label className="portfolio_detail_image">
            <input type="file" onChange={handleDetailImageChange(3)} />
          </label>
          <label className="portfolio_detail_image">
            <input type="file" onChange={handleDetailImageChange(4)} />
          </label>
        </div>
        <br />
        <br />
        <h3>상세 정보</h3>
        <h4>활동 지역</h4>
        <input
          type="text"
          placeholder="활동 지역 입력"
          className="final_price"
          onChange={(e) => {
            setArea(e.target.value);
          }}
        />
        <br />
        <br />
        <h4>최종 금액</h4>
        <input
          type="text"
          placeholder="최종금액을 입력해주세요."
          className="final_price"
          minLength={1}
          maxLength={10}
          onChange={(e) => {
            setPrice(e.target.value);
          }}
        />
        <span className="won">원</span>
        <br />
        <div
          style={{
            width: "450px",
            display: "flex",
            justifyContent: "space-between",
          }}
        >
          <h4>작업 연도</h4>
          <h4>작업 소요시간</h4>
        </div>
        <div style={{ display: "flex", width: "730px" }}>
          <select
            className="workYears"
            onChange={(e) => {
              setPortfolioYear(e.target.value);
            }}
          >
            {years.map((year) => (
              <option key={year} value={year}>
                {year}
              </option>
            ))}
          </select>
          <div style={{ marginLeft: "50px", display: "flex" }}>
            <input
              type="text"
              placeholder="소요 시간"
              name="portfolio_time"
              className="portfolio_time"
              minLength={1}
              maxLength={3}
              onChange={(e) => {
                setPortfolioTime(e.target.value);
              }}
            />
            <select
              className="choice_month_day_hour"
              onChange={(e) => {
                setPortfolioTimeList(e.target.value);
              }}
            >
              <option value="시간">시간</option>
              <option value="일">일</option>
              <option value="월">월</option>
            </select>
          </div>
        </div>
        <br />
        <h4>작업 내용</h4>
        <textarea
          className="work_article"
          placeholder="제공한 서비스의 상세한 설명을 작성해주세요.
         ex)전/후 결과, 작업 과정 등"
          minLength={1}
          maxLength={200}
          onChange={(e) => {
            setTextCount(e.target.value);
          }}
        ></textarea>
        <div className="count">
          <label for="textarea_count" className="textarea_count">
            {textCount.length}/200자
          </label>
        </div>
        <br />
        <br />
        <button className="portfolio_button" onClick={portfolioSubmit}>
          등록하기
        </button>
      </div>
    </div>
  );
}

export default InputPortfolio;
