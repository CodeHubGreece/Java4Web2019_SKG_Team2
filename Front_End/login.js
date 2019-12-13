function login(amkaElement, lastnameElement, firstnameElement, usernameElement, 
  passwordElement, phoneElement, emailElement) {
    let amka = amkaElement && amkaElement.value ? amkaElement.value : "";
    let last_name = lastnameElement && lastnameElement.value ? lastnameElement.value : "";
    let first_name = firstnameElement && firstnameElement.value ? firstnameElement.value : "";
    let username = usernameElement && usernameElement.value ? usernameElement.value : "";
    let password = passwordElement && passwordElement.value ? passwordElement.value : "";
    let phone = phoneElement && phoneElement.value ? phoneElement.value : "";
    let email = emailElement && emailElement.value ? emailElement.value : "";


    var fd = new FormData();
    fd.append('amka', amka);
    fd.append('last_name', last_name);
    fd.append('first_name', first_name);
    fd.append('username', username);
    fd.append('password', password);
    fd.append('phone', phone);
    fd.append('email', email);
    

    $.ajax({
      url: ROOT_PATH + '/login',
      data: fd,
      processData: false,
      contentType: false,
      type: 'POST',
      success: function(data){
        sessionStorage.setItem(SESSION_STORAGE_LOGIN_TOKEN_NAME, username);
        window.location.replace(ROOT_PATH + "/pages/user/index.html");
      },
      statusCode: {
        401 : function() {
                alert("Invalid username or password!");
            }
        }
    });

}

function register() {
    // TODO:
}