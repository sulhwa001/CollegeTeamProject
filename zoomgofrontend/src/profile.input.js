import { useState } from "react";
import "./css/profile/career.css";
import "./css/profile/profileInput.css";
import Header from "./header";
function ProfileInput() {
  const [fileName, setFileName] = useState("");

  const handleFileChange = (event) => {
    const file = event.target.files[0];
    if (file) {
      // 이미지 파일인지 확인
      const fileType = file.type;
      if (fileType.startsWith("image/")) {
        setFileName(file.name);
      } else {
        alert("이미지 파일만 업로드할 수 있습니다.");
        setFileName(""); // 잘못된 파일 선택 시 파일 이름 초기화
      }
    }
  };

  return (
    <div className="App">
      <Header />
      <section className="section_profile_input">
        <div className="profile_section1">
          <div className="profiles">
            <div className="name_picture">
              <div className="gosu_profile_picture"></div>
              <div className="gosuInfo">
                <span className="gosu_name">조은준</span>
                <br />
                <span className="gosu_review_score">
                  리뷰 평점 0&emsp;&emsp;
                </span>
                <span className="review_count">리뷰 수 0</span>
                <button className="gosu_preview">미리보기</button>
              </div>
            </div>
          </div>
          <div className="gosu_profile_detail">
            <div className="gosu_active_name">
              <h3>고수 활동명</h3>
              <button className="update">수정</button>
            </div>
            <div className="gosu_input">
              <input
                type="text"
                name="gosu_name"
                className="gosu_active_name"
                placeholder="활동명"
              />
            </div>
            <div className="gosu_picture_upload">
              <h3>숨고 프로필 사진</h3>
              <label className="upload_btn">
                이미지 첨부
                <input
                  type="file"
                  name="upload"
                  className="picture_upload_btn"
                  onChange={handleFileChange}
                  accept="image/*" // 이미지 파일만 허용
                  style={{ display: "none" }}
                  placeholder="업로드"
                />
              </label>
            </div>
            <div className="image_name">{fileName}</div>
            <div className="gosu_active_area">
              <h3>숨고 활동지역</h3>
              <button className="update1">수정</button>
            </div>
            <div className="area_insert">
              <input
                type="text"
                name="update"
                className="gosu_active_area_name"
                placeholder="광주광역시 북구 중흥동"
              />
            </div>
            <div className="service_category">
              <h3>대표 서비스(카테고리)</h3>
              <button className="update2">수정</button>
            </div>
            <div className="input_category">
              <div className="search_category">카테고리 찾기</div>
            </div>
            <div className="gosu_active_area">
              <h3>연락 가능 시간</h3>
              <button className="update3">수정</button>
            </div>
            <div className="area_insert">
              <select>
                <option>오전 12:00</option>
                <option>오전 1:00</option>
                <option selected>오전 2:00</option>
                <option>오전 3:00</option>
                <option>오전 4:00</option>
                <option>오전 5:00</option>
                <option>오전 6:00</option>
                <option>오전 7:00</option>
                <option>오전 8:00</option>
                <option>오전 9:00</option>
                <option>오전 10:00</option>
                <option>오전 11:00</option>
                <option>오후 1:00</option>
                <option>오후 2:00</option>
                <option>오후 3:00</option>
                <option>오후 4:00</option>
                <option>오후 5:00</option>
                <option>오후 6:00</option>
                <option>오후 7:00</option>
                <option>오후 8:00</option>
                <option>오후 9:00</option>
                <option>오후 10:00</option>
                <option>오후 11:00</option>
                <option>오후 12:00</option>
              </select>
              부터
              <select>
                <option>오전 12:00</option>
                <option>오전 1:00</option>
                <option>오전 2:00</option>
                <option>오전 3:00</option>
                <option>오전 4:00</option>
                <option>오전 5:00</option>
                <option>오전 6:00</option>
                <option selected>오전 7:00</option>
                <option>오전 8:00</option>
                <option>오전 9:00</option>
                <option>오전 10:00</option>
                <option>오전 11:00</option>
                <option>오후 1:00</option>
                <option>오후 2:00</option>
                <option>오후 3:00</option>
                <option>오후 4:00</option>
                <option>오후 5:00</option>
                <option>오후 6:00</option>
                <option>오후 7:00</option>
                <option>오후 8:00</option>
                <option>오후 9:00</option>
                <option>오후 10:00</option>
                <option>오후 11:00</option>
                <option>오후 12:00</option>
              </select>
              까지
            </div>
            <div className="gosu_price">
              <h3>가격</h3>
              <label className="price_label">가격 공개&nbsp;</label>
              <input type="checkbox" value="시간" />
              &nbsp;<button>수정</button>
            </div>
            <div className="input_category">
              <input
                type="text"
                name="price"
                className="price"
                placeholder="가격을 입력해주세요."
              />
            </div>

            <div className="gosu_price">
              <h3>경력</h3>

              <button className="gosu_price_update" >
                수정
              </button>
            </div>
            <div className="input_category">
              <input
                type="text"
                name="price"
                className="price"
                placeholder="경력을 입력해주세요."
              />
            </div>

            <div className="gosu_question">
              <h3>질문답변</h3>
              <button className="question_update">수정</button>
            </div>
            <div className="question_list">
              <p>Q. 서비스가 시작되기 전 어떤 절차로 진행하나요?</p>
              <input type="text" name="question1" className="question_input" />
              <p>Q. 어떤 서비스를 전문적으로 제공하나요?</p>
              <input type="text" name="question2" className="question_input" />
              <p>Q. 서비스의 견적은 어떤 방식으로 산정 되나요?</p>
              <input type="text" name="question3" className="question_input" />
              <p>
                Q. 완료한 서비스 중 대표적인 서비스는 무엇인가요? 소요 시간은
                얼마나 소요 되었나요?
              </p>
              <input type="text" name="question4" className="question_input" />
              <p>Q. A/S 또는 환불 규정은 어떻게 되나요?</p>
              <input type="text" name="question5" className="question_input" />
            </div>
            <div className="portfolio_move">
              <h3>포트폴리오</h3>
              <div className="portfolio_explain_move">
                <h3>고수님의 멋진 작업물을 보여주세요</h3>
                <h3 className="detail_explain">
                  작업 사진과 과정을 포함한 포트폴리오를
                  <br />
                  등록할 경우 고수님을 선택할 확률이 높아집니다.
                </h3>
                <button>포트폴리오 등록하기</button>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  );
}

export default ProfileInput;
