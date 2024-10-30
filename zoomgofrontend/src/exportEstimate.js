import { MdOutlineNotificationsActive } from "react-icons/md";
import "./css/estimate/estimate.css";
import Header from "./header";
function ExportEstimate() {
  return (
    <div className="App">
      <Header />
      <div className="estimate_page_configuration">
        <aside className="estimate_aside">
          <div className="estimate_profile">
            <div className="estimate_profile_info">
              <div className="estimate_profile_img"></div>
              <div className="estimate_profile_indiinfo">
                <h3>박재찬</h3>
                <p>정신 건강</p>
                <p>중국 베이징시 텐진</p>
              </div>
              <div
                style={{
                  float: "right",
                  marginLeft: "60px",
                  fontSize: "30px",
                }}
              >
                <MdOutlineNotificationsActive />
              </div>
            </div>
            <button className="detail_profile_info">상세 정보 보기</button>
          </div>
          <p className="profile_label">견적을 빨리 보낼수록 고용에 유리해요!</p>
          <div className="estimate_detail_profile_info">
            <br />
            <br />
            <p className="gosu_detail_info_explain">
              희망 서비스일을 선택해주세요.
            </p>
            <b>협의 가능해요.</b>
            <br />
            <br />
            <br />
            <p className="gosu_detail_info_explain">지역을 선택해주세요.</p>
            <b>중국 베이징시 텐진</b>
            <br />
            <br />
            <br />
            <p className="gosu_detail_info_explain">
              관련 문의사항을 알려주세요.
            </p>
            <b>고수와 상담 시 논의할게요.</b>
            <br />
            <br />
            <br />
            <p className="gosu_detail_info_explain">파일 첨부</p>
          </div>
        </aside>
        <div className="page_Interval"></div>
        <div>
          <br />
          <br />
          <br />
          <h1>견적보내기</h1>
          <br />
          <br />
          <h3>금액 설정</h3>
          <br />
          <input type="radio" /> 총 비용 &emsp;&emsp;
          <input type="radio" /> 시간 당
          <br />
          <br />
          <h3>금액</h3>
          <input type="text" className="estimate_price" name="price" />
          <br />
          <br />
          <br />
          <h3>견적 설정</h3>
          <br />
          <textarea
            className="estimate_explain"
            placeholder="요청사항에 대한 답변, 서비스 진행방식, 고수님만의 강점이나 특징 등을 작성하세요."
          ></textarea>
          <br />
          <label for="estimate_explain_count" style={{ float: "right" }}>
            <span style={{ color: "blue" }}>{0}</span>/1000자
          </label>
          <br />
          <br />
          <h3>파일 첨부</h3>
          <br />
          <label style={{cursor:"pointer", width:"100px", float:"left"}}>
            <div className="estimate_file">
              <input type="file" accept="image/*" />
            </div>
                  </label>
                  <div style={{ marginTop:"120px"}}>
            <button onClick={""} className="estimate_click">
              등록하기
            </button>
          </div>
        <br />
              </div>
      </div>
    </div>
  );
}

export default ExportEstimate;
