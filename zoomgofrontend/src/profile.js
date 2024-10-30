import Header from './header'
import './css/profile/top.css'
import './css/profile/middle.css'

import { FaStar } from "react-icons/fa";
function Portfolio() {
    return (
        <div className="App">
            <Header />
            <div className="null"></div>
            <section className="top">
                <div className="sort">
                    <div className="gosu_portfolio_picture_box">
                        <div className="gosu_portfolio_picture">
                            <span>사진</span>
                        </div>
                    </div>
                    <div className="estimate_box">
                        <div className="estimate_move">
                            <p>손순화 고수에게 원하는 서비스의 견
                                <br />적을 받아보세요
                            </p><button>견적 요청</button>
                        </div>
                    </div>
                </div>
                <div className="gosu_portfolio_profile_detail">
                    <h3>&nbsp;&nbsp;손순화</h3>
                    <div style={{ display: "flex", alignItems: "center" }}>
                        <p>&nbsp;&nbsp;외주</p>
                        <p style={{ color: "#d8d7d7", fontSize: "14px" }}>&nbsp;&nbsp;전남 장성읍</p>
                    </div>
                    <p>&nbsp;&nbsp;손순화 고수의 상페이지 제작 서비스</p>
                </div>
                <div className="review_worktime">
                    <div className="review_left">
                        <span style={{ color: "gray" }}>리뷰</span><br />
                        <FaStar style={{ marginTop: "1px" }} color='orange' />&nbsp;
                        <span style={{ fontWeight: "bold" }}>4.5</span>
                    </div>
                    <div className="review_right">
                        <span style={{ color: "gray" }}>총 경력</span><br></br>
                        <span style={{ fontWeight: "bold" }}>9년</span>
                    </div>
                </div>
            </section>
            <section className="middle">
                <div className="gosu_info">
                    <div className="gosu_info_list">
                        <a href="#gosu_information">고수 정보</a>
                        <a href="#portfolio_h3">포트폴리오</a>
                        <a href="">사진/동영상</a>
                        <a href="">리뷰</a>
                        <a href="">질문답변</a>
                        <a href="">커뮤니티</a>
                    </div>
                    <div style={{ height: "120px" }}>
                    </div>
                    <div className="gosu_information" id="gosu_information">
                        <h3>고수 정보</h3>
                        <br />
                        <br />
                        <p>&emsp;연락 가능 시간 : 오전 12시 - 오후 11시</p><br />
                        <p>&emsp;계좌이체, 현금결제 가능</p>
                        <br />
                        <br />
                        <br />
                        <h3>서비스 상세설명</h3><br />
                        <p>&emsp;테스트 설명</p>
                        <br />
                        <br />
                        <h3>경력</h3>
                        <br />
                        <h4 style={{ color: "#6788FF", fontSize: "20px" }}>&emsp;총 경력 2년</h4>
                        <span>&emsp;온라인 광고 및 교육</span>
                        <br />
                        <span style={{ fontSize: "12px", color: "gray" }}>&nbsp;&emsp;2021년 1월 ~ 현재 3년 5개월</span>
                        <br />
                        <span style={{ fontSize: "11px", color: "gray" }}>&nbsp;&emsp;경력 란은 여기다가 입력해주세요.</span>
                        <br /><br />
                        <h3>학력</h3><br />
                        <p style={{ color: "black" }}>&emsp;대졸</p>
                        <span style={{ color: "gray" }}>&emsp;2003년 3월 ~ 2011년 2월</span>
                        <br />
                        <span style={{ color: "#EAEAEA" }}>&emsp;학력 입력</span>
                        <br /><br /><br />
                        <div className="line"></div>
                        <br /><br />
                        <div>
                            <h3 id = "portfolio_h3">포트폴리오</h3>
                            <div style={{ display: "flex", width: "650px" }}>
                                <div className="portfolio_picture_list"></div>
                                <div className="portfolio_picture_list"></div>
                                <div className="portfolio_picture_list"></div>
                            </div>
                            <div className="line"></div>
                            <div>
                                <br />
                                <br />
                                <br />
                                <h3>리뷰</h3>
                                <br />
                                <div style={{ display: "flex", alignItems: "center" }}>
                                    <span className="profile_review_score">5.0</span>
                                    <div>
                                        <FaStar color="orange" style={{ marginLeft: "20px" }} />
                                        <FaStar color="orange" style={{ marginLeft: "10px" }} />
                                        <FaStar color="orange" style={{ marginLeft: "10px" }} />
                                        <FaStar color="orange" style={{ marginLeft: "10px" }} />
                                        <FaStar color="orange" style={{ marginLeft: "10px" }} />
                                        <br></br><span>&emsp;&nbsp;1개 리뷰</span>
                                    </div>
                                </div>
                                <div className="line2"></div>
                                <br />
                                <div className="profile_reivew">
                                    <div className="picture_review"></div>&emsp;
                                    <label for="picture_explain">사진 리뷰</label>
                                    &emsp;&emsp;&emsp;
                                    <div className="picture_review"></div>&emsp;
                                    <label for="picture_explain">사진 리뷰</label>
                                    <div className="up-to-date">
                                        <span style={{ fontSize: "18px" }}>최신순&nbsp;&nbsp;↓</span>
                                    </div>
                                </div><br />
                                <div className="reviewArticle">
                                    <label>최**</label>
                                    <span className="zoomgo_proof">줌고가 보증하는 거래입니다.</span>
                                </div><br />
                                <span className="profile_review_category">수영 레슨</span>
                                &emsp;<FaStar color="orange" />
                                <span className="profile_detail_review_score">&nbsp;5.0</span>
                                <div className="review_article_detail">
                                    <br />
                                    개인적으로 비용 문제가 있어서 뭐시기 저시기
                                </div>
                                <ul className="detail_review">
                                    <li>자세하게 알려줘요</li>
                                    <li>자세하게 알려줘요</li>
                                </ul>
                                <br /><br />
                                <span style={{ color: "gray" }}>2021.05.10</span>
                                <br /><br />
                                <br /><br />
                                <div className="more_review">
                                    <button>리뷰 더보기&nbsp;↓</button>
                                </div>
                            </div>
                            <div className="line2"></div>
                            <br />
                            <br />
                            <br />
                            <div className="qna_box">
                                <h3>질문답변</h3>
                                <br />
                                <br />
                                <span>Q. 서비스가 시작되기 어떤 절차로 진행하나요?</span>
                                <p>코치가 견적을 요청자에게 드린 후 상담을 거쳐 레슨을 진행합니다.</p>
                                <span>Q. 어떤 서비스를 전문적으로 제공하나요?</span>
                                <p>수영의 4가지 경영영법, 자유형 배영 평영 접영 레슨 ,
                                    스타트 턴 응용영법 포함 및 군입대 자격시험
                                    해병, 해병 수색대 해군 UDT 해군 SSU 등
                                    해양경찰 소방관 승무원 인명구조자격증 등 모든 서비스 가능합니다.</p>
                                <span>Q. A/S 또는 환불 규정은 어떻게 되나요?</span>
                                <p>횟수제 레슨이기 때문에 레슨시간은 매회 스케쥴 조정 후 유동적으로 정할 수 있습니다. 환불규정은 별도로 문의 주시면 상세히 안내해 드리겠습니다.</p>
                            </div>
                        </div>
                        <div className="line2"></div>
                        <br />
                        <br />
                        <br />
                    </div>
                </div>


            </section>
        </div>
    )
}

export default Portfolio;