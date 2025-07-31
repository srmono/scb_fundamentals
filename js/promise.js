const fetchData = () => {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve("Data fetched successfully!");
      }, 2000);
    });
  };


// const fetchData = new Promise(
//     (resolve, reject) => {

//       setTimeout(
//         () => {
//             resolve("Data fetched successfully!");
//         }, 
//         2000
//       );

//     }
// );

  
fetchData()
    .then((msg) => console.log(msg));