import style from "./Chat_room_list.module.css"
import search from "../image/search.png"
import plus from "../image/plus.png"
import minus from "../image/minus.png"
import avatar from "../image/avatar.png"
import { useState } from "react"


const Chat_room_list = () => {

    const [addmode,setAddMode] = useState(false)


    return(
        <div className={style.room_list}>
            <div className={style.search}>
                <div className={style.search_bar}>
                    <img src={search} alt=""/>
                    <input type="text" placeholder="Search"/>
                </div>
                <img src={addmode ? minus : plus} alt="" className={style.add} onClick={() => setAddMode((prev) => !prev)}/>
            </div>
                <div className={style.items}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>조 은준</span>
                        <p>일찍 좀 다녀라</p>
                    </div>
                </div>
                <div className={style.items}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>조 은준</span>
                        <p>일찍 좀 다녀라</p>
                    </div>
                </div>
                <div className={style.items}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>조 은준</span>
                        <p>일찍 좀 다녀라</p>
                    </div>
                </div>
                <div className={style.items}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>조 은준</span>
                        <p>일찍 좀 다녀라</p>
                    </div>
                </div>
                <div className={style.items}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>조 은준</span>
                        <p>일찍 좀 다녀라</p>
                    </div>
                </div>
                <div className={style.items}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>조 은준</span>
                        <p>일찍 좀 다녀라</p>
                    </div>
                </div>
        </div>
    )
}

export default Chat_room_list