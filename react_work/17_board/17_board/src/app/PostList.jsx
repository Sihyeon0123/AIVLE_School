'use client'
import {useEffect, useRef, useState} from "react";
import Link from "next/link";
import './List.css';
import axios from "axios"; 


export default function PostList({page}) {

    const [posts, setPosts] = useState([]);

    // 1. 시작하자 마자 리스트를 호출하고
    useEffect(()=>{
        axios({method: "get", url: 'http://localhost/list/'+page})
            .then(({data})=>{
                console.log(data);
                makeItem(data);
            });
    },[]);

    const makeItem=(data) => {
        console.log(data);
        let {list} = data;

        let content = list.map((post)=>(
            <div key={post.idx} className="post">
                <Link href={`/detail/${post.idx}`}>
                    <div className="title">
                        {post.idx} : {post.subject}
                        <span className="cnt">[{post.bHit}]</span>
                    </div>
                </Link>
                <div className="sub">{post.user_name}</div>
            </div>
        ));
        setPosts(content);
    };

    return(
        <div>
            {posts}
        </div>);
}