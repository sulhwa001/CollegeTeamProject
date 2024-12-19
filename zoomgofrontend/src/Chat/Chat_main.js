import { useSearchParams } from 'react-router-dom'
import Chat_detail from './Chat_detail'
import Chat_input from './Chat_input'
import Chat_list from './Chat_list'
import style from './Chat_main.module.css'
import { useEffect, useState } from 'react'
import { db, storage } from '../lib/firebase'
import { getDocs, collection, query, where, addDoc} from 'firebase/firestore'
import axios from 'axios'

const Chat = () =>{

    const token = localStorage.getItem('zoomgo-token');

    const [user, setUser] = useState({
        Nickname : "",
        Profile : "",
        User_No : null
    });

    const [userData, setUserData] = useState({});

    const [userNo, setUserNo] = useState("")

    const [selectedRoom, setSelectedRoom] = useState(null);
    const [otherUser, setOtherUser] = useState({})

    const handleRoomSelect = (room,nickName,LastMessages) => {
        setSelectedRoom(room);
        setOtherUser({
            nickName: nickName,
            LastMessages: LastMessages,
        });
    }

    const getUserByUserNo = async (userNo) => {
        if(userNo == null){
            return;
        }
        const q = query(collection(db,"Users"), where("User_No","==",userNo));
        const querySnapshot = await getDocs(q);

        if(querySnapshot.empty){
            console.log("정보가 없습니다.")
            await addDoc(collection(db,"Users"),user)
            console.log("새로운 정보가 등록 되었습니다.")
        }else{
            const doc = querySnapshot.docs[0];
            setUser(doc.data());
            setUserNo(doc.id);
        }
    }

    useEffect(() => {
    
        if (!token) {
            alert("로그인이 필요한 기능입니다.");
            window.location.href = "/login";
        } else {
            // 데이터 가져오기
            axios.get("http://localhost:8080/api/members/getmember", {
                headers: { Authorization: `Bearer ${token}` }
            })
            .then(res => {
                console.log(res.data);
                setUserData(res.data); // userData 설정
            })
            .catch(err => {
                console.error("Error", err);
            });
        }
    }, [token]); // token 변경시만 호출되도록 의존성 배열 추가

    useEffect(()=>{
        setUser({
            Nickname: userData.nickName,
            Profile: userData.profileImage,
            User_No: userData.userNo
        });
        getUserByUserNo(userData.userNo);
        console.log(user);
    }, [userData]); 

    if(!user){
        return <div>정보를 불러오는 중입니다...</div>
    }

    return(
        <div className={style.chat_container}>
            <div className={style.chat_content}>
                <Chat_list user={user} userNo={userNo} onRoomSelect={handleRoomSelect}/>
                <Chat_input selectedRoom={selectedRoom} userNo={userNo} otherUser={otherUser}/>
                <Chat_detail selectedRoom={selectedRoom} userNo={userNo} otherUser={otherUser}/>
            </div>
        </div>
    )
}

export default Chat