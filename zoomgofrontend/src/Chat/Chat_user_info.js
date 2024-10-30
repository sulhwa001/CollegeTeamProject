import style from "./Chat_user_info.module.css"
import avatar from "../image/avatar.png"
import more from "../image/more.png"

const Chat_user_info = () => {
    return(
        <div className={style.user_info}>
            <div className={style.user}>
                <img src={avatar} alt=""/>
                <h2>조 은준</h2>
            </div>
        </div>
    )
}

export default Chat_user_info