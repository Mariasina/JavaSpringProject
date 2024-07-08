// import 'regenerator-runtime/runtime';
// import axios from 'axios';

// const form = document.querySelector('form');
// const login_data = document.getElementById('login').value;
// const deparment_data = document.getElementById('department').value;
// const role_data = document.getElementById('role').value;

// const URL = "http://localhost:8080";

// form.addEventListener('submit', async event => {
//     registerUser({
//         login : login_data,
//         department : '2',
//         role : '1'
//     })
// });

// function registerUser (body) {
//     const options = {
//         method: 'POST',
//         body: Object.keys(body)
//         .map(k => `${encodeURIComponent(k)}=${encodeURIComponent(body[k])}`)
//         .join('&')
//     }
//     .then(() => console.log('cadastrado'))

//     return fetch(URL + "/user", options)
//       .then(T => T.json())
//   }