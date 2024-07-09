const form = document.querySelector('form');
const URL = "http://localhost:8080"; // Verifique se está correto para o seu ambiente

const token = localStorage.getItem('token');

function registerUser(body) {
    const options = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify(body), // Converte o objeto JavaScript para JSON
    };

    fetch(URL + "/user", options)
        .then(response => response.json())
        .then(data => {
            console.log('Cadastrado:', data);
            // Aqui você pode lidar com a resposta do servidor, se necessário
        })
        .catch(error => console.error('Erro ao cadastrar:', error));
}

// function getUserData(userId) {
//     const options = {
//         method: 'GET',
//         headers: {
//             'Content-Type': 'application/json',
//             'Authorization': `Bearer ${token}`
//         },
//         // Não há corpo em uma requisição GET, então body é omitido
//     };

//     fetch(`${URL}/user/${userId}`, options)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error('Erro ao realizar a requisição GET');
//             }
//             return response.json();
//         })
//         .then(data => {
//             console.log('Dados do usuário:', data);
//             // Aqui você pode processar os dados recebidos do servidor
//         })
//         .catch(error => {
//             console.error('Erro ao buscar dados do usuário:', error);
//         });
// }