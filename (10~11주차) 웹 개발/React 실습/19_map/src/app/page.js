'use client';
/*global kakao*/
import { useEffect, useRef, useState } from "react";

export default function HomePage() {
  const [msg, setMsg] = useState('');
  const container = useRef(null);

  useEffect(() => {
    const { kakao } = window; // window 전역 객체에서 kakao 가져오기
    if (!kakao || !kakao.maps) return; // 카카오 스크립트가 아직 로드되지 않았다면 실행 중지

    kakao.maps.load(() => {
      // 카카오 맵 설정
      const mapOption = {
        center: new kakao.maps.LatLng(37.57190029146425, 126.98715765847491),
        level: 3,
      };

      const map = new kakao.maps.Map(container.current, mapOption);

      // 최초 마커 등록
      const marker = new kakao.maps.Marker({
        position: map.getCenter(),
      });
      marker.setMap(map);

      // 이벤트 등록
      kakao.maps.event.addListener(map, 'click', function (event) {
        console.log('evt', event);

        const latLan = event.latLng;
        marker.setPosition(latLan); // 특정 위도, 경도로 마커 이동

        const msg = '클릭한 위치의 위도는 ' + latLan.getLat() + ', 경도는 ' + latLan.getLng() + ' 입니다.';
        setMsg(msg);
      });
    });
  }, []);

  return (
    <>
      <div
        id="map"
        style={{ width: "100%", height: "500px" }}
        ref={container}
      ></div>
      <p id="msg">{msg}</p>
    </>
  );
}
