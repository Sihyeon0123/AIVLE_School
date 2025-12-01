import {createSlice} from "@reduxjs/toolkit";
import axios from "axios";

const memberSlice = createSlice({
    name:'member',
    initialState:{},
    reducers:{
        login(state, action){
            /* 서버로 정보를 넘기고 받은 token 을 이용한 인증 처리 */
        },
    }
});

export default memberSlice.reducer;