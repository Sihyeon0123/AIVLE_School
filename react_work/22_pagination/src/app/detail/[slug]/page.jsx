'use client'
import {useEffect, useState, useRef} from "react";
import React from "react";
import Link from "next/link";
import "@/app/common.css";
import axios from "axios";

export default function DetailPage(props){

    const [info, setInfo] = useState({
        idx: 0,
        subject: '',
        content: '',
        user_name: '',
        reg_date: '',
        bHit: 0
    });

    const [list, setList] = useState('');

    // 최신 Next.js: params는 Promise → 언래핑 필수
    const params = React.use(props.params);
    const slug = params.slug;

    const executedRef = useRef(false);

    useEffect(() => {
        if (executedRef.current) return;
        executedRef.current = true;

        console.log("idx :", slug);
        getDetail(slug);

    }, [slug]);

    const getDetail = async (idx) => {
        const id = sessionStorage.getItem("id");
        const token = sessionStorage.getItem("token");

        const { data } = await axios.get(
            `http://localhost/detail/${id}/${idx}`,
            { headers: { Authorization: token } }
        );

        setInfo(data.detail);

        if (data.photos.length > 0) {
            setList(<PhotoList photos={data.photos} />);
        }
    };

    const del = async () => {
        const token = sessionStorage.getItem("token");
        const id = sessionStorage.getItem("id");

        const { data } = await axios.delete(
            `http://localhost/del/${id}/${info.idx}`,
            { headers: { Authorization: token } }
        );

        alert('삭제 되었습니다.');
        location.href = '/list/1';
    };

    return (
        <>
            <table className="form">
                <tbody>
                    <tr>
                        <th>제목</th>
                        <td>{info.subject}</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>{info.user_name}</td>
                    </tr>
                    <tr>
                        <th>작성일</th>
                        <td>{info.reg_date}</td>
                    </tr>
                    <tr>
                        <th>조회수</th>
                        <td>{info.bHit}</td>
                    </tr>
                    <tr>
                        <th>내용</th>
                        <td>{info.content}</td>
                    </tr>

                    {list}

                    <tr>
                        <th colSpan="2">
                            <Link href="/list/1"><input type="button" value="리스트"/></Link>
                            <input type="button" value="삭제" onClick={del}/>
                            <Link href={`/update/${info.idx}`}><input type="button" value="수정"/></Link>
                        </th>
                    </tr>
                </tbody>
            </table>
        </>
    );
}

function PhotoList({ photos }) {
    return (
        <tr>
            <th>사진</th>
            <td>
                {photos.map(photo => (
                    <div key={photo.file_idx}>
                        <p><img src={`http://localhost/photo/${photo.file_idx}`} width={300}/></p>
                        <a href={`http://localhost/download/${photo.file_idx}`}>다운로드</a>
                        <br/><br/>
                    </div>
                ))}
            </td>
        </tr>
    );
}
