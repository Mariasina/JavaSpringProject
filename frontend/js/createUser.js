const form = document.querySelector('form');
const URL = "http://localhost:8080";

const token = localStorage.getItem('token');
console.log(token)

form.addEventListener('submit', async event => {
    event.preventDefault();

    const login_data = document.getElementById('login').value;
    let department_data = document.getElementById('department').value;
    let role_data = document.getElementById('role').value;

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

async function registerUser(body) {
    var myHeaders = new Headers();
    myHeaders.append('Content-Type', 'application/json')
    myHeaders.append("token", token)

    const options = {
        method: 'POST',
        headers: myHeaders,
        mode: 'cors',
        body: JSON.stringify(body)
    };

    let response = await fetch(URL + "/user", options)
    let json = await response.json()
    // if (json.status == 403)
    //     alert("Você não tem permissão para realizar essa função");
    // else if (json.status == 401)
    //     alert("Login expirado");
    // else
    //     alert(response);
        alert(json);


    console.log(json)
}