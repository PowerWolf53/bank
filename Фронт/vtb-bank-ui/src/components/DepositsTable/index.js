import React, {useEffect, useState} from 'react'
import './css/index.css'
import MaterialTable from 'material-table';
import DribbleButton from 'react-dribble-button';


const DepositsTable = ({addDepositClicked, deleteDepositsClicked, deposits}) => {

    const [data, setData] = useState([]);

    const [selectedIds, setSelectedIds] = useState([]);

    useEffect(() => {
        deposits ? setData(deposits): setData([]);
    },[deposits]);

    const handleSelect = (rows) =>{
        const selected = rows.map(row=> row.id);
        setSelectedIds(selected)
    };


    const columns = [
        {title: 'Название', field: 'title'},
        {title: 'Сумма', field: 'sum'},
        {title: 'Процент', field: 'percent', type: 'numeric'},
    ];


    return (
        <>
            <div className='actions-bar'>
                <div className='delete-wrapper'>
                <div onClick={()=>deleteDepositsClicked(selectedIds)} className='delete-container'>

                </div>
                </div>
            </div>
            <div className='table-container'>
        <MaterialTable
            title="Список Депозитов"
            columns={columns}
            data={data}
            options={{
                selection: true,
                maxBodyHeight: 230
            }}
            onSelectionChange={(rows) => handleSelect(rows)}
        />
                <DribbleButton onClick = {addDepositClicked} color="amber"   animationDuration={1000} >
                    Оформить
                </DribbleButton>
            </div>
            </>
    );
};

export default DepositsTable;