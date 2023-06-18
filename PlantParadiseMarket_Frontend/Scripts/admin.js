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
            window.location.reload();
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


let addPlanter= document.getElementById("planterSubmit")

addPlanter.addEventListener("click",function(event){
    event.preventDefault();
    addPlanterDetails();
});

function addPlanterDetails(){
    
    let planterHeight = document.getElementById("planterHeight").value;
    let planterCapacity = document.getElementById("planterCapacity").value;
    let drinageHole = document.getElementById("drinageHole").value;
    let planterColor= document.getElementById("planterColor").value;
    let planterShape= document.getElementById("planterShape").value;
    let planterStock= document.getElementById("planterStock").value;
    let planterCost= document.getElementById("planterCost").value;
   


  
    console.log(planterHeight,planterCapacity,drinageHole,planterColor,planterShape,planterStock,planterCost);
  
    fetch("http://localhost:8080/ppm/planters", {
      method: "POST",
      headers: {
        "content-Type": "application/json",
      },
      body: JSON.stringify({
        planterHeight,
        planterCapacity,
        drinageHole,
        planterColor,
        planterShape,
        planterStock,
        planterCost
      }),
    }).then((response) => {
      console.log(response);
      if (response.status >= 200 && response.status <= 299) {
        alert("Planter added Succesfully !");
        window.location.reload();
        
      } else {
        response.json().then((data) => {
          if (
            data.message == `already present in database`
          ) {
            alert("Planter already exist");
          }
          else{
            alert("Planter cannot be null");
          }
          console.log(data.message)
        });
      }
    });
}


// add seed -------------------------------------------------------------------------------------


let addSeed= document.getElementById("seedSubmit")

addSeed.addEventListener("click",function(event){

    event.preventDefault();
    addSeedDetails();
});

function addSeedDetails(){

    let commonName = document.getElementById("commonName").value;
    let bloomTime = document.getElementById("bloomTime").value;
    let watering = document.getElementById("watering").value;
    let typeOfSeeds= document.getElementById("typeOfSeeds").value;
    let seedsDescription= document.getElementById("seedsDescription").value;
    let seedsCost= document.getElementById("seedsCost").value;
    let seedsPerPacket=document.getElementById("seedsPerPacket").value;


  
    console.log(commonName,bloomTime,watering,typeOfSeeds,seedsDescription,seedsCost,seedsPerPacket);
  
    fetch("http://localhost:8080/ppm/seeds", {
      method: "POST",
      headers: {
        "content-Type": "application/json",
      },
      body: JSON.stringify({
        commonName,
        bloomTime,
        watering,
        typeOfSeeds,
        seedsDescription,
        seedsCost,
        seedsPerPacket
      }),
    }).then((response) => {
      console.log(response);
      if (response.status >= 200 && response.status <= 299) {
        alert("Seed added Succesfully !");
        window.location.reload();
        
      } else {
        response.json().then((data) => {
          if (
            data.message == `Seed already present in database`
          ) {
            alert("Seed already exist");
          }
          else{
            alert("Seed cannot be null");
          }
          console.log(data.message)
        });
      }
    });
}



// View Plant ById========================================================

let viewPlant = document.getElementById("ViewPlant");

viewPlant.addEventListener("click",function(event){
    event.preventDefault();
   getPlant();
});

function getPlant(){

    let plantId=document.getElementById("viewAdminId").value;

    if(!isNaN(plantId) && plantId!=""){
        fetch(`http://localhost:8080/ppm/plantView/${+plantId}`)
        .then((response) => response.json())
        .then((response) => {

            if(response.message==undefined){
                console.log("Hiiiii");

                displayPlantData(response);
    
            }else{

                if(response.message == `This Plant is Not Existed !`){
                    alert(`Plant with Id ${plantId} does not`);
                }else{
                    alert('Invalid PlantId')
                }
                console.log(response.message);
            }
        })
        
    }
    else{
        alert("Please Enter Valid Input");
    }
}

function displayPlantData(data){
    let pr=document.getElementById("pr");
    pr.innerHTML="";
    pr.innerHTML+=`
    <tr>
       <td>${data.plantId}</td>
       <td>${data.plantHeight}</td>
       <td>${data.commonName}</td>
       <td>${data.bloomTime}</td>
       <td>${data.medicinalOrCulinaryUse}</td>
       <td>${data.temperature}</td>
       <td>${data.typeOfPlant}</td>
       <td>${data.plantDescription}</td>
       <td>${data.plantCost}</td>
    </tr>
    `
}


// View All Plants========================================================

let viewPlants = document.getElementById("ViewAllPlant");

viewPlants.addEventListener("click",function(event){
    event.preventDefault();
   getPlants();
});

function getPlants(){

    fetch(`http://localhost:8080/ppm/plantViewAll`)
        .then((response) => response.json())
        .then((response) => {

            if(response.message==undefined){
                displayPlantDatas(response);
    
            }else{

                if(response.message == `This Plant is Not Existed !`){
                    alert(`Plant with Id ${plantId} does not`);
                }else{
                    alert('Invalid PlantId')
                }
                console.log(response.message);
            }
    })
}

function displayPlantDatas(data){
    let pr=document.getElementById("pr");
    pr.innerHTML="";

    data.forEach(element => {
        pr.innerHTML+=`
            <tr>
               <td>${element.plantId}</td>
               <td>${element.plantHeight}</td>
               <td>${element.commonName}</td>
               <td>${element.bloomTime}</td>
               <td>${element.medicinalOrCulinaryUse}</td>
               <td>${element.temperature}</td>
               <td>${element.typeOfPlant}</td>
               <td>${element.plantDescription}</td>
               <td>${element.plantCost}</td>
            </tr>
        `
    });
}



