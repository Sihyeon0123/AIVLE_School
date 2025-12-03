'use client'
import {useEffect, useState} from "react";
import Link from "next/link";
import axios from "axios";
import {store} from "@/redux/store";
import {useSelector} from "react-redux";
export default function DetailPage(props){

    const [list,setList]=useState('');

    // Component 함수에 async 가 붙으면 use client 를 사용할 수 없다.
    useEffect(() => {
        props.params.then(({slug})=>{
            console.log("idx :"+slug);
            // axios 로 slug 를 가지고 해당 상세 정보를 서버에 요청
            getDetail(slug);
        });
    },[]);

    let info = useSelector(state => {
        console.log(state.board);
        return state.board;
    });


    const getDetail=(idx)=>{
        store.dispatch({type:'board/detail',payload:idx});
    }

    const del=(idx)=>{
        store.dispatch({type:'board/del',payload:idx});
    }

    return(
        <>
            <table className={"form"}>
                <tbody>
                <tr>
                    <th>제목</th>
                    <td>{info.detail.subject}</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>{info.detail.user_name}</td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td>{info.detail.reg_date}</td>
                </tr>
                <tr>
                    <th>조회수</th>
                    <td>{info.detail.bHit}</td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>{info.detail.content}</td>
                </tr>
                <PhotoList photos={info.photos}/>
                <tr>
                    <th colSpan="2">
                        <Link href={"/list/1"}>
                            <input type="button" value="리스트"/>
                        </Link>
                        <input type="button" value="삭제" onClick={()=>{del(info.detail.idx)}}/>
                        <Link href={`/update/${info.detail.idx}`}>
                            <input type="button" value="수정"/>
                        </Link>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}

function PhotoList({photos}){

    let content = '';

    content = photos.map(photo=>{
        return(
            <tr key={photo.file_idx}>
                <th>사진</th>
                <td>
                    <div key={photo.file_idx}>
                        <p><img src={`http://localhost/photo/${photo.file_idx}`} width={300}/></p>
                        <br/>
                        <a href={`http://localhost/download/${photo.file_idx}`}>다운로드</a>
                        <br/>
                    </div>
                </td>
            </tr>
        );
    });

    return (<>{content}</>);
}

