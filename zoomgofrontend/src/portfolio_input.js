import "./css/portfolio/portfolio_input.css";
import Header from "./header";
function InputPortfolio() {
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
        <p>도어 시공</p>
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
          />
          <label className="portfolio_title_count">{0}/30자</label>
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
          <input type="file" />
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
            <input type="file" />
          </label>
          <label className="portfolio_detail_image">
            <input type="file" />
          </label>
          <label className="portfolio_detail_image">
            <input type="file" />
          </label>
          <label className="portfolio_detail_image">
            <input type="file" />
          </label>
        </div>
        <br />
        <br />
        <h3>상세 정보</h3>
        <br />
        <br />
        <h4>최종 금액</h4>
        <input type="text" placeholder="최종금액을 입력해주세요." className="final_price" />
        <span className="won">원</span>
      </div>
    </div>
  );
}

export default InputPortfolio;
