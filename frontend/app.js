import 'regenerator-runtime/runtime';
import axios from 'axios';

const form = document.querySelector('form');

form.addEventListener('submit', async event => {
    event.preventDefault();

    const login = document.querySelector('#login').value;
    const department = document.querySelector('#department').value;
    const role = document.querySelector('#role').value;

    if (department == 'HR') {
        department = 0;
    } else if (department == 'TI') {
        department = 1;
    } else {
        department = 2;
    }

    if (role == 'Administrator') {
        role = 0;
    } else if (role == 'Manager') {
        role = 1;
    } else {
        role = 2;
    }

    const item = {
        login: login,
        department: department,
        role: role
    };

    const submitItem = await addItem(item);
    updateList(submitItem);
});

export const addItem = async item => {
    try {
        const response = await axios.post(`http://localhost:8080/user`, item);
        const newItem = response.data;

        console.log(`Added a new Item!`, newItem);

        return newTodoItem;
    } catch (errors) {
        console.error(errors);
    }
};