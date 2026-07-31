function verfication(){
    const fname = document.getElementById("fname").value.trim();
    const lname = document.getElementById("lname").value.trim();
    const email = document.getElementById("email").value.trim();
    const pnumber = document.getElementById("pnumber").value.trim();
    const state = document.getElementById("state").value.trim();
    const password = document.getElementById("password").value.trim();
    const cpassword = document.getElementById("cpassword").value.trim();

    const nameRegex = /^[A-Za-z]+$/
    const emailRegex = /^[a-z0-9._]+@gmail\.com$/
    const pnumberRegex = /^[0-9]{10}$/
    const passwordRegex = /[!@#$%^&*()]/ 

    document.querySelectorAll(".error").forEach(e => e.textContent = "");

    if (!nameRegex.test(fname) || fname===""){
        document.getElementById("fnameerror").textContent="Please enter a valid First name";
        return false;
    }

    if(!nameRegex.test(lname) || lname===""){
        document.getElementById("lnameerror").textContent="Please enter a valid Last name";
        return false;
    }

    if(state===""){
        document.getElementById("stateerror").textContent="Please select your state";
        return false;
    }

    if(!emailRegex.test(email) || email===""){
        document.getElementById("emailerror").textContent="Please enter a valid email ID";
        return false;
    }

    if(!pnumberRegex.test(pnumber)|| pnumber===""){
        document.getElementById("pnumbererror").textContent="Please enter a valid phone number";
        return false;
    }

    if(password.length < 6|| !passwordRegex.test(password) || password===""){
        document.getElementById("passworderror").textContent="Please enter a valid password of min lenght 6 char and consisting of atlease one specal character";
        return false;
    }

    if(password!=cpassword || cpassword===""){
        document.getElementById("cpassworderror").textContent="Passwords does not match";
        return false;
    }

    document.getElementById("success").textContent="Registration Successful";
    document.querySelector("form").reset();
    return false;
}
