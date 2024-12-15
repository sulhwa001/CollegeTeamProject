import React, { useState } from "react";
import "./css/admin.css";
import Header from "./Header";
const AdminPage = () => {
  const [searchTerm, setSearchTerm] = useState("");
  const [members, setMembers] = useState([
    { id: 1, name: "홍길동 (rifhedh1)", joined: "1분 전 가입" },
    { id: 2, name: "홍길동 (rifhedh1)", joined: "1분 전 가입" },
    { id: 3, name: "홍길동 (rifhedh1)", joined: "1분 전 가입" },
    { id: 4, name: "홍길동 (rifhedh1)", joined: "1분 전 가입" },
    { id: 5, name: "홍길동 (rifhedh1)", joined: "1분 전 가입" },
    { id: 6, name: "홍길동 (rifhedh1)", joined: "1분 전 가입" },
    { id: 7, name: "홍길동 (rifhedh1)", joined: "1분 전 가입" },
    { id: 8, name: "홍길동 (rifhedh1)", joined: "1분 전 가입" },
    { id: 9, name: "홍길동 (rifhedh1)", joined: "1분 전 가입" },
    // 추가 회원 정보는 여기에 추가
  ]);

  const handleSearchChange = (e) => {
    setSearchTerm(e.target.value);
  };

  const banMember = (id) => {
    // 사용자 강퇴 로직 추가
    console.log(`강퇴: ${id}`);
  };

  return (
    <div>
      <Header />

      <main className="main-content">
        <div className="search-bar">
          <h2 className="thin-text">관리자페이지 &gt; 회원관리</h2>
          <input
            type="text"
            placeholder="찾으시는 회원의 아이디나 닉네임을 검색해 주세요"
            value={searchTerm}
            onChange={handleSearchChange}
          />
        </div>

        <div className="menu-container">
          <div className="menu-item active">회원관리</div>
          <div className="menu-item">글 관리</div>
        </div>

        <table className="member-list">
          <thead>
            <tr>
              <th>회원명</th>
              <th>가입 시간</th>
              <th>관리</th>
            </tr>
          </thead>
          <tbody>
            {members.map((member) => (
              <tr key={member.id}>
                <td>{member.name}</td>
                <td>{member.joined}</td>
                <td>
                  <button
                    className="ban-btn"
                    onClick={() => banMember(member.id)}
                  >
                    강퇴
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <div className="pagination">
          <button className="active">1</button>
          <button>2</button>
          <button>3</button>
          <button>4</button>
          <button>5</button>
          <button>6</button>
        </div>
      </main>
    </div>
  );
};

export default AdminPage;
