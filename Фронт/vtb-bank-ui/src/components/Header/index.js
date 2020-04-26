import React, {useState} from 'react'
import './css/index.css'
import {withRouter} from "react-router-dom";
import AddMoney from '../AddMoney'
import Rodal from 'rodal';

const Header = ({userData, history, addMoneyClicked}) => {

    const [countModalVisible, setCountModalVisible] = useState(false);


    const handleExitClick = ()=>{
        localStorage.removeItem('token');
        history.push('/auth/sign_in')
    };

    const handleModalAddClick = (sum) =>{
        addMoneyClicked(sum);
        setCountModalVisible(false)
    };


    return (
        <>
            <Rodal width={350} height={300} visible={countModalVisible} onClose={()=> setCountModalVisible(false)} >
                <AddMoney handleAddClick = { handleModalAddClick}/>
            </Rodal>
        <header className='header'>
            <div className='header-logo'/>
            <div className='count'>
                <span>{userData.count} RUB</span>
                <div onClick={()=>setCountModalVisible(true)} className='money'/>
            </div>


            <div className='user-info'>
                <div className='avatar'/>
                <div className='name-container'>
                    <span>{userData.name}</span>
                </div>
                <div onClick={handleExitClick} className='exit'>

                </div>

            </div>


        </header>
            </>
    )
};

export default withRouter(Header)