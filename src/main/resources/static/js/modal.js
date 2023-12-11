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

/*=============== PASSWORD HIDE ===============*/
function show_hide_password_reg(target){
	var password = document.querySelector('#password');
	if (password.getAttribute('type') == 'password') {
		target.classList.add('view');
		password.setAttribute('type', 'text');
	} else {
		target.classList.remove('view');
		password.setAttribute('type', 'password');
	}
	return false;
}

function show_hide_password_auth(target){
    var password_auth = document.querySelector('#password_auth');
	if (password_auth.getAttribute('type') == 'password') {
		target.classList.add('view');
		password_auth.setAttribute('type', 'text');
	} else {
		target.classList.remove('view');
		password_auth.setAttribute('type', 'password');
	}
	return false;
}