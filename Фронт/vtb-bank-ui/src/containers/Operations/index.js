import React from 'react'
import {Tab, TabList, TabPanel, Tabs} from 'react-tabs';
import 'react-tabs/style/react-tabs.css';
import {CreditTable, DepositsTable} from '../../components'
import './css/index.css'


const Operations = ({
                        addDepositClicked,
                        deleteDepositsClicked,
                        deposits,
                        addCreditClicked,
                        deleteCreditsClicked,
                        credits
                    }
) => {
    const handleDeleteDeposits = (ids) => {
        deleteDepositsClicked(ids)
    };

    const handleDeleteCredits = (ids) => {
        deleteCreditsClicked(ids)
    };



    return (
        <>
            <div className='operation-tabs'>
                <Tabs>
                    <TabList>
                        <Tab>Кредиты</Tab>
                        <Tab>Депозиты</Tab>
                    </TabList>

                    <TabPanel>
                        <CreditTable addCreditClicked ={addCreditClicked}
                                     deleteCreditsClicked={(ids)=> handleDeleteCredits(ids)}
                                     credits = {credits}

                        />
                    </TabPanel>
                    <TabPanel>
                        <DepositsTable addDepositClicked={addDepositClicked}
                                       deleteDepositsClicked={(ids) => handleDeleteDeposits(ids)}
                                       deposits={deposits}
                        />
                    </TabPanel>
                </Tabs>
            </div>
        </>
    )
};

export default Operations