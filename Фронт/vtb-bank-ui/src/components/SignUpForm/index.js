import React, {useState} from 'react'
import './css/index.css'
import withRouter from "react-router-dom/es/withRouter";
import Link from "react-router-dom/es/Link";

const SignUpForm = ({handleSignUpClick}) => {

    const [login, setLogin] = useState(' ');
    const [password, setPassword] = useState(' ');
    const [confirmPassword, setConfirmPassword] = useState(' ');
    const [name, setName] = useState(' ');
    const [surname, setSurname] = useState(' ');

    return (
        <div className='sign-in-aside'>
            <div className='meta-info-container'>
                <span className='register-header'>Регистрация</span>
                <span className='password-enter-label'>Заполните профиль</span>
            </div>

            <div className='credentials-container'>
                <div className='credentials-input-container'>
                    <label className='credentials-login-label'>Имя</label>
                    <input onChange={(event) => setName(event.target.value)} className='credentials-input' type='text'/>
                </div>

                <div className='credentials-input-container'>
                    <label className='credentials-login-label'>Фамилия</label>
                    <input onChange={(event) => setSurname(event.target.value)} className='credentials-input'
                           type='text'/>
                </div>


                <div className='credentials-input-container'>
                    <label className='credentials-login-label'>Логин</label>
                    <input onChange={(event) => setLogin(event.target.value)} className='credentials-input'
                           type='text'/>
                </div>

                <div className='credentials-input-container'>
                    <label className='credentials-login-label'>Пароль</label>
                    <input onChange={(event) => setPassword(event.target.value)} className='credentials-input'
                           type='password'/>
                </div>

                <div className='credentials-input-container'>
                    <label className='credentials-login-label'>Подтверждение пароля</label>
                    <input onChange={(event) => setConfirmPassword(event.target.value)} className='credentials-input'
                           type='password'/>
                </div>
            </div>

            <button onClick={() => handleSignUpClick(login, password, confirmPassword, name, surname)}
                    className='register-button' type='submit'>
                Регистрация
            </button>

            <div className='registration-link'>
                <Link to='sign_in'>
                    <a className='auth-link'>Войти</a>
                </Link>
            </div>
        </div>
    );
};

export default withRouter(SignUpForm);