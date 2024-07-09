const form = document.querySelector('form');
const URL = "http://localhost:8080";

form.addEventListener('submit', async event => {
    event.preventDefault(); // Evita o comportamento padrão de submissão do formulário

    const login_data = document.getElementById('username').value;
    const password_data = document.getElementById('password').value;

    autheticate({
        login: login_data,
        password: password_data
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
            console.log('Logged in:', data);
            let token = data.token;
            console.log(token);
            if(token == null){
                alert(data.message);
            }else{
                localStorage.setItem("token", token);
                window.location.href = 'index.html';
            }
            // Aqui você pode lidar com a resposta do servidor, se necessário
        })
        .catch(error => console.error('Error in logging in:', error));
        

}