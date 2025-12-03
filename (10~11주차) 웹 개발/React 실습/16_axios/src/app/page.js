import SendList from "./SendList";

export default function Home() {

  const url = 'https://jsonplaceholder.typicode.com/posts/';

  return (
      <div>
        <SendList url={url} />
      </div>
  );
}
