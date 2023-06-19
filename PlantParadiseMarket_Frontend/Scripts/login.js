let login = document.getElementById("login");

login.addEventListener("click",function(event){
    event.preventDefault();
    postReq();
});

function postReq() {
  let username = document.getElementById("username").value;

  let password = document.getElementById("password").value;

  let url = `http://localhost:8080/ppm/CustomerSignIn`;

  var headers=new Headers();
  headers.append('Content-Type', 'application/json');
  headers.append('Authorization', 'Basic ' + btoa(username + ':' + password));

  var options = {
    method: 'GET',
    headers: headers,
  };
  console.log(username,password);

  fetch(url,options)
  .then((response) => {
    console.log(response);
    if (response.status >= 200 && response.status <= 299) {
        return response.json();
        
    } else {
        alert(`Sign-in failed with response: ${response.status}`)
        throw new Error('Sign-in failed: ' + response.status);
    }
  })
.then((data)=>{

    sessionStorage.setItem("customerDetail",JSON.stringify(data));
    let credObj={
      username,
      password
    }
    localStorage.setItem("credentials",JSON.stringify(credObj));
    console.log(data);
    alert("Customer Logged In Successfully");
    window.location.href="customer.html";
    
});
}
