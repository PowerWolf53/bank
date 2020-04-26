import axios from "axios/index";
import Swal from "sweetalert2";
import * as constants from '../../../assets/constants'
import * as entrypoints from '../../../assets/entrypoints'

export const requestUserInfo = async () => {
    return await axios.get(`${constants.SERVER_ENTRY}/${entrypoints.USER_INFO}`, {
        headers: buildHeaders()
    });
};

export const addMoney = async (sum) => {
    return await axios.post(`${constants.SERVER_ENTRY}/${entrypoints.ADD_MONEY}`,
        {
            amount: sum
        },
        {
            headers: buildHeaders(),

        })
};

export const addDeposit = async (title, sum, percent) =>{
    return await axios.post(`${constants.SERVER_ENTRY}/${entrypoints.ADD_DEPOSIT}`,
        {
            title,
            sum,
            percent
        },
        {
            headers: buildHeaders(),

        })
};

export const addCredit = async (title, sum, percent) =>{
    return await axios.post(`${constants.SERVER_ENTRY}/${entrypoints.ADD_CREDIT}`,
        {
            title,
            sum,
            percent
        },
        {
            headers: buildHeaders(),

        })
};

export const deleteDeposits = async (ids) =>{
    return await axios.post(`${constants.SERVER_ENTRY}/${entrypoints.DELETE_DEPOSIT}`,
        {
            ids
        },
        {
            headers: buildHeaders(),
        })
};

export const deleteCredits = async (ids) =>{
    return await axios.post(`${constants.SERVER_ENTRY}/${entrypoints.DELETE_CREDIT}`,
        {
            ids
        },
        {
            headers: buildHeaders(),
        })
};

const buildHeaders = () =>{
    const token = localStorage.getItem('token');
    return {
        'Authorization': token,
        'Content-Type': 'application/json'
    }
};