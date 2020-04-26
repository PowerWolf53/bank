import Swal from "sweetalert2";

export const fireSuccess = (msg) =>{
    Swal.fire(
        '',
        msg,
        'success'
    );
};

export const fireError = (msg) =>{
    Swal.fire({
        icon: 'error',
        title: 'Операция не завершена',
        text: msg,
    })
};