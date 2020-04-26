import React, {useEffect, useState} from 'react'
import './css/index.css'
import MaterialTable from 'material-table';
import DribbleButton from 'react-dribble-button';


const CreditTable = ({addCreditClicked, deleteCreditsClicked, credits}) => {

    const [data, setData] = useState([]);

    const [selectedIds, setSelectedIds] = useState([]);

    useEffect(() => {
        credits ? setData(credits): setData([]);
    },[credits]);

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
                    <div onClick={()=>deleteCreditsClicked(selectedIds)} className='delete-container'>

                    </div>
                </div>
            </div>
            <div className='table-container'>
                <MaterialTable
                    title="Список Кредитов"
                    columns={columns}
                    data={data}
                    options={{
                        selection: true,
                        maxBodyHeight: 230
                    }}
                    onSelectionChange={(rows) => handleSelect(rows)}
                />
                <DribbleButton onClick = {addCreditClicked} color="indigo"   animationDuration={1000} >
                    Оформить
                </DribbleButton>
            </div>
        </>
    );
};

export default CreditTable;