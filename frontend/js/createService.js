const form = document.querySelector('form');
const URL = "http://localhost:8080"; // Verifique se está correto para o seu ambiente

const token = localStorage.getItem('token');

form.addEventListener('submit', async event => {
    event.preventDefault(); // Evita o comportamento padrão de submissão do formulário

    const name_data = document.getElementById('serviceName').value;
    const description_data = document.getElementById('description').value;
    const intern_data = document.getElementById('internal').checked;

    createService({
        name: name_data,
        description: description_data,
        intern: intern_data
    });
});

async function createService(body) {
    var myHeaders = new Headers();
    myHeaders.append('Content-Type', 'application/json')
    myHeaders.append("token", token)

    const options = {
        method: 'POST',
        headers: myHeaders,
        mode: 'cors',
        body: JSON.stringify(body)
    };

    let response = await fetch(URL + "/service", options)
    let json = await response.json()
    console.log(json)
}

