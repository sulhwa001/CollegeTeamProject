
import './App.css';
import './css/main/footer.css';
import './css/main/header.css';
import './css/main/section.css';
import './css/main/section2.css';
import './css/main/section3.css';
import './css/main/section4.css';
import Header from './header';

import stars from "./img/review_stars.png";
function Main() {
    return (
        <div className='App'>
            <Header />
            <div className="section1">
                <div className="title">
                    <div><span className="zoomgo">ZOOMGO</span></div>
                    <div><span className="article">내가 필요한 서비스를 단 한곳에서</span></div>
                </div>
            </div>
            <div className="section2">
                <div className="title2">
                    <h1>숨은고수 포트폴리오</h1>
                </div>
                <div>
                    <ul className="pictureList">
                        <li><span>사진1</span></li>
                        <li><span>사진2</span></li>
                        <li><span>사진3</span></li>
                        <li><span>사진4</span></li>
                    </ul>
                    <div className="pictureNameList">
                        <div className="pictureNameList_1"><div className="pic"></div><span>김헌준</span></div>
                        <div className="pictureNameList_2"><div className="pic"></div><span>김헌준</span></div>
                        <div className="pictureNameList_3"><div className="pic"></div><span>김헌준</span></div>
                        <div className="pictureNameList_4"><div className="pic"></div><span>김헌준</span></div>
                    </div>
                </div>
            </div>

            <div className="section3">
                <div className="title3">
                    <h1>내 지역에 숨어 있는 숨은고수</h1>
                </div>
                <div className="review">
                    <div className="review_box">
                        <div className="review_top">
                            <div className="profile_picture"></div>
                            <div className="profile_name">
                                <span>박춘배</span>
                                <br />
                                <span className="review_work">
                                    <a href="#">상세페이지 제작</a>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div className="review_box1">
                        <div className="review_top">
                            <div className="profile_picture"></div>
                            <div className="profile_name">
                                <span>박춘배</span><br /><span className="review_work"><a href="#">상세페이지 제작</a></span>
                                <span></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className="section4">
                <div className="title4"><h1>내가 설정한 지역에 숨어있는 고수</h1></div>
                <ul className="area_content">
                    <li>
                        <div className="content_user_profile"></div>
                        <div className="article_box">
                            <span className="people_count">0명</span>의
                            <br />숨은 고수 찾아보기<br /><br /><br /><button>▷</button>
                        </div>
                    </li>
                    <li>
                        <div className="review_info">
                            <img src={stars} alt="" /><span className="review_score">4.5</span>
                        </div>
                        <div className="review_profile">
                            <div className="profile_picture"></div>
                            <div className="review_profile_name">이재한</div>
                            <div className="experience">경력 5년 · 평균 5분 이내 응답</div>
                        </div>
                    </li>
                    <li>
                        <div className="review_info">
                            <img src={stars} alt="" /><span className="review_score">4.5</span>
                        </div>
                        <div className="review_profile">
                            <div className="profile_picture"></div>
                            <div className="review_profile_name">이재한</div>
                            <div className="experience">경력 5년 · 평균 5분 이내 응답</div>
                        </div>
                    </li>
                    <li>
                        <div className="review_info">
                            <img src={stars} alt="" /><span className="review_score">4.5</span>
                        </div>
                        <div className="review_profile">
                            <div className="profile_picture"></div>
                            <div className="review_profile_name">이재한</div>
                            <div className="experience">경력 5년 · 평균 5분 이내 응답</div>
                        </div>
                    </li>
                </ul>
            </div>
            <div className="footer">
                <div className="footer_title">
                    <h1>전국 숨은 고수</h1>
                    <h2>믿을 수 있는 전문가를
                        <br />숨고 단 한곳에서 찾으세요</h2>
                </div>
                <div className="area_name">
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button><br />
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                    <button className="area_button">서울</button>
                </div>
            </div>
            <hr />
            <div className="detail"></div>
        </div>
    )

}

export default Main;