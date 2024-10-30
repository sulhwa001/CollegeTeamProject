import React, { useState } from 'react';
import '../App.js'
import './agreement.css';

function Agreement() {
  // 체크박스 상태 관리
  const [allAgree, setAllAgree] = useState(false);
  const [terms, setTerms] = useState(false);
  const [data, setData] = useState(false);
  const [marketing, setMarketing] = useState(false);

  // '모두 동의' 체크박스를 클릭했을 때 모든 개별 체크박스 상태를 변경
  const handleAllAgree = (e) => {
    const checked = e.target.checked;
    setAllAgree(checked);
    setTerms(checked);
    setData(checked);
    setMarketing(checked);
  };

  // 개별 체크박스를 클릭했을 때 상태를 업데이트하고, 모두 선택되면 '모두 동의'도 체크
  const handleIndividualCheck = (e, setState) => {
    setState(e.target.checked);
  };

  // 개별 체크박스가 모두 선택되었는지 확인
  React.useEffect(() => {
    if (terms && data && marketing) {
      setAllAgree(true);
    } else {
      setAllAgree(false);
    }
  }, [terms, data, marketing]);

  // 회원가입 완료 버튼 클릭 시
  const completeSignup = () => {
    if (!terms || !data) {
      alert('필수 약관에 모두 동의해야 합니다.');
    } else {
      alert('회원가입이 완료되었습니다.');
      // 여기서 실제 회원가입 로직을 추가하세요.
    }
  };

  return (
    <div className='board-aa'>
    <div className="agreement-container">
      <h1 className="agreement-title">ZOOMGO</h1>
      <p className="agreement-subtitle">ZOOMGO서비스 약관에 동의해주세요.</p>

      <div className="agreement-checkbox-group">
        <div className="checkbox-item">
          <input type="checkbox" id="all-agree" checked={allAgree} onChange={handleAllAgree} />
          <label htmlFor="all-agree">모두 동의합니다.</label>
        </div>
        <p className="agreement-description">
          전체 동의는 필수/선택정보에 대한 정보가 포함되어 있으며, 개별적으로 동의하실 수 있습니다.
        </p>

        <div className="checkbox-item">
          <input
            type="checkbox"
            className="individual-check"
            checked={terms}
            onChange={(e) => handleIndividualCheck(e, setTerms)}
          />
          <label>[필수] ZOOMGO 계정 약관</label>
        </div>

        <div className="checkbox-item">
          <input
            type="checkbox"
            className="individual-check"
            checked={data}
            onChange={(e) => handleIndividualCheck(e, setData)}
          />
          <label>[필수] 필수정보 수집 및 이용 동의</label>
        </div>

        <div className="checkbox-item">
          <input
            type="checkbox"
            className="individual-check"
            checked={marketing}
            onChange={(e) => handleIndividualCheck(e, setMarketing)}
          />
          <label>[선택] 광고/이벤트 이메일 수신 동의</label>
        </div>
      </div>

      <button className="complete-button" onClick={completeSignup}>
        회원가입 완료
      </button>
    </div>
    </div>
  );
}

export default Agreement;
