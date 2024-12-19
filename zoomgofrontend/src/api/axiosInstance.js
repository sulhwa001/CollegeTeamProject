import axios from 'axios';

const axiosInstance = axios.create({
baseURL: 'http://localhost:8080/api', // 백엔드 서버 주소로 변경
timeout: 5000, // 요청 타임아웃 설정 (5초)
headers: {
'Content-Type': 'application/json',
},
});

export default axiosInstance;