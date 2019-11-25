var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

var allArrays = [];
function add_array() {
    rl.question(`Enter numbers in a list of numbers (array like format) ie: (3,1,4,5,9), [3 2 7] then the largest one will be found.\nArray: `, (array) => {
        array = array.trim().replace(/\(|\)|\[|\]|[a-z]/gi, '').replace(/\,/g, ' ').split(' ');
        allArrays.push(array);

        console.log('\n\nYou can now select any number of arrays to search for the greatest number in all that you select:\n________________________________');
        
        for (let i = 0; i < allArrays.length; i++) {
            console.log(i+1 + ": ", allArrays[i]);
            
            
        }
        rl.question('\n\nWoud you like to an add array? or search?\n(add/search) Input: ', (answer) => {
            answer = answer.trim().toLowerCase().substring(0,1);
            if (answer == 'a') {
                console.log('You selected add another array...\n\n');
                add_array();

            } else if (answer == 's') {
                console.log('bringing you to the search...');
                search_arrays();

            } else {
                console.log('Your selection was invalid, you will add another array.');
                add_array();
                
            }
        })
        
        
    })
}
add_array()

function search_arrays() {

    console.log('The available arrays to search in are...\n______________________________________');
    for (let i = 0; i < allArrays.length; i++) {
        console.log(i+1 + ": ", allArrays[i]);
    }
    console.log('________________________________________________\n');


    rl.question('Select the array/arrays you would like to search in by typing in the digit next to the array in the array list above.\n\nExample: 1,3 would select the first and third array if my array list was long enough,\n then return the largest number of both arrays to the console.\nInput: ', (arrayNums) => {
        arrayNums = arrayNums.trim().replace(/ /g, ',').split(',');
        let largestNum = Number.NEGATIVE_INFINITY;
        for (let i = 0; i < allArrays.length; i++) {
            for (let j = 0; j < arrayNums.length; j++) {
                if (arrayNums[j] == i + 1) {
                    for (let k = 0; k < allArrays[i].length; k++) {

                        if (allArrays[i][k] > largestNum) {
                            largestNum = allArrays[i][k];
                        }
                    }  
                }
            } 
        }
        console.log('\n\nThe largest number in all arrays chosen was ( ' + largestNum, ")");
        rl.question('\nWould you like to add to your list of arrays?\(anything but \'add\'\ will exit the program.\nInput: ', (answer) => {
            answer = answer.trim().substring(0,3).toLowerCase();

            if (answer == 'add') {
                add_array()
            } else {
                rl.close()
            }

        })
    }) 
}