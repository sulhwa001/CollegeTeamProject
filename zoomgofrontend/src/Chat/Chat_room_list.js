import style from "./Chat_room_list.module.css"
import search from "../image/search.png"
import avatar from "../image/avatar.png"
import { useState } from "react"


const Chat_room_list = () => {
    return(
        <div className={style.room_list}>
            <div className={style.search}>
                <div className={style.search_bar}>
                    <img src={search} alt=""/>
                    <input type="text" placeholder="Search"/>
                </div>
            </div>
                <div className={style.items}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>박 재찬</span>
                        <p>좋네요, 거래 하면 될 것 같아요</p>
                    </div>
                    <span className={style.user_type}>중고 거래</span>
                </div>
                <div className={style.items}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>남궁 진용</span>
                        <p>꿀잠 자는 법 전수 해드리면 되나요?</p>
                    </div>
                    <span className={style.user_type}>숨고</span>
                </div>
                <div className={style.items}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>박 찬욱</span>
                        <p>왜 노쇼 하세요?</p>
                    </div>
                    <span className={style.user_type}>중고 거래</span>
                </div>
        </div>
    )
}

export default Chat_room_list