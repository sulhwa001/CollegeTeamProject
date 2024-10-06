import Chat_detail from './Chat_detail'
import Chat_input from './Chat_input'
import Chat_list from './Chat_list'
import style from './Chat_main.module.css'
import { Link } from 'react-router-dom'

const Chat = () =>{
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