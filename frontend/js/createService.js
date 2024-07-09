const form = document.querySelector('form');
const URL = "http://localhost:8080"; // Verifique se está correto para o seu ambiente

form.addEventListener('submit', async event => {
    event.preventDefault(); // Evita o comportamento padrão de submissão do formulário

    const name_data = document.getElementById('serviceName').value;
    const description_data = document.getElementById('description').value;
    const intern_data = document.getElementById('internal').checked;

    registerUser({
        name: name_data,
        description: description_data,
        intern: intern_data
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

    fetch(URL + "/service", options)
        .then(response => response.json())
        .then(data => {
            console.log('Cadastrado:', data);
            // Aqui você pode lidar com a resposta do servidor, se necessário
        })
        .catch(error => console.error('Erro ao cadastrar:', error));
}

