function login(usernameElement, passwordElement) {

    let username = usernameElement.value;
    let password = passwordElement.value;

    var fd = new FormData();
    fd.append('username', username);
    fd.append('password', password);

    for (var value of fd.values()) {
       console.log(value);
    }

    $.ajax({
          url: ROOT_PATH + '/login',
          data: fd,
          processData: false,
          contentType: false,
          type: 'POST',
          success: function(data){

              console.log(username);
              $.ajax({
                  url: ROOT_PATH + '/user',
                  type: 'GET',
                  //contentType: 'application/json',
                  success: function (user) {
                    sessionStorage.setItem(SESSION_STORAGE_LOGIN_TOKEN_NAME, user.id);
                    if(user.type==='D'){
                        window.location.replace(ROOT_PATH + "/pages/user/doctor/doctorSearch.html");
                    }else if(user.type==='C'){
                        window.location.replace(ROOT_PATH + "/pages/user/citizen/createSearchPage.html");
                    }
                  },
                  error: function (error) {
                      alert("User not found: " + error);
                  }
              });
          },
          statusCode: {
            401 : function() {
                    alert("Invalid username or password!");
                }
            }
        });

}

function register() {
    let amka = document.getElementById('amka').value;
    let lastName = document.getElementById('lastName').value;
    let firstName = document.getElementById('firstName').value;
    let email = document.getElementById('email').value;
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let phone = document.getElementById('phone').value;
    let userType = 'C';

    $.ajax({
        url: ROOT_PATH + '/register',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify({
            "amka": amka,
            "lastName": lastName,
            "firstName": firstName,
            "email": email,
            "username": username,
            "password": password,
            "phone": phone,
            "userType": userType
        }),
        contentType: 'application/json',
        success: function () {
            document.getElementById("successMessage").innerHTML = "Ο χρήστης δημιουργήθηκε επιτυχώς";
            document.getElementById("success").style.display = "block";
            let button = document.getElementById("successButton");
            button.onclick = function(){window.location.replace(ROOT_PATH);};
        },
        error: function (text) {
            alert("User not Saved: " + text);
        }
    });
}
