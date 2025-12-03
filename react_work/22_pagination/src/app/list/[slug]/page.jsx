'use client'
import "@/app/common.css"
import Link from "next/link";
import {useEffect, useState} from "react";
import axios from "axios";

import Pagination from "@mui/material/Pagination";
import Stack from "@mui/material/Stack";

export default function ListPage(props){

    const [list, setList] = useState([]);

    // 총 만들수 있는 페이지 수
    const [pages, setPages] = useState(1);

    useEffect(()=>{
        props.params.then(({slug})=>{
            console.log("page :"+slug);
            // axios 로 slug 를 가지고 해당 상세 정보를 서버에 요청
            callList(slug);
        });
    },[]);

    // 기능 추가
    const changePage = (e,val)=>{
        console.log(val,e);
        callList(val);
    }

    const callList=async(p)=>{
        const id = sessionStorage.getItem("id");
        const token = sessionStorage.getItem("token");
        const {data} = await axios.get(`http://localhost/list/${id}/${p}`,{headers:{Authorization:token}});
        console.log(data);
        // 이 값을 추가해 줘야 페이징 처리가 가능하다.
        setPages(data.pages)
        let content = data.list.length === 0 ? (<tr><th colSpan="6">작성된 글이 없습니다.</th></tr>)
            : data.list.map(item=>{
                return(
                    <tr key={item.idx}>
                        <td>{item.idx}</td>
                        <th>
                            {item.cnt > 0 ? <img src="/image.png" width="25px"/> : <img src="/noimage.png" width="25px"/>}
                        </th>
                        <td><Link href={`/detail/${item.idx}`}>{item.subject}</Link></td>
                        <td>{item.user_name}</td>
                        <td>{item.bHit}</td>
                        <td>{item.reg_date}</td>
                    </tr>
                );
            });
        setList(content);
    }

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
                {list}
                <tr>
                    <th colSpan="6">
                        <div style={{"display":"flex","justify-content": "center"}}>
                            {/* 교안에 있는 모양이 나타나도록 코드를 추가해 보자 */}
                            <Stack spacing={2}>
                                <Pagination 
                                count={pages} 
                                color="primary" 
                                onChange={changePage}/>
                            </Stack>
                        </div>
                    </th>
                </tr>
                </tbody>
            </table>
        </>
    );
}