function getPlants(){

    // Set the API endpoint URL
const apiUrl = `http://localhost:8080/ppm/seeds`;

// Set the session ID
const custCred = JSON.parse(localStorage.getItem('credentials'));

console.log(custCred)
// Create the headers object with the session ID

var headers=new Headers();
  headers.append('Content-Type', 'application/json');
  headers.append('Authorization', 'Basic ' + btoa(custCred.username + ':' + custCred.password));

// Make the GET request to the API
fetch(apiUrl, {
  method: 'GET',
  headers: headers
})
  .then(response => {
    console.log(response)
    // Check if the response status is OK (200)
    if (response.ok) {
        return response.json(); // Parse the response as JSON
      } else if (response.status == 401) {
        throw new Error('Unauthorized'); // Throw an error for unauthorized access
      } else {
        throw new Error('Error occurred'); // Throw an error for other errors
      }
  })
  .then(data => {
    // Process the retrieved data
    console.log(data);
    displayPlanterDatas(data);
    // Perform further actions with the data
  })
  .catch(error => {
    // Handle authentication errors or other network issues
    console.error(error);
  });
}

function displayPlanterDatas(data){
    let pr=document.getElementById("seedRow");
    pr.innerHTML="";

    data.forEach(element => {
        pr.innerHTML+=`
            <tr>
               <td>${element.commonName}</td>
               <td>${element.bloomTime}</td>
               <td>${element.watering}</td>
               <td>${element.typeOfSeeds}</td>
               <td>${element.seedsCost}</td> 
               <td><button class="btn btn-primary">Add to Cart</button></td>
            </tr>
        `
    });
}

getPlants();