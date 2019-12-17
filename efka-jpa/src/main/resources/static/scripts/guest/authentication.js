function login(usernameElement, passwordElement) {
//     let username = usernameElement && usernameElement.value ? usernameElement.value : "";
//     let password = passwordElement && passwordElement.value ? passwordElement.value : "";
//     let type = document.getElementById("userType").value;

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
              $.ajax({
                  url: ROOT_PATH + "/user",
                    data: JSON.stringify({
                        "password": password
                    }),
                   dataType: 'json',
                  //processData: false,
                  contentType: 'application/json',
                  type: "GET",
                  success: function(user){
  //                    if(type==="D"){
  //                        window.location.replace(ROOT_PATH + "/pages/user/doctor/doctorSearch.html");
  //                    }else if(type==="C"){
  //                        window.location.replace(ROOT_PATH + "/pages/user/citizen/createPage.html");
  //                    }
                      console.log(user);
                      //window.location.replace(ROOT_PATH + "/pages/user/citizen/createPage.html");
                  },
                  error: function(error){
                    alert(fd);
                  },
                  statusCode: {
                      401: function() {
                          alert("Invalid username or password!");
                      }
                  }
              });
            sessionStorage.setItem(SESSION_STORAGE_LOGIN_TOKEN_NAME, username);
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

//    let fd = new FormData();
//    fd.append("amka", amka);
//    fd.append("lastName", lastName);
//    fd.append("firstName", firstName);
//    fd.append("email", email);
//    fd.append("username", username);
//    fd.append("password", password);
//    fd.append("phone", phone);
//    fd.append("userType", userType);
//    console.log(fd.lastName);

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
            alert("User Saved");
        },
        error: function (text) {
            alert("User not Saved: " + text);
        }
    });
}
