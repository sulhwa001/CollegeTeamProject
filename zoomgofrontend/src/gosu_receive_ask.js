import "./css/gosu_receive_ask/gosu_receive_ask.css";
import Header from "./header";

function ReceiveAsk() {
  const infoList = [
    { name: "조은준", calendar: "2014.07.23" },
    { name: "김철수", calendar: "2015.08.12" },
    { name: "이영희", calendar: "2016.09.03" },
    { name: "박민수", calendar: "2017.10.05" },
    { name: "최정우", calendar: "2018.11.07" },
    { name: "송지훈", calendar: "2019.12.09" },
  ];

  const groupInfoList = [];
  for (let i = 0; i < infoList.length; i += 2) {
    groupInfoList.push(infoList.slice(i, i + 2));
  }
  return (
    <div className="App">
      <Header />
      <div className="gosu_receive_ask_section">
        <div className="receiveBox">
          <h2>받은 요청</h2>
          <div className="receiveList">
                      {groupInfoList.map((group, index) => (
                
              <div key={index} >
                {group.map((info, idx) => (
                  <div key={idx} className="askBox" style={{marginTop:"20px"}}>
                    <h3>{info.name}</h3>
                    <span style={{ color: "#B6B1B1", fontSize: "12px" }}>
                      {info.calendar}
                    </span>
                    <br />
                    <br />
                    <progress
                      className="progress_bar"
                      value="100"
                      max="100"
                    ></progress>

                    <div className="progress_state">
                      <label>매칭</label>
                      <label>진행중</label>
                      <label>완료</label>
                    </div>
                    <div className="progress_state_article">
                      <div
                        style={{
                          width: "25px",
                          background: "gray",
                          height: "25px",
                          borderRadius: "25px",
                        }}
                      ></div>
                      <span style={{ fontSize: "12px", marginLeft: "8px" }}>
                        {"유저와 작업을 끝마쳤어요. 고생하셨습니다!"}
                      </span>
                    </div>
                    <div className="buttonList">
                      <button className="chatting">채팅하기</button>
                      <button className="move_write_review">리뷰 작성</button>
                    </div>
                  </div>
                ))}
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default ReceiveAsk;
