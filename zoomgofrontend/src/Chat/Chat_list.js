import style from "./Chat_list.module.css"
import Chat_room_list from "./Chat_room_list"
import Chat_user_info from "./Chat_user_info"

const Chat_list = () => {
    return(
        <div className={style.list}>
            <Chat_user_info/>
            <Chat_room_list/>
        </div>
    )
}

export default Chat_list