function onPageLoaded(){

    $("#login").click(login_button);
}


function signup_link() {

    window.location = window.location.href.replace("login.html","signup.html");
};
function signup_button() {

    window.location = window.location.href.replace("signup.html","login.html");
};  

function login_button() {

var params = {username:document.getElementById("username").value,
password:document.getElementById("password").value};
console.log(params);
    $.ajax({
        url:encodeURI("http://localhost:8080/user/login"),
                method: 'POST',
                crossDomain: true,
                data: params,
        
        success: function (response) {
            console.log(response);
            if(response=="")
            {
                window.alert("User Not Found");
            }
            else
            {
            window.location = window.location.href.replace("login.html","list.html");
            localStorage.setItem("username",response);

            }
        },
        error: function (xhr,status) {
            console.log("hata" ,xhr,status);
        }

    });

}