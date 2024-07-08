fetch("http://localhost:8080/test")
    .then(response => response.text())
    .then(text => {
        let value = document.getElementsByClassName("message")[0]
        value.innerHTML = text
    })

function openModal(event) {
    event.preventDefault();
    document.getElementById('01').style.display = 'block';
}

function closeModal() {
    document.getElementById('01').style.display = 'none';
}

function checkPasswordValidity(event) {
    event.preventDefault();

    var newPassword = document.getElementById("newPassword");
    var newPasswordConfirm = document.getElementById("newPasswordConfirm");
    var doesMatch;
    var doesRequire;

    if (newPassword.value !== newPasswordConfirm.value) {
        document.getElementById('mismatch').style.display = 'block';
        doesMatch = false;
    } else {
        document.getElementById('mismatch').style.display = 'none';
        doesMatch = true;
    }

    if (!newPassword.checkValidity()) {
        document.getElementById('message').style.display = 'block';
        doesRequire = false;
    } else {
        document.getElementById('message').style.display = 'none';
        doesRequire = true;
    }

    if(doesRequire & doesMatch){
        window.location.href = 'index.html';
    }
}