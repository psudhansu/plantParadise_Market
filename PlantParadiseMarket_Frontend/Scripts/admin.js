// for all admins ==========================================================

let submit = document.getElementById("getAdmin");

submit.addEventListener("click",function(event){
    event.preventDefault();
    getReq();
});

// for all admins ==========================================================

let sumbitAll = document.getElementById("getAll");

sumbitAll.addEventListener("click",function(event){
    event.preventDefault();
    getAllAdmin();
});


function getReq(){

    let adminId= document.getElementById("adminId").value;

    // console.log(adminId);

    // fetch(`http://localhost:8080/ppm/getAdmin/${adminId}`)
    // .then(response => {
    //   if (!response.ok) {
    //     throw new Error('Error: ' + response.status);
    //   }
    //   return response.json();
    // })
    // .then(data => {
    //   // Process the fetched data
    //   console.log(data);
    // })
    // .catch(error => {
    //   // Handle any errors that occurred during the fetch
    //   console.log(error);
    // });


    fetch(`http://localhost:8080/ppm/getAdminById/${adminId}`)
    .then((response) => response.json())
    .then((response) => {

        

        if(response.message==undefined){
            console.log(response)
            displayData(response)

        }else{

            if(response.message == `Admin with Id ${adminId} does not exist`){
                alert(`Admin is not present with this id ${adminId}`);
            }else{
                alert('Invalid AdminId')
            }
            console.log(response.message);
        }

        
    })
    .catch((error) => console.log("error", error.message));

}


function displayData(data){
    let tbody= document.getElementById("tbody");

    tbody.innerHTML= "";

    tbody.innerHTML= `
        <tr>
            <td>${data.adminId}</td>
            <td>${data.adminName}</td>
            <td>${data.username}</td>
          </tr>
    `
}

        


function getAllAdmin(){
    fetch(`http://localhost:8080/ppm/getAdmins`)
    .then((response) => response.json())
    .then((response) => {

        

        if(response.message==undefined){
            console.log(response)
            displayAllData(response)

        }else{

            if(response.message == `No admin present`){
                alert(`No admin present`);
            }
            // console.log(response.message);
        }

        
    })
    .catch((error) => console.log("error", error.message));

}


function displayAllData(data){
    let tbody= document.getElementById("tbody");

    tbody.innerHTML= "";

    data.forEach(element => {
        tbody.innerHTML+= `
        <tr>
            <td>${element.adminId}</td>
            <td>${element.adminName}</td>
            <td>${element.username}</td>
          </tr>
    `
    });
}


// delete admin ====================================================================================


let deleteAdmin = document.getElementById("delete");

deleteAdmin.addEventListener("click",function(event){
    event.preventDefault();
    deleteAdminById();
});

function deleteAdminById(){

    let adminId= document.getElementById("deleteAdminId").value;

    fetch(`http://localhost:8080/ppm/deleteAdmin/${adminId}`,
    {
        method: 'DELETE'
    }
    )
    .then((response) => response.json())
    .then((response) => {

        

        if(response.message==undefined){
            console.log(response)
            alert(`Admin with id ${adminId} deleted successfully`)

        }else{

            if(response.message == `Admin with Id ${adminId} does not exist`){
                alert(`Admin is not present with this id ${adminId}`);
            }else{
                alert('Invalid AdminId')
            }
            console.log(response.message);
        }

        
    })
    .catch((error) => console.log("error", error.message));
    console.log(adminId);

}


// add plant -------------------------------------------------------------------------------------

let addPlant= document.getElementById("plantSubmit")

addPlant.addEventListener("click",function(event){
    event.preventDefault();
    addPlantDetailes();
});

function addPlantDetailes(){
    
    let plantHeight = document.getElementById("plantHeight").value;
    let commonName = document.getElementById("commonName").value;
    let bloomTime = document.getElementById("bloomTime").value;
    let medicinalOrCulinaryUse= document.getElementById("medicinalOrCulinaryUse").value;
    let temperature= document.getElementById("temperature").value;
    let typeOfPlant= document.getElementById("typeOfPlant").value;
    let plantDescription= document.getElementById("plantDescription").value;
    let plantCost= document.getElementById("plantCost").value;


  
    console.log(plantHeight,commonName,bloomTime,medicinalOrCulinaryUse,temperature,typeOfPlant,plantDescription,plantCost);
  
    fetch("http://localhost:8080/ppm/plantSave", {
      method: "POST",
      headers: {
        "content-Type": "application/json",
      },
      body: JSON.stringify({
        plantHeight,
        commonName,
        bloomTime,
        temperature,
        typeOfPlant,
        medicinalOrCulinaryUse,
        plantDescription,
        plantCost
      }),
    }).then((response) => {
      console.log(response);
      if (response.status >= 200 && response.status <= 299) {
        alert("Plant added Succesfully !");
        window.location.reload();
        
      } else {
        response.json().then((data) => {
          if (
            data.message == `This Plant is Already Existed !`
          ) {
            alert("Plant already registered!");
          }
          console.log(data.message)
        });
      }
    });


}

// add planter -------------------------------------------------------------------------------------