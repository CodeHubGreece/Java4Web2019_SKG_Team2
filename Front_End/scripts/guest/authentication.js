
function login(usernameElement, passwordElement) {
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";
    let type = document.getElementById("userType").value;

    if (username === "user" && password === "user") {
        localStorage.setItem(LOCAL_STORAGE_LOGIN_TOKEN_NAME, true);
        window.location.replace(ROOT_PATH + "/pages/user/index.html");
    }
    else {
        alert("Wrong password");
    }
}

function register() {
    // TODO:
}



	if(type==="doctor"){
		location.replace("./user/doctor/search.html");
	} else if(type==="citizen"){
		location.replace("./user/citizen/createPage.html");
	}