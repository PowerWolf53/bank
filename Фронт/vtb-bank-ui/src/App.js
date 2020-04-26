import React from 'react';
import './App.css';
import Switch from "react-router-dom/es/Switch";
import Route from "react-router-dom/es/Route";
import {Authorization, MainPage} from "./containers";


function App() {
    return (
        <Switch>
            <Route path="/auth">
                <Authorization/>
            </Route>
            <Route path="/main">
                <MainPage/>
            </Route>
        </Switch>
    );
}

export default App;
