let logoutBtn=document.getElementById("logout");
logoutBtn.addEventListener("click",function(e){
   postReq(); 
});

function postReq(){
    fetch('http://localhost:8080/ppm/logout', {
        method: 'POST',
      })
        .then(response => {
            console.log(response)
          if (response.ok) {
            // Logout successful, perform further actions if needed

            console.log('Logout successful');
            alert("Logout successful") 
            sessionStorage.removeItem('customerDetail'); 
            localStorage.removeItem('credentials');
            window.location.href="index.html";
        } else {
            // Handle error if logout was not successful
            alert("Logout failed");
            console.error('Logout failed');
          }
        })
        .catch(error => {
          // Handle network or other errors
          console.error('Error occurred while logging out', error);
        });
}