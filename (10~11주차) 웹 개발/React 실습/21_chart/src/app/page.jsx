import Link from "next/link";
// npm install @mui/material @emotion/react @emotion/styled
// npm install @mui/x-charts
export default function Home(){

    return(
        <div>
            <h3>Chart Library 모음</h3>
            <Link href="/bar">Bar Chart</Link>
            <br/>
            <Link href="/line">Line Chart</Link>
            <br/>
            <Link href="/pie">Pie Chart</Link>
            <br/>
            <Link href="/scatter">Scatter Chart</Link>
        </div>
    );
}