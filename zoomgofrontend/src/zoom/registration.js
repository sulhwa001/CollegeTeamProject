import React, { useState } from 'react';
import './css/registration.css';
import { useNavigate } from 'react-router-dom';
import Header from './Header';
import axios from 'axios';

function RegistrationPage() {
    const [title, setTitle] = useState(''); // 상품명
    const [categoryName, setCategoryName] = useState(''); // 선택된 카테고리 이름
    const [categoryId, setCategoryId] = useState(''); // 카테고리 ID
    const [address, setAddress] = useState(''); // 거래 장소
    const [price, setPrice] = useState(''); // 가격
    const [contents, setContents] = useState(''); // 상품 설명
    const [transStatus, setTransStatus] = useState(''); // 거래 상태
    const [transType, setTransType] = useState(''); // 거래 유형
    const [view, setView] = useState(0); // 조회수 (기본값 0)
    const [cost, setCost] = useState(''); // 비용
    const [file, setFile] = useState(null); // 파일 (이미지 등)
    const [fileName, setFileName] = useState(''); // 업로드된 파일명
    const navigate = useNavigate();

    const categories = [
        { id: 1, name: '전자제품' },
        { id: 2, name: '가구' },
        { id: 3, name: '의류' },
        { id: 4, name: '책' },
    ];
    

// 카테고리 선택 핸들러
const handleCategorySelect = (id, name) => {
    console.log('카테고리 선택:', id, name); // 선택된 카테고리 값을 콘솔에 출력
    setCategoryId(id); // 선택된 카테고리 ID 업데이트
    setCategoryName(name); // 선택된 카테고리 이름 업데이트
};

    

    const handleFileChange = (e) => {
        const selectedFile = e.target.files[0]; // 선택된 파일
        if (selectedFile) {
            setFile(selectedFile); // 파일 객체 저장
            setFileName(selectedFile.name); // 파일명 저장
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!title || !categoryId || !address || !price || !contents || !transStatus || !transType) {
            alert('모든 필드를 입력해주세요.');
            return;
        }
        console.log('Selected Category:', { categoryId, categoryName });


        const productData = {
            postId: 2, // 실제로는 서버에서 받아오는 값 사용
            title,
            contents,
            memberId: 2,
            category: { categoryId, categoryName }, // 선택된 카테고리 값 전송
            address,
            transStatus,
            transType,
            view,
            cost: cost || 0,
            price,
        };

        const formData = new FormData();
        formData.append('boardDTO', JSON.stringify(productData));
        if (file) formData.append('image', file);

        try {
            const response = await axios.post('http://localhost:8080/api/products', formData, {
                headers: { 'Content-Type': 'multipart/form-data' },
            });

            if (response.status === 201) {
                alert('상품이 등록되었습니다.');
                navigate('/');
            }
        } catch (error) {
            console.error('상품 등록 실패:', error);
            alert('상품 등록에 실패했습니다. 다시 시도해주세요.');
        }
    };

    return (
        <div>
            <Header />
            <main className="main-content">
                <form onSubmit={handleSubmit}>
                    <div className="input-group">
                        <input
                            type="text"
                            id="title"
                            placeholder="상품명"
                            value={title}
                            onChange={(e) => setTitle(e.target.value)}
                        />
                    </div>
                    <div className="custom-select">
                    <div className="selected">
                        {categoryName || '카테고리 선택'}
                    </div>
                    <div className="dropdown">
                        {categories.map((category) => (
                            <div
                                key={category.id}
                                className="dropdown-item"
                                onClick={() => handleCategorySelect(category.id, category.name)} // 클릭 시 핸들러 호출
                            >
                                {category.name}
                            </div>
                        ))}
                    </div>
                </div>


                    <div className="input-group">
                        <input
                            type="text"
                            id="address"
                            placeholder="거래장소를 입력 해 주세요."
                            value={address}
                            onChange={(e) => setAddress(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            id="price"
                            placeholder="가격"
                            value={price}
                            onChange={(e) => setPrice(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            id="cost"
                            placeholder="택배비"
                            value={cost}
                            onChange={(e) => setCost(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <textarea
                            id="contents"
                            rows="4"
                            placeholder="상품설명"
                            value={contents}
                            onChange={(e) => setContents(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            id="transStatus"
                            placeholder="거래 상태"
                            value={transStatus}
                            onChange={(e) => setTransStatus(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <input
                            type="text"
                            id="transType"
                            placeholder="거래 유형"
                            value={transType}
                            onChange={(e) => setTransType(e.target.value)}
                        />
                    </div>
                    <div className="input-group">
                        <label htmlFor="file" className="file-upload-label">
                            파일 업로드
                        </label>
                        <input
                            type="file"
                            id="file"
                            onChange={handleFileChange}
                            className="file-upload-input"
                        />
                        {fileName && <span className="file-name-preview">  {fileName}</span>}

                    </div>
                    <button type="submit" className="submit-btn">등록하기</button>
                </form>
            </main>
        </div>
    );
}

export default RegistrationPage;
