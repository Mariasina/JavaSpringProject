fetch("http://localhost:8080/test")
    .then(response => response.text())
    .then(text => {
        let value = document.getElementsByClassName("message")[0]
        value.innerHTML = text
    })