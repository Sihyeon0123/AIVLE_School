//npm install react-bootstrap bootstrap
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button, ButtonToolbar } from "react-bootstrap";

export default function Home(){

    /* 교안에 있는 버튼 모양대로 나타나도록 속성을 추가해 보자 */
    return( 
        <div>
            <ButtonToolbar>
                <Button>Primary</Button>
                <Button>Secondary</Button>
                <Button>Success</Button>
                <Button>Warning</Button>
                <Button>Danger</Button>
                <Button>Info</Button>
                <Button>Light</Button>
                <Button>Dark</Button>
                <Button>Link</Button>
            </ButtonToolbar>
        </div>
    );
}