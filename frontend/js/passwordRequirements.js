const pass = document.getElementById("password");
const pass_repeat = document.getElementById("password-repeat");
const pass_area = document.getElementById("password-area");
const pass_repeat_area = document.getElementById("password-repeat-area");

const char_eight = document.getElementById("char-eight");
const char_upper = document.getElementById("char-upper");
const char_lower = document.getElementById("char-lower");
const char_number = document.getElementById("char-number");
const equal_pass = document.getElementById("equal-pass");


pass.addEventListener('change', function () {
    let has_lower = false;
    let has_upper = false;
    let has_number = false;

    for (let i = 0; i < pass.value.length; i++) {
        if (/[a-z]/gm.test(pass.value.charAt(i)))
            has_lower = true;
        if (/[A-Z]/gm.test(pass.value.charAt(i)))
            has_upper = true;
        if (/[0-9]/gm.test(pass.value.charAt(i)))
            has_number = true;
    }

    if (has_lower)
        char_lower.style.color = "#0bb533";
    else
        char_lower.style.color = "#d10820";

    if (has_upper)
        char_upper.style.color = "#0bb533";
    else
        char_upper.style.color = "#d10820";

    if (has_number)
        char_number.style.color = "#0bb533";
    else
        char_number.style.color = "#d10820";

    if (pass.value.length >= 8)
        char_eight.style.color = "#0bb533";
    else
        char_eight.style.color = "#d10820";

    char_eight.style.display = 'block';
    char_upper.style.display = 'block';
    char_lower.style.display = 'block';
    char_number.style.display = 'block';
});

pass_repeat.addEventListener('change', function () {
    
    if (pass_repeat.value != pass.value)
        equal_pass.style.color = "#d10820";
    else
        equal_pass.style.color = "#0bb533";

    equal_pass.style.display = 'block';

});
