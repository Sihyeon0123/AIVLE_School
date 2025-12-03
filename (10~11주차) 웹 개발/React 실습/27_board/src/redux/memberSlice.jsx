import {createSlice} from "@reduxjs/toolkit";
import axios from "axios";

const memberSlice = createSlice({
    name:'member',
    initialState:{},
    reducers:{
        login(state, action){
            /* 서버로 정보를 넘기고 받은 token 을 이용한 인증 처리 */
            axios.post("http://localhost/login", action.payload).then(({data})=>{
                console.log(data);
                if(data.success){
                    sessionStorage.setItem("token",data.token);
                    sessionStorage.setItem("id",action.payload.id);
                    location.href='/list/1';
                }else{
                    alert('아이디 또는 비밀번호를 확인해 주세요!');
                }
            });
        }
    }
});

export default memberSlice.reducer;