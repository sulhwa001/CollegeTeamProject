import axios from "axios";
import { useEffect, useState } from "react";
import { MdOutlineNotificationsActive } from "react-icons/md";
import { useParams } from "react-router-dom";
import "../css/estimate/estimate.css";
import Header from "./gosu_header";
function ExportEstimate() {
  const { userNo, gosuId } = useParams();
  const [error, setError] = useState("");
  const [radio, setRadio] = useState("");
  const [textArea, setTextArea] = useState("");
  const [price, setPrice] = useState("");
  const [estimate, setEstimate] = useState(null);

  console.log(userNo, gosuId);
  useEffect(() => {
    const fetchEstimate = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/estimate/selectEstimate?userNo=${userNo}&gosuId=${gosuId}`
        );

        setEstimate(response.data);

        console.log(estimate);
      } catch (err) {
        alert(err);
        setError(err);
        console.log(err);
      }
    };
    fetchEstimate();
  }, [userNo, gosuId]);

  const sendEstimate = async () => {
    const data = {
      gosuId: gosuId,
      userNo: userNo, // 수정해야됨
      fee: price,
      feeSetting: radio,
      estimateArticle: textArea,
    };
    try {
      const response = await axios.post(`http://localhost:8080/export`, data);
      if (response.status === 200 || response.status === 303) {
        alert("견적서 보내기 완료!");
      }
    } catch (err) {
      setError(err);
      console.log(error);
    }
  };
  console.log(estimate);
  return (
    <div className="App">
      <Header />
      <div className="estimate_page_configuration">
        <aside className="estimate_aside">
          <div className="estimate_profile">
            <div className="estimate_profile_info">
              <div className="estimate_profile_img"></div>
              <div className="estimate_profile_indiinfo">
                <h3>
                  {estimate && estimate.userNo.name ? estimate.userNo.name : ""}
                </h3>
                <p>정신 건강</p>
                <p>{estimate && estimate.userNo.address}</p>
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
            <b>{estimate && estimate.date ? estimate.date : ""}</b>
            <br />
            <br />
            <br />
            <p className="gosu_detail_info_explain">지역을 선택해주세요.</p>
            <b>{estimate && estimate.address ? estimate.address : ""}</b>
            <br />
            <br />
            <br />
            <p className="gosu_detail_info_explain">
              관련 문의사항을 알려주세요.
            </p>
            <b>{estimate && estimate.question ? estimate.question : ""}</b>
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
          <input
            type="radio"
            value={"총 비용"}
            name="priceChoice"
            onChange={(e) => {
              setRadio(e.target.value);
            }}
          />{" "}
          총 비용 &emsp;&emsp;
          <input
            type="radio"
            value={"시간 당"}
            name="priceChoice"
            onChange={(e) => {
              setRadio(e.target.value);
            }}
          />{" "}
          시간 당
          <br />
          <br />
          <h3>금액</h3>
          <input
            type="text"
            className="estimate_price"
            name="price"
            onChange={(e) => {
              const newValue = e.target.value;
              if (!/^\d*$/.test(newValue)) {
                // 정규 표현식으로 숫자만 허용
                window.alert("숫자만 입력해주세요.");
              } else {
                setPrice(newValue);
              }
            }}
          />
          <br />
          <br />
          <br />
          <h3>견적 설정</h3>
          <br />
          <textarea
            className="estimate_explain"
            onChange={(e) => {
              setTextArea(e.target.value);
            }}
            placeholder="요청사항에 대한 답변, 서비스 진행방식, 고수님만의 강점이나 특징 등을 작성하세요."
          ></textarea>
          <br />
          <label for="estimate_explain_count" style={{ float: "right" }}>
            <span style={{ color: "blue" }}>{textArea.length}</span>/1000자
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
            <button onClick={sendEstimate} className="estimate_click">
              보내기
            </button>
          </div>
          <br />
        </div>
      </div>
    </div>
  );
}

export default ExportEstimate;
