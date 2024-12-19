import axios from "axios";
import { useEffect, useState } from "react";
import { MdOutlineNotificationsActive } from "react-icons/md";
import { useParams } from "react-router-dom";
import "../css/estimate/estimate.css";
import Header from "./gosu_header";
function AskEstimate() {
  const { gosuId } = useParams();
  console.log(gosuId);
  const [error, setError] = useState("");
  const [textArea, setTextArea] = useState("");
  const [gosu, setGosu] = useState(null);
  const [area, setArea] = useState("");
  const [date, setDate] = useState(
    new Date().toLocaleDateString("ko-KR", {
      year: "2-digit",
      month: "2-digit",
      day: "2-digit",
    })
  );
  useEffect(() => {
    const fetchGosu = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/gosu/gosuProfile/${gosuId}`
        );
        setGosu(response.data);
      } catch (e) {
        setError(e);
        console.log(error);
      }
    };
    fetchGosu();
  }, [gosuId]);
  const askEstimateButton = async () => {
    const data = {
      gosuId: gosuId,
      userNo: 2,
      address: area,
      question: textArea,
      date: date,
    };
    try {
      const response = await axios.post(`http://localhost:8080/estimate`, data);
      if (response.status === 200 || response.status === 303) {
        window.alert("견적서 요청 완료");
      }
    } catch (err) {
      console.log(err);
      window.alert(err);
    }
  };

  const calendar = [];
  const today = new Date();
  const timestamp = today.getTime();
  for (let i = 0; i < 10; i++) {
    const dateFromTimestamp = new Date(timestamp + i * 24 * 60 * 60 * 1000); // 하루씩 더하기
    calendar.push(
      dateFromTimestamp.toLocaleDateString("ko-KR", {
        year: "2-digit",
        month: "2-digit",
        day: "2-digit",
      })
    );
  }

  return (
    <div className="App">
      <Header />
      <div className="estimate_page_configuration">
        <aside className="estimate_aside">
          <div className="estimate_profile">
            <div className="estimate_profile_info">
              <div className="estimate_profile_img"></div>
              <div className="estimate_profile_indiinfo">
                <h3>{gosu && gosu.name ? gosu.name : ""}</h3>
                <p>정신 건강</p>
                <p>{gosu && gosu.user ? gosu.user.address : ""}</p>
              </div>
              <div
                style={{
                  float: "right",
                  marginLeft: "30px",
                  fontSize: "30px",
                }}
              >
                <MdOutlineNotificationsActive />
              </div>
            </div>
            <button className="detail_profile_info">상세 정보 보기</button>
          </div>
          <p className="profile_label" style={{ height: "15px" }}></p>
          <div className="estimate_detail_profile_info">
            <p style={{ textAlign: "center" }}>
              견적을 빨리 보낼수록 고용에 유리해요!
            </p>
          </div>
        </aside>
        <div className="page_Interval"></div>
        <div>
          <br />
          <br />
          <br />
          <h1>견적 요청 보내기</h1>
          <br />
          <br />
          <h3>원하는 지역</h3>
          <br />
          <input
            type="text"
            className="area_choice_input"
            onChange={(e) => {
              setArea(e.target.value);
            }}
          />
          <br />
          <br />
          <br />
          <h3>희망 날짜</h3>
          <select
            className="ask_estimate_calendar"
            value={calendar}
            onChange={(e) => {
              setDate(e.target.value);
            }}
          >
            {calendar.map((cal) => (
              <option>{cal}</option>
            ))}
          </select>
          <br />
          <br />
          <br />
          <h3>관련 문의 사항</h3>
          <br />
          <textarea
            onChange={(e) => {
              setTextArea(e.target.value);
            }}
            className="estimate_explain"
            placeholder=" 고수에게 요청 사항을 적어주세요. 
            고수에게 배우고 싶은 것을 입력하세요."
          ></textarea>
          <br />
          <label for="estimate_explain_count" style={{ float: "right" }}>
            <span style={{ color: "blue" }}>{0}</span>/1000자
          </label>
          <br />
          <br />
          <h3>파일 첨부</h3>
          <br />
          <label style={{ cursor: "pointer", width: "100px", float: "left" }}>
            <div className="estimate_file">
              <input type="file" accept="image/*" />
            </div>
          </label>
          <div style={{ marginTop: "120px" }}>
            <button onClick={askEstimateButton} className="estimate_click">
              등록하기
            </button>
          </div>
          <br />
          <br />
        </div>
      </div>
    </div>
  );
}

export default AskEstimate;
