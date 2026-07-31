function verification() {
    const firstname = document.getElementById("firstname").value.trim();
    const lastname = document.getElementById("lastname").value.trim();
    const location = document.getElementById("location").value.trim();
    const pnumber = document.getElementById("pnumber").value.trim();
    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value;
    const conformpassword = document.getElementById("conformpassword").value;
    const message = document.getElementById("message");
    const form = document.querySelector("form");

    // Clear all previous error messages
    document.querySelectorAll(".error").forEach(el => el.textContent = "");

    const nameRegex = /^[A-Za-z ]+$/;
    const phoneRegex = /^[0-9]{10}$/;
    const emailPattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;
    const specialChar = /[!@#$%^&*(),.?":{}|<>]/;

    if (firstname === "" || !nameRegex.test(firstname)) {
        document.getElementById("fnameError").textContent = "First name must contain only letters.";
        return false;
    }

    if (lastname === "" || !nameRegex.test(lastname)) {
        document.getElementById("lnameError").textContent = "Last name must contain only letters.";
        return false;
    }

    if (location === "") {
        document.getElementById("stateError").textContent = "Please select your state.";
        return false;
    }


    if (!phoneRegex.test(pnumber)) {
        document.getElementById("phoneError").textContent = "Enter a valid 10-digit number.";
        return false;
    }

    if (!emailPattern.test(email)) {
        document.getElementById("emailError").textContent = "Enter a valid Gmail address in lowercase.";
        return false;
    }

    if (password.length < 6 || !specialChar.test(password)) {
        document.getElementById("passError").textContent = "Password must be ≥6 characters with one special character.";
        return false;
    }

    if (password !== conformpassword) {
        document.getElementById("cpassError").textContent = "Passwords do not match.";
        return false;
    }

    message.textContent = "Registered Successfully!";
    form.reset();
    return false;
}

function togglePassword(fieldId, icon) {
    const field = document.getElementById(fieldId);
    if (field.type === "password") {
        field.type = "text";
        icon.textContent = "🙈"; // change icon
    } else {
        field.type = "password";
        icon.textContent = "👁️"; // back to eye
    }
}
