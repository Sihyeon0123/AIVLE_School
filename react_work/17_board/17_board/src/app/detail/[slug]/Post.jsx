'use client'// async Component 이용은 서버에서 가능!
import {useEffect, useState} from "react";
import axios from "axios";
import Link from "next/link";
import "./Post.css";

export default function Post({idx}){

    const [post,setPost] = useState(null);
	// 1. 시작하자 마자 리스트를 호출하고
    useEffect(()=>{
        /* 2.makeHTML() 호출 */
    },[]);

    const makeHTML = (info) => {
		/* 3. 받아온 info 로 페이지를 만들어서 state 에 저장 */
    }

    return(
        <div>{post}</div> {/*state 인 post 출력*/}
    );
}