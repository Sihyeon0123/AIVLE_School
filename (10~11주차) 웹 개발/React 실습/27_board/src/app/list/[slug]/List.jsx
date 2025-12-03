import Stack from "@mui/material/Stack";
import Pagination from "@mui/material/Pagination";
import Link from "next/link";
import {store} from "@/redux/store";
import { useRouter, useSearchParams } from "next/navigation";

export default function List({board}){
    console.log(board);
    let listItem =  <tr><th colSpan={6}>작성된 글이 없습니다.</th></tr>;
    
    const router = useRouter();
    const searchParams = useSearchParams();
    const currentPage = Number(searchParams.get("page")) || 1;

    if(board.list.length>0){
        listItem = board.list.map(item=>(
            <tr key={item.idx}>
                <td>{item.idx}</td>
                <th>
                    {item.cnt > 0 ? <img src="/image.png" width="25px"/> : <img src="/noimage.png" width="25px"/>}
                </th>
                <td><Link href={`/detail/${item.idx}?page=${currentPage}`}>{item.subject}</Link></td>
                <td>{item.user_name}</td>
                <td>{item.bHit}</td>
                <td>{item.reg_date}</td>
            </tr>
        ));
    }

    const changePage = (e,val)=>{
        console.log(val,e);
        store.dispatch({ type: "board/list", payload: val });

        // URL 업데이트: /list?page=val
        router.push(`?page=${val}`);
    }

    return(
    <>
        {listItem}
        <tr>
            <th colSpan="6">
                <div style={{"display":"flex","justifyContent": "center"}}>
                    <Stack spacing={2}>
                        <Pagination count={board.pages} // 전체 페이지 수
                                    page={currentPage}
                                    color={"primary"}
                                    variant={"outlined"}
                                    shape={"rounded"}
                                    siblingCount={2}    // 현재 페이지 양족에 표시할 갯수(중간정도 왔을때)
                                    onChange={changePage}
                        />
                    </Stack>
                </div>
            </th>
        </tr>
    </>);
}