"use client"
import {PieChart} from "@mui/x-charts/PieChart";

export default function Page(){
    return (<>
            <div style={{width: '30%', float: 'left'}}>
                <PieChart
                    series={[
                        {
                            data: [
                                {value: 10, label: 'series A' },
                                {value: 15, label: 'series B' },
                                {value: 20, label: 'series C' },
                            ],
                        },
                    ]}
                    width={400}
                    height={200}
                />
            </div>
            <div style={{width: '30%', float: 'left'}}>
                {/* 교안에 있는 그래프 모양이 나타나도록 차트를 추가해 보자 */}
            </div>
            <div style={{width: '30%', float: 'left'}}>
                <PieChart
                    series={[
                        {
                            data: [
                                {value: 10, label: 'Other' },
                                {value: 15, label: 'Linux' },
                                {value: 20, label: 'Mac OS' },
                                {value: 55, label: 'Window' },
                            ],
                            highlightScope: { fade: 'global', highlight: 'item' }, // 강조효과
                            // fade 에 대한 상세 디자인 옵션을 변경 할 수 있다.
                            faded: { innerRadius: 30, additionalRadius: -30, color: 'gray' },
                            arcLabel:(item)=> `${item.value}%`
                        }
                    ]}
                    width={400}
                    height={200}
                    onItemClick={(evt,data)=>console.log(evt,data)}
                />
            </div>

        </>
    );
}