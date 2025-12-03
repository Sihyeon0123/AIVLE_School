'use client'
import {useContext, useMemo} from "react";
import {UserContext} from "./page";


export default function UserComponent(props){

    /*context 에 저장된 값을 불러올 수 있는 코드를 넣어보자*/
    const {info, setInfo} = useContext(UserContext);

    const inputStr=(field, e) => {
        setInfo({...info, [field]: e.target.value});
    }

    const html = useMemo(function(){
        console.log('User Component Rendering ');
        return (
            <div>
                <p>ID : <input type="text" value={info.id} onChange={(e)=>{inputStr('id',e)}}/></p>
                <p>PW : <input type="text" value={info.pw} onChange={(e)=>{inputStr('pw',e)}}/></p>    
            </div>
        )
    }, [info])

    return (<>{html}</>);
}