import { useSearchParams } from 'react-router-dom'
import Chat_detail from './Chat_detail'
import Chat_input from './Chat_input'
import Chat_list from './Chat_list'
import style from './Chat_main.module.css'
import { useEffect, useState } from 'react'
import { db, storage } from '../lib/firebase'
import { getDocs, collection, query, where, addDoc} from 'firebase/firestore'

const Chat = () =>{

    // const token = localStorage.getItem('zoomgo-token');

    // let [query, setQuery] = useSearchParams();

    // let userNo = query.get("userNo")

    const [user, setUser] = useState({});

    const getUserByUserNo = async (userNo) => {
        const q = query(collection(db,"Users"), where("User_No","==",userNo));
        const querySnapshot = await getDocs(q);
        
        if(querySnapshot.empty){
            console.log("정보가 없습니다.")
            await addDoc(collection(db,"Users"),user)
            console.log("새로운 정보가 등록 되었습니다.")
        }else{
            const doc = querySnapshot.docs[0];
            setUser(doc.data());
        }
    }

    useEffect(() => {
        // if(!token){
        //     alert("로그인이 필요한 기능입니다.");
        //     window.location.href = "/login";
        // }
        getUserByUserNo(3);
    },[])

    if(!user){
        return <div>정보를 불러오는 중입니다...</div>
    }

    return(
        <div className={style.chat_container}>
            <div className={style.chat_content}>
                <Chat_list/>
                <Chat_input/>
                <Chat_detail/>
            </div>
        </div>
    )
}

export default Chat