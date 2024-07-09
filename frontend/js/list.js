let links = document.querySelectorAll(".link");
let currentValue = 1;

links.forEach(element => {
    element.addEventListener("click", (e) => {

        links.forEach(element => {
            element.classList.remove("active")   
        });

        element.classList.add("active")
        currentValue = element.innerHTML;
    })
})

document.querySelector(".btn1").addEventListener("click", (e) => {
    if (currentValue > 1) {
        links.forEach(element => {
            element.classList.remove("active")   
        });
        currentValue--;
        links[currentValue-1].classList.add("active")
    }
})

document.querySelector(".btn2").addEventListener("click", (e) => {
    if (currentValue < 6) {
        links.forEach(element => {
            element.classList.remove("active")   
        });
        currentValue++;
        links[currentValue-1].classList.add("active")
    }
})

// nao funfa ainda