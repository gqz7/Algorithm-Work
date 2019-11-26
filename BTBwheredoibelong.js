var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

function add_to_list() {
    rl.question('Add a number to the list, or input "done" to find placement for a new number\nInput: ' (addto) => {
        addto = parseInt(addto);

        if (!isNaN(addto)) {
            
        } else if (addto = 'done') {
            find_placement()
        }
    })
}

function find_placement() {
    rl.question()
}