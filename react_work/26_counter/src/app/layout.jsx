'use client'
import {Provider} from "react-redux";
import {store} from "@/redux/store";

export default function RootLayout({ children }) {
    return (
        <html lang="ko">
        <body>
        {/*3. Provider 추가*/}
        <Provider store={store}>{children}</Provider>
        </body>
        </html>
    );
}
