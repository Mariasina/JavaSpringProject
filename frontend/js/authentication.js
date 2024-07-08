const form = document.querySelector('form');
const URL = "http://localhost:8080";

form.addEventListener('submit', async event => {
    event.preventDefault(); // Evita o comportamento padrão de submissão do formulário

    const login_data = document.getElementById('login').value;
    const department_data = document.getElementById('department').value;
    const role_data = document.getElementById('role').value;

    autheticate({
        login: login_data,
        department: "1",
        role: "1"
    });
});

function autheticate(body) {
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', // Indica que o corpo da requisição é JSON
        },
        body: JSON.stringify(body), // Converte o objeto JavaScript para JSON
    };

    fetch(URL + "/auth", options)
        .then(response => response.json())
        .then(data => {
            console.log('Logado:', data);
            // Aqui você pode lidar com a resposta do servidor, se necessário
        })
        .catch(error => console.error('Erro ao cadastrar:', error));
}