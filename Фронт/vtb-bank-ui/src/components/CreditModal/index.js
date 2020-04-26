import React,{useState} from 'react'
import './css/index.css'
import DribbleButton from 'react-dribble-button';


const CreditModal = ({insertClicked}) =>{
    const [title, setTitle] = useState('');
    const [sum, setSum] = useState(0);
    const [percent, setPercent] = useState(0);

    const handleInsertClick = () =>{
        insertClicked(title, sum, percent)
    };
    return(
        <div className='credit-modal'>
                <span>Оформление кредита</span>
            <div className='input-container'>
                <label className='credit-label'>Название</label>
                <input onChange={(event)=>setTitle(event.target.value)} type='text' className='credit-input'/>
            </div>
            <div className='input-container'>
                <label className='credit-label'>Сумма</label>
                <input onChange={(event)=>setSum(event.target.value)} type='number' className='credit-input'/>
            </div>
            <div className='input-container'>
                <label className='credit-label'>Процент в минуту %</label>
                <input onChange={(event)=>setPercent(event.target.value)} type='number' className='credit-input'/>
            </div>
            <div  className='credit-button-container'>
                <DribbleButton onClick = {handleInsertClick} color="indigo"   animationDuration={1000} >
                    Оформить
                </DribbleButton>
            </div>
        </div>
    )
};

export default CreditModal;