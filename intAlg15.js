//take input of a mulitdimentional array and conver it into a single dimension array.

//command_line_interface

const readline = require('readline'),  
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

//intro
console.log('Welcome to the Steam-Roll Program!\n_______________________________________\n');
console.log('you will enter a string of nested arrays and we will convert in into a one dimensional array...\n\n');



function steamroll_user_input() {
    
}








//I calculated the effiency of function 2 & 3 in this list and found the #2 to be about 13% more efficent, so that is the function i use in my CLI 

//FIRST SOLUTION -- not completely working
// function steamrollArray(arr) {

//     let sRollArr = [];
   
//     for (let i = 0; i < arr.length; i++) {

//         // console.log(arr[i]);
        
//         if (arr[i].length != undefined) {
            
//             for (let j = 0; j < arr[i].length; j++) {
//                extract_data(arr[i][j]);
                
//             }

//         } else {
//             sRollArr.push(arr[i]);
//         }
        
//     }

//     function extract_data(element) {
//         if (element.length == undefined) {
//             sRollArr.push(element)
//         } else {
//             extract_data(element[0])
//         }
//     }

//     return sRollArr;
// }

// console.log(steamrollArray([[["a"]], [["b"]]]));


//EFFICENT SOLUTION -- uses one for-loop -- takes about .08 milliseconds to complete

function steamroll_array_loop_and_spread(arr) {

    for (let i = 0; i < arr.length; i++) {
        
        if (Array.isArray(arr[i])) {

            arr.splice(i,1, ...arr[i]);
            i--  //an extra iteration is added for each subarray found, other wise some subarrays will be skipped over
            
        }
        
    }

    return arr

}

// console.log(steamroll_array_loop_and_spread([1, {}, [2, [[3],4, [5,6,7,[8,[9,[10,[[11]],12]]],13]]],14]));


//RECERSIVE FUNCTION THAT USES .flat() -- takes about . milliseconds to complete

//after coding my first couple functions to complete this algorithm challenge I did some research and found the method .flat()
//Array.prototype.flat() returns a value of the arr with one level of subarray values concatonated to the array
//this function is a recersive loop that flatens the array one level each time the function is called, until it is found that there are no more subarrays
// function steamroll_array_recersive(arr) {

//     // console.log(arr); //shows the user the current state of the array

//     if (arr.some(element => Array.isArray(element))) { //if the array still contains a subarray then flaten the array one level
        
//         return steamroll_array_recersive(arr.flat());  //recersive call

//     }  else { //now that there are not more subarrays present the final array can be returned
        
//         return arr
//     } 
    
// }

// console.log(steamroll_array_recersive([1, {}, [2, [[3],4, [5,6,7,[8,[9,[10,[[11]],12]]],13]]],14]));