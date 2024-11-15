import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import "../css/profile/career.css";
import "../css/profile/profileInput.css";
import Header from "./gosu_header";
const InputField = ({ type, name, className, placeholder, onChange }) => (
  <input
    type={type}
    name={name}
    className={className}
    placeholder={placeholder}
    onChange={onChange}
  />
);
const OptionField = ({ value, onChange }) => (
  <option value={value} onChange={onChange}>
    {value}
  </option>
);
const QuestionInput = ({ question, onChange }) => (
  <div>
    <p>{question}</p>
    <InputField type="text" className="question_input" onChange={onChange} />
  </div>
);

function ProfileInput() {
  const { userNo } = useParams();
  const [member, setMember] = useState(null);
  const [error, setError] = useState(null);
  const [careerYear, setCareerYear] = useState("");
  const [schoolCareer, setSchoolCareer] = useState("");
  const [DetailExplain, setDetailExplain] = useState("");
  const [name, setName] = useState("");
  const [price, setPrice] = useState("");
  const [area, setArea] = useState("");
  const [possible, setPossibleTime] = useState("");

  const [possibleFromTime, setPossibleFromTime] = useState("");
  const [possibleUntilTime, setPossibleUntilTime] = useState("");
  const [possibleAmPm1, setPossibleAmPm1] = useState("");
  const [possibleAmPm2, setPossibleAmPm2] = useState("");
  const [fileName, setFileName] = useState("");
  const [profilePicture, setProfilePicture] = useState("");
  const [questions, setQuestions] = useState({
    question1: "",
    question2: "",
    question3: "",
    question4: "",
    question5: "",
  });

  useEffect(() => {
    const fetchMember = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/members/profile/${userNo}`
        );
        console.log(response.data);
        setMember(response.data);
      } catch (err) {
        console.log(err);
        setError(err);
      }
    };
    fetchMember();
  }, [userNo]);
  const portfolioSubmit = async (e) => {
    e.preventDefault();
    const data = {
      name: name,
      graduation: schoolCareer,
      career: careerYear,
      serviceDetail: DetailExplain,
      price: price,
      area: area,
      posssibleTime: possible,
      profilePicture: profilePicture,
      userNo: userNo,
    };

    setPossibleTime(
      possibleAmPm1 + possibleFromTime + possibleAmPm2 + possibleUntilTime
    );
    try {
      const response = await axios.post(`http://localhost:8080/gosu`, data);

      if (response.status === 200 || response.status === 303) {
        alert("데이터 삽입 완료");
      }
    } catch (error) {
      alert(error);
    }
  };
  const handleOptionChange = (e) => {
    setSchoolCareer(e.target.value);
  };
  const handlePossibleFromChange = (e) => {
    setPossibleFromTime(e.target.value);
  };
  const handlePossibleUntilChange = (e) => {
    setPossibleUntilTime(e.target.value);
  };

  const handleAmPmChoiceChange1 = (e) => {
    setPossibleAmPm1(e.target.value);
  };
  const handleAmPmChoiceChange2 = (e) => {
    setPossibleAmPm2(e.target.value);
  };
  const handleFileChange = (event) => {
    const file = event.target.files[0];
    if (file) {
      const fileType = file.type;
      if (fileType.startsWith("image/")) {
        setProfilePicture(file);
        setFileName(file.name);
      } else {
        alert("이미지 파일만 업로드할 수 있습니다.");
        setFileName("");
      }
    }
  };

  const handleQuestionChange = (index) => (e) => {
    setQuestions((prev) => ({
      ...prev,
      [`question${index}`]: e.target.value,
    }));
  };

  const handleCareerChange = (e) => {
    setCareerYear(e.target.value);
  };
  const careerYearOptions = Array.from({ length: 5 }, (_, i) => i + 1);
  const possibleHourOptions = Array.from({ length: 13 }, (_, i) => i);
  const schoolCareerList = ["고졸", "초대졸", "대졸", "석사/박사"];
  const updateName = async (e) => {
    e.preventDefault();
    const data = {
      name: name,
    };
    try {
      const response = await axios.post(
        `http://localhost:8080/gosu/updateName/${userNo}`,
        data
      );
      if (response.status === 201 || response.status === 303) {
        alert("성공");
      }
    } catch (error) {
      alert(error);
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
                {member ? (
                  <span className="gosu_name">{member.name}</span>
                ) : (
                  <span></span>
                )}
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
              <button className="update" onClick={updateName}>
                수정
              </button>
            </div>
            <div className="gosu_input">
              <InputField
                type="text"
                name="gosu_name"
                className="gosu_active_name"
                placeholder="활동명"
                onChange={(e) => {
                  setName(e.target.value);
                }}
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
                  accept="image/*"
                  style={{ display: "none" }}
                />
              </label>
            </div>
            <div className="image_name">{fileName}</div>
            <div className="gosu_active_area">
              <h3>숨고 활동지역</h3>
            </div>
            <div className="area_insert">
              <InputField
                type="text"
                name="update"
                className="gosu_active_area_name"
                placeholder="광주광역시 북구 중흥동"
                onChange={(e) => {
                  setArea(e.target.value);
                }}
              />
            </div>
            <div className="service_category">
              <h3>대표 서비스(카테고리)</h3>
            </div>
            <div className="area_insert">
              <div className="search_category">카테고리 찾기</div>
            </div>
            <div className="gosu_active_area">
              <h3>연락 가능 시간</h3>
            </div>
            <div className="area_insert">
              <select>
                <OptionField
                  value={"오후"}
                  onChange={handleAmPmChoiceChange1}
                ></OptionField>
                <OptionField
                  value={"오전"}
                  onChange={handleAmPmChoiceChange1}
                ></OptionField>
              </select>
              <select>
                {possibleHourOptions.map((time) => (
                  <option
                    key={time}
                    value={time}
                    onChange={handlePossibleFromChange}
                  >
                    {time}:00
                  </option>
                ))}
              </select>
              부터&nbsp;&nbsp;&nbsp;
              <select>
                <OptionField
                  value={"오후"}
                  onChange={handleAmPmChoiceChange2}
                ></OptionField>
                <OptionField
                  value={"오전"}
                  onChange={handleAmPmChoiceChange2}
                ></OptionField>
              </select>
              <select>
                {possibleHourOptions.map((time) => (
                  <option
                    key={time}
                    value={time}
                    onChange={handlePossibleUntilChange}
                  >
                    {time}:00
                  </option>
                ))}
              </select>
              까지
            </div>
            <div className="gosu_price">
              <h3>가격</h3>
              <div className="priceDetail">
                <label className="price_label">가격 공개&nbsp;</label>
                <input type="checkbox" value="priceCheck" />
              </div>
            </div>
            <div className="area_insert">
              <InputField
                type="text"
                name="price"
                className="price"
                placeholder="가격을 입력해주세요."
                onChange={(e) => {
                  setPrice(e.target.value);
                }}
              />
            </div>
            <div className="area_insert">
              <div className="gosu_price">
                <h3>경력</h3>
              </div>
              <select className="input_category">
                <OptionField
                  value={"1년 이하"}
                  onChange={handleCareerChange}
                ></OptionField>
                {careerYearOptions.map((year) => (
                  <OptionField
                    value={year + "년 이상"}
                    onChange={handleCareerChange}
                  ></OptionField>
                ))}
              </select>
            </div>
            <div className="area_insert">
              <div>
                <h3>상세 설명</h3>
                <textarea
                  className="detail_textArea"
                  onChange={(e) => {
                    setDetailExplain(e.target.value);
                  }}
                  placeholder="고수에 대해 상세히 설명해주세요."
                ></textarea>
              </div>
            </div>
            <div className="area_insert">
              <div>
                <h3>학력</h3>
                <div className="schoolCareer_area">
                  <select style={{ width: "300px" }}>
                    {schoolCareerList.map((school) => (
                      <OptionField
                        value={school}
                        onChange={handleOptionChange}
                      ></OptionField>
                    ))}
                  </select>
                </div>
              </div>
            </div>
            <div className="gosu_question">
              <h3>질문답변</h3>
            </div>
            <div className="question_list">
              <QuestionInput
                question="Q. 서비스가 시작되기 전 어떤 절차로 진행하나요?"
                onChange={handleQuestionChange(1)}
              />
              <QuestionInput
                question="Q. 어떤 서비스를 전문적으로 제공하나요?"
                onChange={handleQuestionChange(2)}
              />
              <QuestionInput
                question="Q. 서비스의 견적은 어떤 방식으로 산정 되나요?"
                onChange={handleQuestionChange(3)}
              />
              <QuestionInput
                question="Q. 완료한 서비스 중 대표적인 서비스는 무엇인가요? 소요 시간은 얼마나 소요 되었나요?"
                onChange={handleQuestionChange(4)}
              />
              <QuestionInput
                question="Q. A/S 또는 환불 규정은 어떻게 되나요?"
                onChange={handleQuestionChange(5)}
              />
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
                <div style={{ marginTop: "-15px" }}>
                  <button className="portfolio_button1" onClick={""}>
                    포트폴리오 등록하기
                  </button>
                </div>
              </div>
            </div>
            <footer className="portfolio_footer">
              <button
                onClick={portfolioSubmit}
                className="profile_update_Button"
              >
                수정하기
              </button>
              <button
                className="profile_move_main_button"
                onClick={() => {
                  window.location.href = "/";
                }}
              >
                취소하기
              </button>
            </footer>
          </div>
        </div>
      </section>
    </div>
  );
}

export default ProfileInput;
