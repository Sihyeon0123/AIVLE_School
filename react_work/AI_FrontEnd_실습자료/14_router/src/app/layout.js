import styles from './page.module.css';

export default function MainLayout({ children }) {
  // page 를 담는 Layout
  return (<html>
  <head>
    <title>Next.js Main Page!!</title>
  </head>
  <body>
  <div className={styles.layout}>
    {children}
  </div>
  </body>
  </html>);

}