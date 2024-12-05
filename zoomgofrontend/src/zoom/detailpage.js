import React from 'react';
import './css/detailpage.css'; // CSS 파일을 불러옴
import dibs from './icon/dibs.png';
import Header from './Header';

const ProductPage = () => {
    return (
        <div>
            <Header  className="zoom-header" />
            <main className="main-content">
                <section className="product">
                    <div className="product-image"></div> {/* 상품 이미지 */}
                    <div className="product-details">
                        <div className="product-channel">
                            <p>홈 &gt; 패션의류</p> {/* 경로 정보 */}
                            <div className="transaction-status">
                                <div>거래중</div> {/* 거래 상태 */}
                            </div>
                        </div>
                        <div className="product-name">
                            <h1>아디다스 반팔 티</h1> {/* 상품명 */}
                        </div>
                        <div className="product-price">
                            <h2>15,000원</h2> {/* 가격 정보 */}
                        </div>
                        <div className="product-info-extra">
                            <p>3시간 전</p> {/* 추가 정보 (조회수 등) */}
                            <p>조회수 300</p>
                        </div>
                        <div className="product-location">
                            <p>거래 희망 지역 대구광역시 남구 대명동</p> {/* 거래 위치 */}
                        </div>

                        <section className="product-details-info">
                            <div className="info-item">
                                <p>제품상태</p>
                                <p>중고</p> {/* 제품 상태 */}
                            </div>
                            <div className="divider"></div>
                            <div className="info-item">
                                <p>거래방식</p>
                                <p>택배거래</p> {/* 거래 방식 */}
                            </div>
                            <div className="divider"></div>
                            <div className="info-item">
                                <p>배송비</p>
                                <p>별도</p> {/* 배송비 */}
                            </div>
                        </section>

                        <div className="product-actions">
                            <div className="dibs">
                                <img src={dibs} alt="dibs" />
                            </div>
                            <button>채팅하기</button> {/* 채팅하기 버튼 */}
                        </div>
                    </div>
                </section>

                <section className="info">
                    <div className="info-block">
                        <h3>상품 정보</h3>
                        <p>대명동 전동민 앞에서 직거래 가능<br />입금 후 택배 발송합니다.</p> {/* 상품 정보 */}
                    </div>
                    <div className="info-block">
                        <h3>가게 정보</h3>
                        <div className="store-info">
                            <div className="store-image"></div>
                            <div className="store-rating"></div> {/* 가게 정보 */}
                        </div>
                    </div>
                </section>

                <section className="comments">
                    <h3>댓글</h3>
                    <div className="comment">
                        <div className="comment-image"></div>
                        <div className="comment-text">
                            <p>댓글1</p>
                            <p>저희 동네랑 위치가 가까워요!</p>
                        </div>
                    </div>
                    <div className="comment">
                        <div className="comment-image"></div>
                        <div className="comment-text">
                            <p>댓글2</p>
                            <p>관심있습니다!</p>
                        </div>
                    </div>
                </section>

                <section className="similar-products">
                    <h3>이런 상품은 어떠세요?</h3>
                    <div className="similar-product">
                        <div className="similar-product-image"></div>
                        <p>상품1 <br /> 10,000원</p> {/* 추천 상품 */}
                    </div>
                    <div className="similar-product">
                        <div className="similar-product-image"></div>
                        <p>상품2 <br /> 10,000원</p>
                    </div>
                    <div className="similar-product">
                        <div className="similar-product-image"></div>
                        <p>상품3 <br /> 10,000원</p>
                    </div>
                    <div className="similar-product">
                        <div className="similar-product-image"></div>
                        <p>상품4 <br /> 10,000원</p>
                    </div>
                </section>
            </main>
        </div>
    );
};

export default ProductPage;
