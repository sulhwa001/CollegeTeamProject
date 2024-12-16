import { useSearchParams } from 'react-router-dom'
import Chat_detail from './Chat_detail'
import Chat_input from './Chat_input'
import Chat_list from './Chat_list'
import style from './Chat_main.module.css'
import { useEffect } from 'react'

const Chat = () =>{

    const token = localStorage.getItem('zoomgo-token');

    let [query, setQuery] = useSearchParams();

    let userNo = query.get("userNo")

    const db = getDatabase();

    useEffect(() => {
        if(!token){
            alert("로그인이 필요한 기능입니다.");
            window.location.href = "/login";
        }
    })

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