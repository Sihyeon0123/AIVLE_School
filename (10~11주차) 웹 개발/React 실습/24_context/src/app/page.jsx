'use client'
import {createContext, useContext} from "react";

const DataContext = createContext('');

export default function App(){
    /* 교안의 예시처럼 Context App Data 라는 문자열을 
    최종 도착지에서 받을 수 있도록 토드를 넣어보자 */
    return (
        <DataContext.Provider value="Context App Data">
            <First/>
            <Island/>
        </DataContext.Provider>
    );
}

function First(){
    return (
        <>
            <div>First Component </div>
            <Second/>
        </>
    );
}

function Second() {
    return (
        <>
            <div>Second Component</div>
            <Third />
        </>
    );
}

function Third() {
    const data = useContext(DataContext);
    return (<div>Third Component / 최종 도착지 : {data}</div>);
}

function Island(){
    const data = useContext(DataContext);
    return (<div>Island Component / 최종 도착지 : {data}</div>);
}