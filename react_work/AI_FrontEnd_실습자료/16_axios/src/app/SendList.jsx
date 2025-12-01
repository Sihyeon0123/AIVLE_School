// npm install axios
'use client' // next.js 는 server 와 client 를 모두 다루는 프레임 워크 이므로 명시가 필요하다.
import axios from "axios";
import {useState} from "react"; // useState 등 몇몇 함수에 대해서 use server 인지 client 인지 명시 필요!

export default function SendList({url}) {    

    const [list, setList] = useState([]);

    const send= async ()=>{
        let {data} = await axios.get(url);
        setList(data);
    }

    return(
        <div>
            <button onClick={send}>전송</button>
            <Post list={list}/>
        </div>
    );
}

function Post({list}) {
    /* 받아온 List 가 표출되도록 코드를 작성해 보자*/
}