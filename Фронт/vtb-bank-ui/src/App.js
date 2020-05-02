import React from 'react';
import './App.css';
import Switch from "react-router-dom/es/Switch";
import Route from "react-router-dom/es/Route";
import {Authorization, MainPage} from "./containers";
import Redirect from "react-router-dom/es/Redirect";


function App() {
    return (
        <Switch>
            <Route path="/auth">
                <Authorization/>
            </Route>
            <Route path="/main">
                <MainPage/>
            </Route>
            <Route exact path="/" render={() => (
                <Redirect to="/auth/sign_in"/>
            )}/>
        </Switch>
    );
}

export default App;
