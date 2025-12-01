import {createSlice} from "@reduxjs/toolkit";
import axios from "axios";
import Link from "next/link";
import {store} from "@/redux/store";

const boardSlice = createSlice({
    name:'board',
    initialState:{ // state 초기에 id 와 token 값을 미리 받아낸다.
        id: typeof window == 'undefined' ? '' : sessionStorage.getItem('id'),
        token: typeof window == 'undefined' ? '' : sessionStorage.getItem('token'),
        list:[],
        photos:[],
        pages:0,
        detail:{},
    },
    reducers: {
        list(state, action) {
            console.log('list 호출 : '+action.payload+'page');
            axios.get(`http://localhost/list/${state.id}/${action.payload}`
                ,{headers: {'Authorization': state.token}}).then(({data})=>{
                console.log(data);
                // 받아온 데이터를 set_state 함수를 통해 state 에 담아준다.
                store.dispatch({type:'board/set_state',payload:{pages:data.pages, list:data.list}});
            });
        },
        set_state(state, action){
            Object.keys(action.payload).forEach(key => {
                state[key] = action.payload[key];
            });
            return state;
        },
        write(state, action) {
            //redux 에서는 form-data 등 직렬화를 할 수 없는 데이터는 사용 하지 않도록 권고한다.
            // 그래서 slice 에서는 form-data 는 안쓰거나 외부에서 쓰는것을 추천
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
            axios.get(`http://localhost/detail/${state.id}/${action.payload}`,{headers:{Authorization: state.token}})
                .then(({data})=>{
                    //console.log(data);
                    store.dispatch({type:'board/set_state',payload:{detail:data.detail,photos:data.photos}});
                });
            return state;
        },
    }
});

export default boardSlice.reducer;