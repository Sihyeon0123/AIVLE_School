'use client'
/*global kakao*/
import {useEffect, useRef, useState} from "react";
export default function HomePage(){

  const [msg, setMsg] = useState('');
  const container = useRef(null);

  useEffect(() => {
    /*카카오 맵을 적용 해 보자*/
  }, []);

  return (
      <>
        <div id="map" style={{width:"100%",height:"500px"}} ref={container}></div>
        <p id="msg">{msg}</p>
      </>
  );
}