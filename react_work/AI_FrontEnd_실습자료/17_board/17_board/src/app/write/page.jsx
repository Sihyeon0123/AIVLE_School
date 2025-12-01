'use client'
import Link from "next/link";
import "./Write.css";
import {useState} from "react";
import axios from "axios";
export default function Write() {

    const [info, setInfo] = useState({user_name:'', subject:'',content:''});
    const input=(key,e)=>{
        /* 1. 입력 내용 state 에 저장 로직 */
    }
    const write = async()=>{
        /* 2. 글쓰기 저장 요청 로직 */
    }
    return (
        <div className="write">{/* 글쓰기 UI 출력*/}</div>
    );
}