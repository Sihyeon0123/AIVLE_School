//npm install react-bootstrap bootstrap
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button, ButtonToolbar } from "react-bootstrap";

export default function Home(){

    /* 교안에 있는 버튼 모양대로 나타나도록 속성을 추가해 보자 */
    return( 
        <div>
            <ButtonToolbar>
                <Button variant="primary">Primary</Button>
                <Button variant="secondary">Secondary</Button>
                <Button variant="success">Success</Button>
                <Button variant="warning">Warning</Button>
                <Button variant="danger">Danger</Button>
                <Button variant="info">Info</Button>
                <Button variant="light">Light</Button>
                <Button variant="dark">Dark</Button>
                <Button variant="link">Link</Button>
            </ButtonToolbar>
        </div>
    );
}