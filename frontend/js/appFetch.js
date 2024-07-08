const form = document.querySelector('form');
const URL = "http://localhost:8080"; // Verifique se está correto para o seu ambiente

form.addEventListener('submit', async event => {
    event.preventDefault(); // Evita o comportamento padrão de submissão do formulário

    const login_data = document.getElementById('login').value;
    const department_data = document.getElementById('department').value;
    const role_data = document.getElementById('role').value;

    if (department_data == 'RH') {
        department_data = '0';
    } else if (department_data == 'TI') {
        department_data = '1';
    } else {
        department_data = '2'
    }

    if (role_data == 'Administrator') {
        role_data = '0';
    } else if (role_data == 'Manager') {
        role_data = '1';
    } else {
        role_data = '2'
    }

    registerUser({
        login: login_data,
        department: department_data,
        role: role_data
    });
});

function registerUser(body) {
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', // Indica que o corpo da requisição é JSON
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

