let submit = document.getElementById("submit");

submit.addEventListener("click",function(event){
    event.preventDefault();
    postReq();
});

function postReq() {


  let username = document.getElementById("email").value;
  let password = document.getElementById("password").value;

  fetch("http://localhost:8899/ppm/registerAdmin", {
    method: "POST",
    headers: {
      "content-Type": "application/json",
    },
    body: JSON.stringify({
      username,
      password
    }),
  }).then((response) => {
    console.log(response);
    if (response.status >= 200 && response.status <= 299) {
      alert("Admin added Succesfully !");
      window.location.href = "login.html";
      
    } else {
      response.json().then((data) => {
        if (
          data.message == `Admin with username ${username} already exist..`
        ) {
          alert("Admin already registered!");
        }
        console.log(data.message)
      });
    }
  });
}