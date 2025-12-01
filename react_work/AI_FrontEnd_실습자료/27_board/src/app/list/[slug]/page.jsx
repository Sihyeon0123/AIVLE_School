'use client'
import Link from "next/link";
import {useEffect} from "react";
import {store} from "@/redux/store";

import {useSelector} from "react-redux";
import List from "./List";
// npm install axios
// npm install react-redux @reduxjs/toolkit
// npm install @mui/material @emotion/react @emotion/styled

export default function ListPage(props){

    useEffect(()=>{
        props.params.then(({slug})=>{
            console.log("page :"+slug);
            // axios 로 slug 를 가지고 해당 상세 정보를 서버에 요청
            store.dispatch({type:'board/list',payload:slug});
        });
    },[]);

    // slicer 에 있는 state 변화가 감지되면 구독하고 있는 이 함수가 실행
    let board = useSelector(state=>state.board);

    return(
        <>
            <Link href={"/write"}>
                <button>글쓰기</button>
            </Link>
            <table className="list">
                <thead>
                <tr>
                    <th>idx</th>
                    <th>이미지</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
                </thead>
                <tbody>
                    <List board={board}/>
                </tbody>
            </table>
        </>
    );
}