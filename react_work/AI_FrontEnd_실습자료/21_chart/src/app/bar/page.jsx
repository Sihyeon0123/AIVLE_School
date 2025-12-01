import { BarChart } from '@mui/x-charts/BarChart';

export default function Page(){
    return (
        <>
            <div style={{width:'30%',float:'left'}}>
                <BarChart
                    series={[{data:[4,2,3,5], label:'성장률'}]}/*막대 하나하나의 내용*/
                    /*scaleType:'band' 가 있어야 data 에 문자열이 들어갈 수 있음*/
                    xAxis={[{data:['1분기','2분기','3분기','4분기'], scaleType:'band'}]}/*X 축의 내용*/
                    width={500}
                    height={300}
                    barLabel={"value"}/*Bar 에 표시될 내용*/
                    borderRadius={10}
                    grid={{horizontal:true}}
                />
            </div>

            <div style={{width:'30%',float:'left'}}>
            {/* 교안에 있는 그래프 모양이 나타나도록 차트를 추가해 보자 */}
            </div>

            {/*stack 이름이 같아야 같은 이름끼리 쌓이게 된다.*/}
            <div style={{width: '30%', float: 'left'}}>
                <BarChart series={[
                    {data: [4000, 3000, 2000, 2780], label:'pv', stack:'stack1'},
                    {data: [2400, 1398, 9800, 3908], label:'uv', stack:'stack1'},
                ]}
                          xAxis={[{scaleType: "band", data: ['1분기', '2분기', '3분기','4분기']}]}
                          width={500} height={300}
                />
            </div>
        </>
    );
}