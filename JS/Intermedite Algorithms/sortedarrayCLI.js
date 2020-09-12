var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

console.log("\n\n\nWelcome to the Array Sorting Program, you will enter any number of arrays you would like and they will be put into a new array in order, without any repeats!\n__________________________________________________________________________________________________\n");

var uniArray = [];



function add_array() {
    rl.question("Enter and array or type 'done' to sort your arrays and exit the program\n----------\nInput: ", (array) => {
        if (array == "done") {
            finish();
        } else {

            array = array.trim().replace(/[|]/g, '').split(',');

            for (let i = 0; i < array.length; i++) {
                
               if (!uniArray.includes(array[i]) && array[i] == "") {

                  uniArray.push(array[i]);

               }
            }

            rl.question("\n_______________________________________\nIf you would like to add an array, input 'ADD'.\nOtherwise your array will be sorted and displayed\nInput: ", (confirm) => {
                confirm = confirm.trim().toLowerCase();
                if (confirm === "add") {
                    add_array();
                } else {
                    finish();
                }
            })       
        }

})
}

function finish() {

    uniArray.sort((a,b) => {return a-b});
            console.log(`${uniArray}\nThe program will now end...`);
            rl.close();

}

add_array()


