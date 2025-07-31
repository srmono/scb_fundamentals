fetch("https://jsonplaceholder.typicode.com/posts/1")
    .then( (res) => res.json())
    .then( (data) => {
        displayData(data)
    })


function displayData(data){
    document.getElementById("demo").innerHTML = data.title
}
//fetch method (retruns promise obj) //call api ()
//then? receive the response
//conver it to json
//then? data and process 

export var test = "data";