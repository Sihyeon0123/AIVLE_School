'use client'
import {useEffect, useRef, useState} from "react";
import Link from "next/link";
import './List.css';
import axios from "axios"; //npm install axios


export default function PostList({page}) {

    const [posts, setPosts] = useState([]);

    // 1. 시작하자 마자 리스트를 호출하고
    useEffect(()=>{
		/* 2. makeItem() 호출 */
    },[]);

    const makeItem=(data) => {
		    /* 3. 받아온 데이터로 list 를 만들고… state 에 저장 */
        setPosts(content);
    };

    return(
        <div>
            {posts} {/*state 인 posts 출력*/}
        </div>);
}