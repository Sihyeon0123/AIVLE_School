import {createSlice} from "@reduxjs/toolkit";

// 1. reducer 와 recuer 가 다루는 state 를 가지고 있는 slicer 제작
// state 와 recuder 별로 쪼개놓았다고 하여 slicer 라고 한다.
const counterSlicer = createSlice({
    name: 'counter',
    initialState:{ // state
        value:0
    },
    reducers: {
        increment: (state, action) => { // reducer
            /*state 값을 1 증가시키는 코드를 추가해 보자*/
            state.value += 1;
            return state;   
        },
        decrement: (state, action) => {
            /*state 값을 1 감소시키는 코드를 추가해 보자*/
            state.value -= 1;       
            return state;
        },
    }
});

export default counterSlicer.reducer;