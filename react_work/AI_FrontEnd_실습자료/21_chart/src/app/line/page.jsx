"use client" // 이벤트 등의 기능을 사용하기 위해서는 use client 를 넣어주자!
import {LineChart} from "@mui/x-charts/LineChart";

export default function Page(){

    return (<>
            <div style={{width: '30%', float: 'left'}}>
                {/* 교안에 있는 그래프 모양이 나타나도록 차트를 추가해 보자 */}
            </div>

            <div style={{width: '30%', float: 'left'}}>
                <LineChart
                    xAxis={[{ data: [1, 2, 3, 5, 8, 10] }]}
                    series={[
                        {
                            data: [2, 5.5, 2, 8.5, 1.5, 5],
                            area:true,
                            color: 'red'
                        },
                    ]}
                    width={500}
                    height={300}
                />
            </div>

            <div style={{width: '30%', float: 'left'}}>
                <LineChart
                    xAxis={[{ scaleType: "band",data: ['1분기', '2분기','3분기','4분기']}]}
                    series={[
                        {
                            data: [3,4,2,6],
                            label:'A',
                            area:true,
                            stack:'total',
                            highlightScope:{ /*마우스 오버시 살짝 밝아짐*/
                                highlight:'item',
                            }
                        },
                        {
                            data: [4,3,1,5],
                            label:'B',
                            area:true,
                            stack:'total',
                            highlightScope:{
                                highlight:'item',
                            }
                        },
                        {
                            data: [4,2,5,4],
                            label:'C',
                            area:true,
                            stack:'total',
                            highlightScope:{
                                highlight:'item',
                            }
                        },
                    ]}
                    width={500}
                    height={300}
                    onAreaClick={(evt,data)=>console.log(evt,data)}
                    onMarkClick={(evt,data)=>console.log(evt,data)}
                    onLineClick={(evt,data)=>console.log(evt,data)}
                />
            </div>

        </>
    );
}