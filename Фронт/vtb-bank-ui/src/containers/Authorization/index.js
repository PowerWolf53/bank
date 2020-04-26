import React, {useState} from 'react'
import withRouter from "react-router-dom/es/withRouter";
import {SignUpForm, SignInForm} from "../../components";
import './css/index.css'
import axios from 'axios';
import Swal from 'sweetalert2'
import Switch from "react-router-dom/es/Switch";
import Route from "react-router-dom/es/Route";



const Authorization = (props) => {

    const handleSignInClick= (login, password) => {
        axios.post(`http://localhost:8080/api/vtb/auth/sign_in`, {login, password})
            .then(res => {
                Swal.fire(
                    '',
                    'Вход выполнен',
                    'success'
                );
                localStorage.setItem('token', res.data.token);
                props.history.push('/main')
            }).catch(error => {
            Swal.fire({
                icon: 'error',
                title: 'Доступ запрещён!',
                text: 'Неверный логин или пароль!',
            })
        })
    };

    const handleSignUpClick= (login, password, confirmPassword, name, surname) => {
        axios.post(`http://localhost:8080/api/vtb/auth/sign_up`, {login, password, confirmPassword, name, surname})
            .then(res => {
                Swal.fire(
                    '',
                    'Регистрация прошла успешно',
                    'success'
                );
                props.history.push('/auth/sign_in')
            }).catch(error => {
            Swal.fire({
                icon: 'error',
                title: 'Ошибка Регистрации',
                text: 'Возможно такой пользователь уже существует',
            })
        })
    };

    return (
        <div className="authorization-container">
            <div className='sign-in-container'>
                <Switch>
                    <Route exact path="/auth/sign_up">
                        <SignUpForm
                            handleSignUpClick={handleSignUpClick}
                        />
                    </Route>
                    <Route exact path="/auth/sign_in">
                        <SignInForm
                            handleSignInClick={handleSignInClick}
                        />
                    </Route>

                </Switch>
                <div className='post-container'>
                    <div className='number-container'>
                        <label className='number'>+345 (17) 309-15-15</label>
                    </div>
                    <div className='post'/>
                    <div className='mobile-post'/>
                </div>
            </div>
        </div>
    )
};

export default withRouter(Authorization)