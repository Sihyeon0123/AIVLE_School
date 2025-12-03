// npm install axios
'use client' // next.js 는 server 와 client 를 모두 다루는 프레임 워크 이므로 명시가 필요하다.
import axios from "axios";
import {useState} from "react"; // useState 등 몇몇 함수에 대해서 use server 인지 client 인지 명시 필요!

export default function SendList({url}) {

    //axios.method(url,{config}).then().catch().finally();
    // 그러기 위해서는 state 필수
    const [list, setList] = useState([]);

    const send= async ()=>{
        let {data} = await axios.get(url);
        //console.log(data); // 이 내용을 표시해 보자!
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
    // 너무 길면 {post.title.substring(0,25)+'...'} 처리 해도 됨
    let post_list =list.map(post=>(<li key={post.id}>{post.title}</li>));
    return(<ul>{post_list.length>0 ? post_list : '불러온 POST가 없습니다.'}</ul>);
}