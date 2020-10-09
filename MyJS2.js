//fucntion to take in data from the user input and storing in into an object.
function readInDish(){
    let menu = {}; 
    menu["name"] = document.getElementById("dishNumber").value;
    menu["colour"] = document.getElementById("dishName").value;
    menu["habitat"] = document.getElementById("veganSuitability").value;
    menu["dishPrice"] = document.getElementById("dishPrice").value;

    fetch("http://localhost:8081/duck/createDuck", { //Make request
            method: "POST",
            body: JSON.stringify(menu),
            headers: {
                'Content-Type': "application/json"
            }
        }).then(response => {   // Receive response
            return response.json(); // Convert response body to json
        }).then(menu => { //json data from previous .then()
            console.log(menu);
        }).catch(error => console.log(error));


        console.log(menu);

    return menu;

    
}
//sconsole.log(menu);
//console.log(readInDish())

// fetch("http://localhost:8081/duck/createDuck", { //Make request
//         method: "POST",
//         body: JSON.stringify(menu),
//         headers: {
//             'Content-Type': "application/json"
//         }
//     }).then(response => {   // Receive response
//         return response.json(); // Convert response body to json
//     }).then(menu => { //json data from previous .then()
//         console.log(menu);
//     }).catch(error => console.log(error));


// const createForm = document.getElementById("createForm");

// createForm.addEventListener('submit', function(event) {
//     //event.preventDefault();
//     console.log(this.name);
//     const data = {
//         dishNumber: this.dishNumber.value,
//         dishName: this.dishName.value,
//         veganSuitability: this.veganSuitability.value
//     }
//  // CREATE 
//     fetch("http://localhost:8081/duck/createDuck", { //Make request
//         method: "POST",
//         body: JSON.stringify(data),
//         headers: {
//             'Content-Type': "application/json"
//         }
//     }).then(response => {   // Receive response
//         return response.json(); // Convert response body to json
//     }).then(data => { //json data from previous .then()
//         console.log(data);
//     }).catch(error => console.log(error));

// });

//Storing each dish in a new table and adding an option to delete or edit entries.
function addNewDish(dish){
    let table = document.getElementById("menuDishes").getElementsByTagName('tbody')[0];
    let newRow = table.insertRow(table.length);
    cella = newRow.insertCell(0);
    cella.innerHTML = dish.dishNumber;
    cellb = newRow.insertCell(1);
    cellb.innerHTML = dish.dishName;
    cellc = newRow.insertCell(2);
    cellc.innerHTML = dish.veganSuitability;
    celld = newRow.insertCell(3);
    celld.innerHTML = dish.dishPrice;
    celle = newRow.insertCell(4);
    celle.innerHTML = '<a onClick="editDish(this)">Edit</a>';
    cellf = newRow.insertCell(5);
    cellf.innerHTML = '<a onClick="deleteDish(this)">Delete</a>';

    
    
    
    
}
//clear previous dish entry
function clearTable() {
    document.getElementById("dishNumber").value="";
    document.getElementById("dishName").value="";
    document.getElementById("veganSuitability").value="";
    document.getElementById("dishPrice").value="";
    selectedRow = null;

}

//Deleting entry from table
function deleteDish(td) {
    if (confirm("Are you sure you want to delete Dish")) {
        row = td.parentElement.parentElement;
        console.log(row); //
        document.getElementById("menuDishes").deleteRow(row.rowIndex);
        // console.log(row.rowIndex);}
    fetch("http://localhost:8081/duck/deleteDuck/"+row, { //Make request
    method: "DELETE",
    
    }).then(response => {   
        return response.json(); 
    }).then(data => { 
        console.log(data);
    }).catch(error => console.log(error));

        clearTable();
    }

}
console.log(deleteDish(td));//

//Allow for logged dishes to be edited. 
function editDish(td){
    selectedRow = td.parentElement.parentElement;
    document.getElementById("dishNumber").value=selectedRow.cells[0].innerHTML;
    document.getElementById("dishName").value=selectedRow.cells[1].innerHTML;
    document.getElementById("veganSuitability").value=selectedRow.cells[2].innerHTML;
    document.getElementById("dishPrice").value=selectedRow.cells[3].innerHTML;
}
//Udating new vallues into the log table
function updateDish(menu){
    selectedRow.cells[0].innerHTML = menu.dishNumber;
    selectedRow.cells[1].innerHTML = menu.dishName;
    selectedRow.cells[2].innerHTML = menu.veganSuitability;
    selectedRow.cells[3].innerHTML = menu.dishPrice;
}

//setting a null value
let selectedRow = null;



function submitDish() {
    if (validity()){ 
        menu = readInDish();
        
        if (selectedRow == null){
            addNewDish(menu);
        }else {
            updateDish(menu);
        }
        clearTable();
    }
}

//Ensuring that Primary key 'Dish Number' and Secondary key 'Dish Name' is not null. 
function validity(){
    validDish = false;
    if (!document.getElementById("dishNumber").value =="" || document.getElementById("dishName").value ==""){
        validDish = true;
        document.getElementById("valueValidationError").classList.remove("hide");
    }else {
        validDish = false;
        if (document.getElementById("valueValidationError").classList.contains("hide"))
            document.getElementById("valueValidationError").classList.add("hide");
    }
    return validDish;
}
