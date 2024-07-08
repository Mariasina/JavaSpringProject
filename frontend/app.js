import 'regenerator-runtime/runtime';
import axios from 'axios';

const form = document.querySelector('form');

form.addEventListener('submit', async event => {
    axios.post('/user', {
        firstName: 'Santos',
        lastName: 'Dumont'
      })
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.error(error);
      });
});