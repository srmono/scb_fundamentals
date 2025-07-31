var person = {
    fname: "venkat",
    lname: "bvs",
    age: 36,
    profession: "Trainer",
    skills: ["html", "css", "Bootstrap", "js"],
    address: {
        city: "bangalore",
        pincode: 560035,
        geo: {
            lat: 8980808080,
            lan: 6686828
        }
     } ,
     
    walks: function (){
        console.log("this person walks");
    },
    getName: function(){
        return this.fname + " " + this.lname
    }
}

console.log(person.name);

const {address, profession} = person;








// var finance = {
//     fname: "venkat",
//     lname: "bvs",
//     age: 36,
//     profession: "Trainer",
//     skills: ["html", "css", "Bootstrap", "js"],,
//     accounts: [
//         {name: "", ac_num: 79797979, .....},
//         {name: "", ac_num: 79797979, .....},
//         {name: "", ac_num: 79797979, .....},
//         {name: "", ac_num: 79797979, .....},
//         {name: "", ac_num: 79797979, .....}
//     ],
// }










import {test} from './fetchdata.js';

function myfunc(test){}