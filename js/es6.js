// var name = "venkat";

// if(true){
//     let firstName = "venkat";
// }

// //console.log(firstName);

// const lname = "bvs";

// const skills = ["html","css"];

// skills.push("js");


// Arrow Functions

// function printName() {
//     return "Axess Academy";
// }

// let printName = () => {
//     return "Axess Academy";
// }

// let printName = () => "Axess Academy";

// let printName = msg => msg + " Axess Academy";

// let printName = (msg, a) => {
//     return msg + " Axess Academy " + a
// };

// console.log(printName("Welcome to " ));


var arr = [1,2,3];
var arr1  = [...arr, 4, 5];

console.log(arr1);

// var newArr = [...arr, arr1]

// console.log(newArr);

var nums = [1,3,9,10]

Math.max(...nums);

function test(...a){
    console.log(a)
}
test(10,20,29)
//VM748:2 (3) [10, 20, 29]
