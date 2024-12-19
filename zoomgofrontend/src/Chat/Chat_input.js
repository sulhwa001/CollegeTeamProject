import { collection, getDocs, orderBy, query, serverTimestamp, where, addDoc, onSnapshot, updateDoc, doc} from "firebase/firestore"
import avatar from "../image/avatar.png"
import emoji from "../image/emoji.png"
import img from "../image/img.png"
import keyboadrdImg from "../image/keyboard.jpeg"
import style from "./Chat_input.module.css"
import EmojiPicker from "emoji-picker-react"
import { useEffect, useRef, useState } from "react"
import { db } from "../lib/firebase"

const Chat_input = (selectedRoom, userNo, otherUser) => {
    
    const [open,setOpen] = useState(false);
    const [text,setText] = useState("");

    const [messages, setMessages] = useState([])

    const endRef = useRef(null);

    const getMessagesByChatRoomsNo = (chatRoomId) => {
        const q = query(
            collection(db, "Messages"),
            where("ChatRooms", "==", chatRoomId),
            orderBy("SendTime", "asc")
        );

        // onSnapshot은 리스너를 반환하며, 이 리스너는 unsubscribe로 사용될 수 있음
        const unsubscribe = onSnapshot(q, (querySnapshot) => {
            const result = [];
            querySnapshot.forEach((doc) => {
                const data = doc.data();
                const sendTime = data.SendTime ? formatTime(data.SendTime) : formatTime(new Date());
                console.log(sendTime);
                result.push({
                    ...data,
                    SendTime: sendTime,
                });
            });
            setMessages(result); // 메시지를 상태에 저장
        });

        // unsubscribe는 리스너 해제 함수
        return unsubscribe; 
    };

    useEffect(() => {
        endRef.current?.scrollIntoView({ behavior: "smooth" });
    },[messages])

    useEffect(() => {
        console.log(selectedRoom.selectedRoom);
        console.log(selectedRoom.userNo);
        console.log(selectedRoom.otherUser.nickName)
        const unsubscribe = getMessagesByChatRoomsNo(selectedRoom.selectedRoom)

        return () => {
            if(unsubscribe){
                unsubscribe();
            }}
    },[selectedRoom.selectedRoom])

    const handleEmoji = e => {
        setText(prev => prev + e.emoji);
        setOpen(false);
    }

    

    const formatTime = (sendTime) => {
        const timeDiff = Date.now() - sendTime.seconds * 1000;
        const minutesAgo = Math.floor(timeDiff / 60000);

        if(minutesAgo < 1){
            return "방금 전";
        }else if(minutesAgo < 60){
            return `${minutesAgo} 분 전`
        }else{
            const date = new Date(sendTime.seconds * 1000);
            return date.toLocaleTimeString();
        }
    } 

    const handleSend = async () => {
        if(text.trim() === ""){
            return;
        }
        await addDoc(collection(db, "Messages"),{
            ChatRooms: selectedRoom.selectedRoom,
            SendTime: serverTimestamp(),
            SendUsers: selectedRoom.userNo,
            Text: text,
        });
        const refs = doc(db, "ChatRooms", selectedRoom.selectedRoom);
        const updateData = {
            LastMessages : text,
        }
        await updateDoc(refs,updateData);
        setText("");
    }

    return(
        <div className={style.input}>
            <div className={style.top}>
                <div className={style.user}>
                    <img src={avatar} alt=""/>
                    <div className={style.texts}>
                        <span>{selectedRoom.otherUser.nickName}</span>
                        <p>{selectedRoom.otherUser.LastMessages}</p>
                    </div>
                </div>
            </div>
            <div className={style.center}>
                {messages.map((message, index) => (
                <div key={index} className={message.SendUsers === selectedRoom.userNo ? style.messege_own : style.messege}>
                    <div className={style.texts}>
                        <p>{message.Text}</p>
                        <span>{message.SendTime}</span>
                    </div>
                </div>
                ))}
                <div ref={endRef}></div>
            </div>
            <div className={style.bottom}>
                <div className={style.icons}>
                    <img src={img} alt=""/>
                </div>
                <input type="text" placeholder="채팅을 입력해주세요..."  value={text} onChange={e => setText(e.target.value)}/>
                <div className={style.emoji}>
                    <img src={emoji} alt="" onClick={() => setOpen(prev => !prev)}/>
                    <div className={style.picker}>
                      <EmojiPicker open={open} onEmojiClick={handleEmoji}/>
                    </div>
                </div>
                <button className={style.sendButton} onClick={handleSend}>보내기</button>
            </div>
        </div>
    )
}

export default Chat_input