import React from 'react'
import './css/index.css'
import withRouter from "react-router-dom/es/withRouter";
import Link from "react-router-dom/es/Link";
import {useState} from "react";


const SignInForm = ({handleSignInClick}) => {

    const [login, setLogin] = useState(' ');
    const [password, setPassword] = useState(' ');

    const handleLoginInsert = (event) => {
        setLogin(event.target.value);
    };

    const handlePasswordInsert = (event) => {
        setPassword(event.target.value);
    };

    const handleButtonClick = (event) =>{
        handleSignInClick(login, password)
    };

    return (
        <div className='sign-in-aside'>
            <div className='vtb-logo-container'/>

            <div className='sign-in-meta-info-container'>
                <span className='meta-info-header'>Вход в интернет-банк</span>
                <span className='password-enter-label'>Парольный доступ</span>
            </div>

            <div className='credentials-container'>
                <div className='credentials-input-container'>
                    <label className='credentials-login-label'>Логин</label>
                    <input onChange={handleLoginInsert} className='credentials-input' type='text'/>
                </div>

                <div className='credentials-input-container'>
                    <label className='credentials-login-label'>Пароль</label>
                    <input onChange={handlePasswordInsert} className='credentials-input' type='password'/>
                </div>
            </div>

            <button onClick={handleButtonClick} className='inset-button' type='submit'>
                Войти
            </button>

            <div className='registration-link'>
                <Link to='sign_up'>
                    <a className='auth-link'>Регистрация</a>
                </Link>
            </div>
        </div>
    );

};

export default withRouter(SignInForm);