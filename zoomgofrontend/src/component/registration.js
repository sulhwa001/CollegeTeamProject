import React from 'react';
import './css/registration.css';
// import { useNavigate } from 'react-router-dom';
// import icon1 from './icon/icon1.png';
// import list from './icon/listicon.png';
import Header from './Header.js';

function RegistrationPage() {

    return (
        <div>
            <Header />
            <main className="main-content">
                <form>
                    {/* 상품명 입력 */}
                    <div className="input-group">
                        <input type="text" id="name" placeholder="상품명" />
                    </div>

                    {/* 상품 카테고리 선택 */}
                    <div className="custom-select">
                        <ul className="select-items">
                            <li>전자제품</li>
                            <li>패션의류</li>
                            <li>가구</li>
                            <li>도서/문구</li>
                            <li>기타</li>
                        </ul>
                    </div>

                    {/* 상태 선택 */}
                    <div className="custom-select">
                        <ul className="select-items">
                            <li>중고</li>
                            <li>미사용</li>
                            <li>거의새것</li>
                        </ul>
                    </div>

                    {/* 위치 입력 */}
                    <div className="input-group">
                        <input type="text" id="location" placeholder="거래장소를 입력 해 주세요." />
                    </div>

                    {/* 가격 입력 */}
                    <div className="input-group">
                        <input type="text" id="price" placeholder="가격" />
                    </div>

                    {/* 설명 입력 */}
                    <div className="input-group">
                        <textarea id="description" rows="4" placeholder="상품설명"></textarea>
                    </div>

                    {/* 제출 버튼 */}
                    <button type="submit" className="submit-btn">등록하기</button>
                </form>
            </main>
        </div>
    );
}

export default RegistrationPage;
