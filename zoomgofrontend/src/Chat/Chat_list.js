import style from "./Chat_list.module.css"
import Chat_room_list from "./Chat_room_list"
import Chat_user_info from "./Chat_user_info"

const Chat_list = ({user, userNo}) => {

    return(
        <div className={style.list}>
            <Chat_user_info user={user}/>
            <Chat_room_list user={user} userNo={userNo}/>
        </div>
    )
}

export default Chat_list