'use client'
import {createContext, useState} from "react";
import UserComponent from "./UserComp";
import PostComponent from "./PostComp";

const UserContext = createContext({info:{id:'',pw:''},setInfo:()=>{}});
const PostContext = createContext({cnt:0,setCnt:()=>{}});


// 이번엔 컴포넌트를 각 파일로 나눠서 시도 해 보자
export default function App() {
  const [cnt,setCnt] = useState(0);
  const [info, setInfo] = useState({id:'',pw:''});


  return (
    <>
      <UserContext.Provider value={{info:info,setInfo:setInfo}}>
        <UserComponent/>
      </UserContext.Provider>
      <PostContext.Provider value={{cnt:cnt,setCnt:setCnt}}>
        <PostComponent/>
      </PostContext.Provider>
    </>
  );
}

export{UserContext, PostContext};