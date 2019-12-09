
function login(usernameElement, passwordElement) {
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";

    if (username == "user" && password == "user") {
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