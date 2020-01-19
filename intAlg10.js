//sorted union

const readline  = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let union = [];
// Task, allow user to add arrays to a union, all values present from all arrays should be included in their original order, but with no duplicates in the final array.
add_to_union()

function add_to_union() {
    
    rl.question('Enter an array of numbers, they will be added to the union array.\nARRAY FORMAT --- [1,2,3] or "4 5 6"\n\ninput:', (arr) => {
        
        arr = arr.trim().toLowerCase().replace(/ /g, ',').replace(/[a-z]/g, '').split(',');

        // console.log(arr);
        
        for (let i = 0; i < arr.length; i++) {

            arr[i] = parseInt(arr[i]);

            if (!union.includes(arr[i]) && !isNaN(arr[i])) {
                union.push(arr[i])
            }
            
        }

        // console.log(union);

        add_to_union()
        
    })
}

function nav() {
    
}