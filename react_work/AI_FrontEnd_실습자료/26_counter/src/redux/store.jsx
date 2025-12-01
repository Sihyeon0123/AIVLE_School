import {configureStore} from "@reduxjs/toolkit";
import counterSlicer from "./counterSlicer";

// 2. store 에 리듀서 등록
export const store = configureStore({
    reducer: {
        // 리듀서를 담고 있는 slicer를 counter 라는 이름으로 등록해 보자
    }
});