
function login(usernameElement, passwordElement) {
     let username = usernameElement && usernameElement.value ? usernameElement.value : "";
     let password = passwordElement && passwordElement.value ? passwordElement.value : "";
     let type = document.getElementById("userType").value;

 

const ROOT_PATH = "http://localhost:8080";
var fd = new FormData();
fd.append("username", username);
fd.append("password", password);
$.ajax({
  url: ROOT_PATH + "/login",
  data: fd,
  processData: false,
  contentType: false,
  type: "POST",
  success: function(data) {
    sessionStorage.setItem(SESSION_STORAGE_LOGIN_TOKEN_NAME, username);

    $.ajax({
      let type = document.getElementById("userType").value,
      url: ROOT_PATH + "/user",
      data: fd,
      processData: false,
      contentType: false,
      type: "GET",
      success: function(data){    
        if(type=="doctor"){
          window.location.replace(ROOT_PATH + "/pages/user/doctor/doctorSearch.html");
        }else if(type=="citizen"){
          window.location.replace(ROOT_PATH + "/pages/user/citizen/createPage.html");
        }

      window.location.replace(ROOT_PATH + "/pages/user/citizen/createPage.html");
  },
  statusCode: {
    401: function() {
      alert("Invalid username or password!");
    }
  }
});
}
}

function register() {
  let amka = document.getElementById('amka').value;
  let name = document.getElementById('name').value;
  let lastname = document.getElementById('lastname').value;
  let email = document.getElementById('email').value;
  let username = document.getElementById('username').value;
  let password = document.getElementById('password').value;
  let phone = document.getElementById('phone').value;
             $.ajax({
                       url: ROOT_PATH + '/guest/register',
                       type: 'POST',
                       dataType: 'json',
                       data: JSON.stringify({
                       amka:amka,
                       name:name,
                       lastname:lastname,
                       email:email,
                       username:username,
                       password:password,                      
                       phone:phone,                          
                  }),
                  contentType: 'application/json',
                  success: function (result) {
                      alert("User Saved: " + JSON.stringify(result));
                  },
                  error: function (xhr, resp, text) {
                      alert("User not Saved: " + text);
                  }
              });
}
	
    

