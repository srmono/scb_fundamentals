// sayHi()

// function sayHi() {
//     console.log("Say Hello");
// }



// //var x  = sayHi;

// function square(number){
//     return number * number;
// }

// //square(10)
// esquare(10)

// var esquare = function(number){
//     return number * number;
// }

// // 


/** Scoping */

var val1 = 10;

function one(){
    var valInFunc = 20;
    console.log(val1 * valInFunc);
}

// one()
// console.log(val1);
// console.log(valInFunc);

var persons = ["John", "bob"];

persons.forEach(display)

function display(item, index){
    console.log("index value is: " + index + ", Name is: " + item);
}

// persons.unshift("Venkat")
// persons.push("axess")

// console.log(persons);