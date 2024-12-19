import style from "./Chat_room_list.module.css"
import search from "../image/search.png"
import avatar from "../image/avatar.png"
import { useEffect, useState } from "react"
import { collection, getDocs, query, where, onSnapshot} from "firebase/firestore"
import { db, storage } from '../lib/firebase'

const Chat_room_list = ({user, userNo, onRoomSelect}) => {

    const [chatRooms, setChatRooms] = useState([]);
    
    const results = new Set();

    const getListByUserNo = async (userNo) => {
        console.log("함수실행",userNo)
        if(userNo == ""){
            return;
        }
        const q1 = query(collection(db,"ChatRooms"),where("User1","==",userNo))
        const q2 = query(collection(db,"ChatRooms"),where("User2","==",userNo))

        const querySnapshot1 = await getDocs(q1);
        const querySnapshot2 = await getDocs(q2);
        
        querySnapshot1.forEach(doc =>  results.add({id: doc.id, ...doc.data()}))
        querySnapshot2.forEach(doc => results.add({id: doc.id, ...doc.data()}))

        setChatRooms(Array.from(results));
    }

    const getListByUserNoTest = (userNo) => {
        console.log("함수실행", userNo);
        if (userNo === "") {
            return;
        }
    
        const results = new Map();
    
        // User1 또는 User2로 필터링
        const q1 = query(collection(db, "ChatRooms"), where("User1", "==", userNo));
        const q2 = query(collection(db, "ChatRooms"), where("User2", "==", userNo));
    
        // onSnapshot을 사용하여 실시간 데이터 구독
        const unsubscribe1 = onSnapshot(q1, (querySnapshot1) => {
            querySnapshot1.forEach((doc) => {
                const data = { id: doc.id, ...doc.data() };
                results.set(doc.id, data); // id를 key로 사용하여 중복 방지
            });
            // 상태 업데이트
            setChatRooms(Array.from(results.values()));
        });
    
        const unsubscribe2 = onSnapshot(q2, (querySnapshot2) => {
            querySnapshot2.forEach((doc) => {
                const data = { id: doc.id, ...doc.data() };
                results.set(doc.id, data); // id를 key로 사용하여 중복 방지
            });
            // 상태 업데이트
            setChatRooms(Array.from(results.values()));
        });
        console.log("여기" , chatRooms)
    
        // 구독을 취소하려면 unsubscribe 함수를 반환
        return () => {
            unsubscribe1(); // 첫 번째 쿼리 구독 취소
            unsubscribe2(); // 두 번째 쿼리 구독 취소
        };
    };



    useEffect(()=>{
        const unsubscribe = getListByUserNoTest(userNo)
        return () => {
            if(unsubscribe){
                unsubscribe();
            }
        }
    },[userNo])

    return(
        <div className={style.room_list}>
            <div className={style.search}>
                <div className={style.search_bar}>
                    <img src={search} alt=""/>
                    <input type="text" placeholder="Search"/>
                </div>
            </div>
                {chatRooms.map((room,index) => (
                    <div key={index} className={style.items} onDoubleClick={onRoomSelect(room.id,(room.User1 === userNo ? room.User2Nickname : room.User1Nickname),room.LastMessages)}>
                        <img src={room.User1 === userNo 
                            ? (room.User2Profile !== "" ? room.User2Profile : avatar) 
                            : (room.User1Profile !== "" ? room.User1Profile : avatar)} alt=""/>
                        <div className={style.texts}>
                            <span>{room.User1 === userNo ? room.User2Nickname : room.User1Nickname}</span>
                            <p>{room.LastMessages}</p>
                        </div>
                    </div>
                ))}
        </div>
    )
}

export default Chat_room_list