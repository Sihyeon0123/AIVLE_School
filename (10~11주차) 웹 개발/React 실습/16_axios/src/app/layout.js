export default function Layout({ children }) {
  // page 를 담는 Layout
  return (<html>
  <head>
    <title>Next.js Main Page!!</title>
  </head>
  <body>
  <div>
    {children}
  </div>
  </body>
  </html>);

}