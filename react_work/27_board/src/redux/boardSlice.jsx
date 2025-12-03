import {createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import Link from "next/link";
import {store} from "@/redux/store";

const boardSlice = createSlice({
    name:'board',
    initialState:{ //state 값 초기화
        id: typeof window == "undefined" ? "" : sessionStorage.getItem("id"),
        token: typeof window == "undefined" ? "" : sessionStorage.getItem("token"),
        list:[],
        photos:[],
        pages:0,
        detail:{},
        page:1
    },
    reducers: {
        list(state, action) {
           /* 서버로 부터 받아온 데이터를 state 에 담아서 반환 */
           console.log('list 호출 : '+action.payload+'page');
           axios.get(`http://localhost/list/${state.id}/${action.payload}`
               ,{headers: {'Authorization': state.token}}).then(({data})=>{
               console.log(data);
                // 받아온 데이터를 set_state 함수를 통해 state 에 담아준다.
                store.dispatch({type:'board/set_state',payload:{pages:data.pages, list:data.list}});
              });
		   return state;
        },
        set_state(state, action){
            console.log('set_state 호출 : ');
            Object.keys(action.payload).forEach(key => {
                state[key] = action.payload[key];
            }); 
            return state;
        },
        write(state, action) {
            /* action 에서 받아온 데이터를 서버로 저장 요청 */  
            console.log('write 호출 : ');
            axios.post('http://localhost/write',action.payload,{headers:{Authorization:state.token}})
                .then(({data})=>{
                    console.log(data);
                    if(data.success){
                        alert('글쓰기가 성공 하였습니다.');
                        location.href = '/detail/'+data.idx;
                    }
                });
        },
        del(state, action) {
            /* action 에서 받아온 데이터를 서버로 삭제 요청 */ 
            console.log('del 호출 : ');
            axios.delete(`http://localhost/del/${state.id}/${action.payload}`,{headers:{Authorization:state.token}
            }).then(({data})=>{
                console.log(data);
                if(data.success){
                    console.log('삭제 성공 리스트 재 호출');
                    location.href = '/list/1';
                }
            });
        },
        detail(state, action) {
           /* 서버로 부터 받아온 데이터를 state 에 담아서 반환 */
            console.log('detail 호출 : '+action.payload);
            axios.get(`http://localhost/detail/${state.id}/${action.payload}`,{headers:{Authorization: state.token}})
                .then(({data})=>{
                    console.log(data);
                    store.dispatch({type:'board/set_state',payload:{detail:data.detail,photos:data.photos}});
                });
            return state;
        },
    }
});

export default boardSlice.reducer;