import React, { useState , useEffect } from 'react';
import './Mypagemain.css';
import axios from 'axios';
import Modal from './modal';
function Mypagemain() {
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [modalContent, setModalContent] = useState('');

    const [member, setMember] = useState({});
    // const [manner, setmanner] = useState('');
    // const [email, setEmail] = useState('');
    // const [phone, setphone] = useState('');
    // const [adress, setadress] = useState('');
    // const [birthDate, setbirthDate] = useState('');
    // const [profileImage, setprofileImage] = useState('');
    // const [admin, setadmin] = useState('');
    // const [name, setname] = useState('');
    const openModal = (content) => {
        setModalContent(content);
        setIsModalOpen(true);
    }
    
    useEffect(() => {
      const token = localStorage.getItem('zoomgo-token'); // 저장된 JWT 가져오기
      if (!token) {
        alert('로그인이 필요합니다.');
        window.location.href = "/login";
        return;
      }
    
      axios.get('http://localhost:8080/api/members/getmember', {
        headers: { Authorization: `Bearer ${token}` }
      })
        .then(response => {
          console.log('서버 응답 데이터:', response.data);
          setMember(response.data);
        })
        .catch(error => {
          console.error('Axios 요청 실패:', error); // 상세 에러 출력
          if (error.response) {
            console.log('서버 응답 상태 코드:', error.response.status);
            console.log('서버 응답 데이터:', error.response.data);
          }
          if (error.response?.status === 401) {
            alert('인증 실패: 다시 로그인해주세요.');
            window.location.href = "/login";
          } else {
            alert('서버 오류가 발생했습니다. 잠시 후 다시 시도해주세요.');
          }
        });
    }, []);

    const closeModal = () => {
        setIsModalOpen(false);
    };

    const name1 = "박재찬";
    const date = "2024.01.23";
    const progress = 50; // 진행률 50%로 설정
    const name2 = "조운준";
    const date2 = "2024.01.23";
    const progress2 = 0;
  return (
    <div>
        <div className='information2'>
        <h1>마이 페이지</h1>
        </div>
<div className='grid-parent'>
    <div className='grid-container1'>
        <div className='grid-1'>
            <div className='gird-0'>
            <div className='circle-1'></div>
            <div className='legend-jaehan'>
            <label>{member.name}</label>
            </div>
            <label className='sogae'>프로필을 작성하고 자신을 소개해 주세요.</label>
            </div>
            <div className='grid-1-1'>
                            <h1 className='information'>거래정보</h1>
                            {/* 모달 호출 */}
                            <label className='label-option' onClick={() => openModal('판매 내역')}>판매 내역</label> <br />
                            <label className='label-option' onClick={() => openModal('구매 내역')}>구매 내역</label> <br />
                            <label className='label-option'></label> <br />
                            <hr className='hr-option'></hr>
                        </div>

                        <div className='grid-1-2'>
                            <h1 className='information'>내정보</h1>
                            <label className='label-option' >프로필 수정</label> <br />
                            <label className='label-option' >비밀번호 변경</label> <br />
                            <label className='label-option' >회원 탈퇴</label> <br />
                            <hr className='hr-option'></hr>
                        </div>

                        <div className='grid-1-3'>
                            <h1 className='information'>숨은고수</h1>
                            <label className='label-option' >받은 견적서</label> <br />
                            <label className='label-option' >고수 프로필 수정</label> <br />
                        </div>
                    </div>
                </div>
                 {/* Modal 컴포넌트 추가 */}
                 <Modal isOpen={isModalOpen} closeModal={closeModal} content={modalContent} />

  <div className='grid-container2'>
        <div className='grid-2'>
            <div className='grid-2-1'>
                    <table border={1}>
                <tr>
                <th>거래중</th>
                <th>거래완료</th>
                <th>거래 후기</th>
                <th>숨고 후기</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                </table>
            </div>
           <div className='grid-2-2'>
            <div className='manners-temperature'>
                <label className='lezend-ondo'>매너온도</label>
                <br />
                <label>{member.manner}°C</label>
                <br />
                <input type='range' min= '0' max = '100' name='range' step={1}></input>
                </div>
           </div>
           </div>
           <div className='grid-3'>
            <div className='grid-3-1'>
            <h1>내 상품</h1>
            <div>
      <ul className='nav-list'>
        <li className='nav-item'>전체</li>
        <li className='nav-item'>판매중</li>
        <li className='nav-item'>예약중</li>
        <li className='nav-item'>판매완료</li>
        <hr></hr>
        <div className='nav-list-label'>
        <label>최신순 </label>
        <label>낮은 가격순 </label>
        <label>높은 가격순</label>     
        </div>
      </ul>
    </div>
    <div className='total'>
    <h2>총 1 개</h2>
    </div>
    <div className='circle-nemo'>
    </div>
    <br /><br /><br />
    <div className='pageing'>
    <label className='pageing'>- 1 -</label>
    </div>
    <div className='grid-3-2'>
    <h1>내가 한 의뢰</h1>
      <ul className='nav-list'>
        <li className='tanomu-item'>전체</li>
        <li className='tanomu-item'>견적 대기중</li>
        <li className='tanomu-item'>판매완료</li>
        <hr></hr>
      </ul>
      <h2>총 1 개</h2>
      <div className="container-2">
      <div className="card-1">
        <div className="card-header">
          <h3>{name2}</h3>
          <p>{date2}</p>
        </div>
        <div className="progress-bar">
          <div className="progress" style={{ width: `${progress2}%` }}></div>
        </div>
        <div className="status">
          <span>사용자 수락</span>
          <span>견적 대기중</span>
          <span>의뢰 완료</span>
        </div>
      </div>
      <div className="card">
        <div className="card-header">
          <h3>{name1}</h3>
          <p>{date}</p>
        </div>
        <div className="progress-bar">
          <div className="progress" style={{ width: `${progress}%` }}></div>
        </div>
        <div className="status">
          <span>사용자 수락</span>
          <span>견적 대기중</span>
          <span>의뢰 완료</span>
        </div>
      </div>
      <div className="card">
        <div className="card-header">
          <h3>{name2}</h3>
          <p>{date}</p>
        </div>
        <div className="progress-bar">
          <div className="progress" style={{ width: `${progress}%` }}></div>
        </div>
        <div className="status">
          <span>사용자 수락</span>
          <span>견적 대기중</span>
          <span>의뢰 완료</span>
        </div>
      </div>
    </div>
    </div>
    </div>
    </div>
    </div>
  </div>
  </div>
  
  )
}

export default Mypagemain;
