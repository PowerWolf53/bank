import React, {useEffect, useState} from 'react'
import withRouter from "react-router-dom/es/withRouter";
import { CreditModal, DepositModal, Header} from "../../components";
import './css/index.css'
import Clock from 'react-clock';
import * as moment from "moment";
import Rodal from 'rodal';
import 'rodal/lib/rodal.css';
import * as handlers from './handlers'
import * as swall from './swall'
import Operations from '../Operations'



const MainPage = () => {

    const [date, setDate] = useState(new Date());

    const [userData, setUserData] = useState({name: '', count: 0, deposits: [], credits:[]});

    const [creditModalVisible, setCreditModalVisible] = useState(false);

    const [depositModalVisible, setDepositModalVisible] = useState(false);

    useEffect(() => {
        setInterval(
            () => setDate(new Date),
            1000
        );
        setInterval(
            () => {
                const secs =new Date().getSeconds();
                if(secs === 0){
                    getUserInfo();
                }
            },
            1000
        );
        getUserInfo();
    },[]);

    const getUserInfo = () => {
         handlers.requestUserInfo().then(resp => {
             setUserData(
                 {
                     name:resp.data.name,
                     count: resp.data.count,
                     deposits: resp.data.deposits,
                     credits: resp.data.credits
                 })
         });
    };


    const handleAddMoney = (sum) => {
       handlers.addMoney(sum).then(resp => {
            getUserInfo();
            swall.fireSuccess('Счёт пополнен')
        })
    };

    const handleAddDeposit = (title, sum, percent) =>{
        setDepositModalVisible(false);
        handlers.addDeposit(title, sum, percent).then(resp => {
            getUserInfo();
            swall.fireSuccess('Депозит оформлен');
        })
    };

    const handleDeleteDeposits = (ids) =>{
        if(ids.length){
            handlers.deleteDeposits(ids).then(()=>{
                getUserInfo();
                swall.fireSuccess('Депозиты возвращены');
            })
        }

    };

    const handleAddCredit= (title, sum, percent) =>{
        setCreditModalVisible(false);
        handlers.addCredit(title, sum, percent).then(resp => {
            getUserInfo();
            swall.fireSuccess('Кредит оформлен');
        })

    };

    const getTotalSumOfCredits = (ids)=>{
        let totalSum = 0;
        ids.forEach(id=>{
            const credit = userData.credits.find(credit=> credit.id === id)
            totalSum+= credit.sum;
        });
        return totalSum;
    };

    const handleDeleteCredits = (ids) =>{
        if(ids.length){
            const totalSum = getTotalSumOfCredits(ids);
            if(totalSum<= userData.count) {
                handlers.deleteCredits(ids).then(() => {
                    getUserInfo();
                    swall.fireSuccess('Кредиты погашены');
                })
            }else{
                swall.fireError('Не достаточно средств')
            }
        }

    };


    return (
        <div>

            <Rodal width={350} height={400} visible={creditModalVisible} onClose={() => setCreditModalVisible(false)}>
                <CreditModal insertClicked={handleAddCredit}/>
            </Rodal>
            <Rodal width={350} height={400} visible={depositModalVisible} onClose={() => setDepositModalVisible(false)}>
                <DepositModal insertClicked={handleAddDeposit}/>
            </Rodal>



            <Header addMoneyClicked={handleAddMoney} userData={userData}/>
            <div className='main-container'>
                <div className='main-part'>

                    <div className='clock-wrapper'>
                        <div className='clock-container'>
                            <Clock
                                value={date}
                            />
                        </div>
                        <div className='time-span'>
                            <span>{moment(date).format("hh:mm:ss A")}</span>
                        </div>
                    </div>

                    <div className='operations-container'>
                            <Operations addDepositClicked={()=>setDepositModalVisible(true)}
                                        deleteDepositsClicked = {(ids)=>handleDeleteDeposits(ids)}
                                        deposits = {userData.deposits}
                                        addCreditClicked={()=>setCreditModalVisible(true)}
                                        deleteCreditsClicked={(ids)=>handleDeleteCredits(ids)}
                                        credits = {userData.credits}

                            />
                    </div>
                </div>
            </div>
        </div>
    )
};

export default withRouter(MainPage)