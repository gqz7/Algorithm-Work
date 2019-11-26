const readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    let listOfNumbers = [];
add_to_list()
function add_to_list() {
    rl.question('Add a number to the list, or input "done" to find placement for a new number\nInput: ', (addto) => {

        if (addto == 'done') {
            find_placement()
        }

        addto = parseInt(addto);
        if (!isNaN(addto)) {

            listOfNumbers.push(addto);
            add_to_list()
            
        } else {
            console.log('That is not a number, try again\n\n');
            add_to_list()
        }
    })
}

function find_placement() {
    listOfNumbers.sort((a,b) => {return a-b})
    console.log(listOfNumbers);
    rl.question()
}