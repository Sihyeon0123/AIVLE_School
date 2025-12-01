import {createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import Link from "next/link";
import {store} from "@/redux/store";

const boardSlice = createSlice({
    name:'board',
    initialState:{ //state 값 초기화
        id: '',
        token: '',
        list:[],
        photos:[],
        pages:0,
        detail:{},
    },
    reducers: {
        list(state, action) {
           /* 서버로 부터 받아온 데이터를 state 에 담아서 반환 */
		   return state;
        },
        set_state(state, action){
            return state;
        },
        write(state, action) {
            /* action 에서 받아온 데이터를 서버로 저장 요청 */  
        },
        del(state, action) {
            /* action 에서 받아온 데이터를 서버로 삭제 요청 */ 
        },
        detail(state, action) {
           /* 서버로 부터 받아온 데이터를 state 에 담아서 반환 */
            return state;
        },
    }
});

export default boardSlice.reducer;