import style from "./Chat_user_info.module.css"
import avatar from "../image/avatar.png"
import more from "../image/more.png"

const Chat_user_info = () => {
    return(
        <div className={style.user_info}>
            <div className={style.user}>
                <img src={avatar} alt=""/>
                <h2>박 재찬</h2>
            </div>
            <div className={style.icons}>
                <img src={more} alt=""/>
            </div>
        </div>
    )
}

export default Chat_user_info