/*=============== SHOW MODAL 1 ===============*/
const showModal_1 = (openButton, modalContent) =>{
    const openBtn = document.getElementById(openButton),
    modalContainer = document.getElementById(modalContent)
    
    if(openBtn && modalContainer){
        openBtn.addEventListener('click', ()=>{
            modalContainer.classList.add('show-modal')
        })
    }
}
showModal_1('open-modal_1','modal-container_1')

/*=============== CLOSE MODAL 1 ===============*/
const closeBtn_1 = document.querySelectorAll('.close-modal')

function closeModal_1(){
    const modalContainer = document.getElementById('modal-container_1')
    modalContainer.classList.remove('show-modal')
}
closeBtn_1.forEach(c => c.addEventListener('click', closeModal_1))

/*=============== SHOW MODAL 2 ===============*/
const showModal_2 = (openButton, modalContent) =>{
    const openBtn = document.getElementById(openButton),
    modalContainer = document.getElementById(modalContent)

    
    if(openBtn && modalContainer){
        openBtn.addEventListener('click', ()=>{
            modalContainer.classList.add('show-modal')
            closeModal_1();

        })
    }

}
showModal_2('open-modal_2','modal-container_2')

/*=============== CLOSE MODAL 2 ===============*/
const closeBtn_2 = document.querySelectorAll('.close-modal')

function closeModal_2(){
    const modalContainer = document.getElementById('modal-container_2')
    modalContainer.classList.remove('show-modal')
}
closeBtn_2.forEach(c => c.addEventListener('click', closeModal_2))

// function toggle() {
//     let input_toggle = document.getElementById('toggle_button')
//     let password_input = document.getElementById('password')

//     if (password_input.type === 'password') {
//         password_input.type = 'text'
//         toggle_button.innerHTML = `
//         <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
//             <path d="M3.58692 13.7789C5.36636 15.5479 8.46965 18 12.0003 18C15.531 18 18.634 15.5479 20.4134 13.7789L20.4142 13.778C20.8833 13.3117 21.1182 13.0782 21.2676 12.6202C21.3742 12.2934 21.3742 11.7066 21.2676 11.3798C21.1182 10.9218 20.8833 10.6883 20.4142 10.2219L20.4134 10.2211C18.634 8.45208 15.531 6 12.0003 6C8.46965 6 5.36636 8.45208 3.58692 10.2211C3.11726 10.688 2.88241 10.9215 2.73292 11.3798C2.6263 11.7066 2.6263 12.2934 2.73292 12.6202C2.8824 13.0785 3.11724 13.3119 3.58686 13.7788L3.58692 13.7789Z" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
//         </svg>`
//     } else {
//         password_input.type = 'password'
//         toggle_button.innerHTML = `
//         <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
//             <path d="M4.00001 4L20 20M16.5 16.756C15.1474 17.4846 13.6186 18 12 18C8.46936 18 5.36636 15.5479 3.58693 13.7789C3.11722 13.3119 2.88241 13.0785 2.73292 12.6202C2.62631 12.2933 2.62628 11.7064 2.73292 11.3796C2.88246 10.9213 3.11776 10.6874 3.58839 10.2196C4.48528 9.32815 5.71813 8.26353 7.17232 7.4267M19.5 14.6336C19.8331 14.3407 20.1381 14.0525 20.4118 13.7805C20.8825 13.3126 21.1177 13.0787 21.2672 12.6204C21.3738 12.2936 21.3742 11.7067 21.2676 11.3799C21.1181 10.9216 20.8831 10.6881 20.4134 10.2211C18.634 8.45208 15.5307 6 12 6C11.6625 6 11.3289 6.02241 11 6.06448M13.3229 13.4999C12.9704 13.8111 12.5072 13.9999 12 13.9999C10.8954 13.9999 10 13.1045 10 11.9999C10 11.4604 10.2136 10.9708 10.5609 10.6111" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
//         </svg>`
//     }
// }

