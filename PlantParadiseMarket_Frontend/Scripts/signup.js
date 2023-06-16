let submit = document.getElementById("submit");

submit.addEventListener("click",function(event){
    event.preventDefault();
    postReq();
});

function postReq() {
  let customerName = document.getElementById("fullName").value;

  let customerEmail = document.getElementById("email").value;
  let phoneNo = document.getElementById("phone").value;
  let password = document.getElementById("password").value;
  let houseNo = document.getElementById("houseNum").value;
  let colony = document.getElementById("colony").value;
  let city = document.getElementById("city").value;
  let state = document.getElementById("state").value;
  let pincode = document.getElementById("pincode").value;

  fetch("http://localhost:8899/ppm/registerCustomer", {
    method: "POST",
    headers: {
      "content-Type": "application/json",
    },
    body: JSON.stringify({
      customerName,
      customerEmail,
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
      alert("Customer added Succesfully !");
      window.location.href = "login.html";
      
    } else {
      response.json().then((data) => {
        if (
          data.message == `Customer with this email ${customerEmail} already exist.`
        ) {
          alert("customer already registered!");
        }
        console.log(data.message)
      });
    }
  });
}