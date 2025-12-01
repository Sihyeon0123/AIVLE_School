'use client'
import {PostContext} from "./page"
import {useContext, useMemo} from "react";

export default function PostComponent(props) {

    /*context 에 저장된 값을 불러올 수 있는 코드를 넣어보자*/
    const {cnt,setCnt} = {};

    console.log('PostComponent Rendering');
    return (
        <>
            <h3>Post 에 대한 조회수 : {cnt}</h3>
            <button onClick={()=>{setCnt(cnt+1)}}>좋아요!</button>
        </>);
}