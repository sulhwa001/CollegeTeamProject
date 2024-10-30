import React from "react";
import { FaCircleInfo } from "react-icons/fa6";
function ProfileCareer({ onClose }) {
  const years = [];
  for (let year = 1960; year <= 2024; year++) {
    years.push(year);
  }
  const months = [];
  for (let month = 1; month <= 12; month++) {
    months.push(month);
  }
  return (
    <div className="App">
      <div className="careerOpenBackground">
        <div className="careerOpen">
          <div className="careerBox">
            <button onClick={onClose} className="closeButton">
              X
            </button>
            <div className="career_scroll">
              <div className="career_info">
                <p>경력</p>
                <label for="input_explain" className="input_explain">
                  <br />* 필수 입력 항목입니다.
                  <div className="guide">
                    <div className="guide_icon">
                      <FaCircleInfo />
                    </div>
                    <div className="guide_span_article">
                      개인 정보 노출 및 허위 정보를 기재할 경우, 줌고
                      <br />
                      이용이 제한될 수 있으며 사안에 따라 법적 책임을
                      <br />
                      물을 수 있습니다.
                    </div>
                  </div>
                </label>
                <br />
                <h4>경력 타이틀*</h4>
                <input
                  type="text"
                  placeholder="ex) 회사명, 직함"
                  className="career_company_name"
                />
                <label for="count" className="letter_count">
                  <span className="counts">0</span> /20자
                </label>
                <br />
                <br />
                <br />
                <br />
                <h4>시작 연월*</h4>
                <select className="year_select">
                  {years.map((year) => (
                    <option key={year} value={year}>{year}</option>
                  ))}
                  <option selected>년</option>
                </select>
                <select className="month_select">
                  {months.map((month) => (
                    <option key={month} value={month}>{month}</option>
                  ))}
                  <option selected>월</option>
                </select>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default ProfileCareer;
