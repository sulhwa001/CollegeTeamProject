import style from "./Chat_room_list.module.css"
import search from "../image/search.png"
import avatar from "../image/avatar.png"
import { useEffect, useState } from "react"
import { collection, getDocs, query, where} from "firebase/firestore"
import { db, storage } from '../lib/firebase'

const Chat_room_list = ({user, userNo}) => {

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
        
        querySnapshot1.forEach(doc =>  results.add(doc.data(),doc.id))
            
        querySnapshot2.forEach(doc => results.add(doc.data(),doc.id))

        setChatRooms(Array.from(results));
        console.log(results)
    }

    useEffect(()=>{
        getListByUserNo(userNo)

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
                    <div key={index} className={style.items}>
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