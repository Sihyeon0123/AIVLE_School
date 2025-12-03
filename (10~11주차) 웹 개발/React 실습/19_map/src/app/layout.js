export default function Layout({ children }) {

  /*발급받은 키를 적용해 보자*/
  const api_key = 'YOUR_API_KEY';

  return (
      <html lang="ko">
      <head>
        <meta charSet="utf-8" />
        <script src={`https://dapi.kakao.com/v2/maps/sdk.js?appkey=${api_key}&autoload=false`}></script>
      </head>
      <body>
      {children}
      </body>
      </html>
  );
}