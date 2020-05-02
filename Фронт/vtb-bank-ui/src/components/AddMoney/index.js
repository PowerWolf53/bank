import React, {useState} from 'react'
import DribbleButton from 'react-dribble-button';
import './css/index.css'

const AddMoney = ({handleAddClick}) =>{

    const [amount, setAmount] = useState(0);

    return(
        <div className='credit-modal'>
            <span>Пополнение счёта</span>
            <div className='input-container'>
                <label className='credit-label'>Сумма RUB</label>
                <input onChange={(event)=>setAmount(event.target.value)} type='text' className='credit-input'/>
            </div>
            <div className='input-container'>
                <label className='credit-label'>Номер карты</label>
                <input type='number' className='credit-input'/>
            </div>
            <div className='credit-button-container'>
                <DribbleButton onClick = {()=>handleAddClick(amount)} color="amber"   animationDuration={1000} >
                    Пополнить
                </DribbleButton>
            </div>
        </div>
    )
};

export default AddMoney