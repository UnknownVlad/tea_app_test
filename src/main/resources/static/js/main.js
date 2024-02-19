const usernameEl = document.querySelector('#name');
const surnameEl = document.querySelector('#surname');
const emailEl = document.querySelector('#email');
const passwordEl = document.querySelector('#password');
const confirmPasswordEl = document.querySelector('#repeat_password');

const form = document.querySelector('#registration');
const btn = document.querySelector("#button");

confirmPasswordEl.onpaste = e => {
  e.preventDefault();
  return false;
};

const checkUsername = () => {

    let valid = false;

    const min = 2,
        max = 25;

    const username = usernameEl.value.trim();

    if (!isRequired(username)) {
        showError(usernameEl, 'Поле не может быть пустым.');
    } else if (!isBetween(username.length, min, max)) {
        showError(usernameEl, `Длина имени должна быть не меньше ${min} символов и не больше ${max} символов.`)
    } else {
        showSuccess(usernameEl);
        valid = true;
    }
    return valid;
};

const checkSurname = () => {

    let valid = false;

    const min = 2,
        max = 25;

    const surname = surnameEl.value.trim();

    if (!isRequired(surname)) {
        showError(surnameEl, 'Поле не может быть пустым.');
    } else if (!isBetween(surname.length, min, max)) {
        showError(surnameEl, `Длина фамилии должна быть не меньше ${min}  символов и не больше ${max} символов.`)
    } else {
        showSuccess(surnameEl);
        valid = true;
    }
    return valid;
};


const checkEmail = () => {
    let valid = false;
    const email = emailEl.value.trim();
    if (!isRequired(email)) {
        showError(emailEl, 'Поле не может быть пустым.');
    } else if (!isEmailValid(email)) {
        showError(emailEl, 'Email недействителен.')
    } else {
        showSuccess(emailEl);
        valid = true;
    }
    return valid;
};

const checkPassword = () => {
    let valid = false;


    const password = passwordEl.value.trim();

    if (!isRequired(password)) {
        showError(passwordEl, 'Поле не может быть пустым.');
    } else if (!isPasswordSecure(password)) {
        showError(passwordEl, 'Минимум 8 символов: буквы верхнего и нижнего регистра, цифры');
    } else {
        showSuccess(passwordEl);
        valid = true;
    }

    return valid;
};

const checkConfirmPassword = () => {
    let valid = false;
    const confirmPassword = confirmPasswordEl.value.trim();
    const password = passwordEl.value.trim();

    if (!isRequired(confirmPassword)) {
        showError(confirmPasswordEl, 'Пожалуйста, введите пароль еще раз');
    } else if (password !== confirmPassword) {
        showError(confirmPasswordEl, 'Пароли не совпадают');
    } else {
        showSuccess(confirmPasswordEl);
        valid = true;
    }

    return valid;
};

const isEmailValid = (email) => {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
};

const isPasswordSecure = (password) => {
    const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})");
    // const re = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    return re.test(password);
};

const isRequired = value => value === '' ? false : true;
const isBetween = (length, min, max) => length < min || length > max ? false : true;


const showError = (input, message) => {
    const formField = input.parentElement;
    formField.classList.remove('success');
    formField.classList.add('error');

    const error = formField.querySelector('small');
    error.textContent = message;
};

const showSuccess = (input) => {
    const formField = input.parentElement;

    formField.classList.remove('error');
    formField.classList.add('success');

    const error = formField.querySelector('small');
    error.textContent = '';
}

const ajaxSend = async (formData) => {
    const response = await fetch('/registration', {
                           method: 'POST',
                           body: formData
                       });
                       if (!response.ok) {
                            btn.classList.remove("button--loading");
                            let result = await response.json();
//                            alert(result.message);
                            showError(emailEl, result.message);
                            throw new Error('Ошибка');
                       }
    return await response.text();
};

form.addEventListener('submit', async function (e) {
    e.preventDefault();

    let isUsernameValid = checkUsername(),
        isEmailValid = checkEmail(),
        isPasswordValid = checkPassword(),
        isConfirmPasswordValid = checkConfirmPassword();

    let isFormValid = isUsernameValid &&
        isEmailValid &&
        isPasswordValid &&
        isConfirmPasswordValid;

    let formData = new FormData(form);
    if (isFormValid) {
        btn.classList.add("button--loading");
        ajaxSend(formData).then((response) => {
            console.log(response);
            form.reset();
            btn.classList.remove("button--loading");
//            alert(response);
        })
        .catch((err) => console.error(err))
    }
});


const debounce = (fn, delay = 500) => {
    let timeoutId;
    return (...args) => {
        if (timeoutId) {
            clearTimeout(timeoutId);
        }
        timeoutId = setTimeout(() => {
            fn.apply(null, args)
        }, delay);
    };
};

form.addEventListener('input', debounce(function (e) {
    switch (e.target.id) {
        case 'name':
            checkUsername();
            break;
        case 'surname':
            checkSurname();
            break;    
        case 'email':
            checkEmail();
            break;
        case 'password':
            checkPassword();
            break;
        case 'repeat_password':
            checkConfirmPassword();
            break;
    }
}));
