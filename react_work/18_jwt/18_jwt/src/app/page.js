'use client'
import '@/app/common.css'
import {useEffect, useState} from "react";
import axios from 'axios'; // npm install axios

export default function LoginPage(){

  const [info, setInfo] = useState({id:'',pw:''});

  useEffect(()=>{
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("id");
  },[]);

  const input=(e)=>{
    setInfo({...info,[e.target.name]:e.target.value});
  }

  const login=async()=>{
    let {data} = await axios.post("http://localhost/login",info);
    console.log(data);
    /* 받아온 data 를 이용해 로그인 로직을 추가해 보자*/
    if(data.result === "success"){
      sessionStorage.setItem("token",data.token);
      sessionStorage.setItem("id",info.id);
      alert("로그인 성공");
      window.location.href="/list/1";
    }else{
      alert("로그인 실패");
    } 
  }

  return(
      <>
        <h3>로그인</h3>
        <hr/>
        <table>
          <tbody>
          <tr>
            <th>ID</th>
            <td><input type="text" name="id" placeholder="아이디를 입력 하세요"  onChange={input}/></td>
            <th rowSpan="2">
              <input className="login" type="button" value="로그인" onClick={login}/>
            </th>
          </tr>
          <tr>
            <th>PW</th>
            <td><input type="text" name="pw" placeholder="비밀번호를 입력 하세요" onChange={input}/></td>
          </tr>
          </tbody>
        </table>
      </>
  );

}