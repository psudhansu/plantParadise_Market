let submit = document.getElementById("submit");

submit.addEventListener("click",function(event){
    event.preventDefault();
    postReq();
});

function postReq() {
  let customerName = document.getElementById("fullName").value;
  let username = document.getElementById("email").value;
  let phoneNo = document.getElementById("phone").value;
  let password = document.getElementById("password").value;
  let houseNo = document.getElementById("houseNum").value;
  let colony = document.getElementById("colony").value;
  let city = document.getElementById("city").value;
  let state = document.getElementById("state").value;
  let pincode = document.getElementById("pincode").value;

  console.log(customerName,username,phoneNo,password,houseNo,colony,city,state,pincode)

  fetch("http://localhost:8080/ppm/registerCustomers", {
    method: "POST",
    headers: {
      "content-Type": "application/json",
    },
    body: JSON.stringify({
      customerName,
      username,
      phoneNo,
      password,
      address: {
        houseNo,
        colony,
        city,
        state,
        pincode,
      },
    }),
  }).then((response) => {
    console.log(response);
    if (response.status >= 200 && response.status <= 299) {
      alert("Customer Registered Succesfully !");
      
      window.location.href = "login.html";
      
    } else {
      response.json().then((data) => {
        if (
          data.message == `Customer with this email ${username} already exist.`
        ) {
          alert("customer already registered!");
        }
        console.log(data.message)
      });
    }
  });
}


