var divEl = document.createElement("div");

document.body.appendChild(divEl);

var text = document.createTextNode("Axess Academy");

divEl.appendChild(text)

divEl.setAttribute("class", "title");

divEl.setAttribute("id", "divId");

divEl.innerHTML = "<p>Venkat</p>"

var readById = document.getElementById("divId");

readById.innerHTML ="";

//divEl.remove()

var skills = ["html", "css", "js"];

//skills.forEach

let str = "abcdef";
let result = /abc/.test(str);

