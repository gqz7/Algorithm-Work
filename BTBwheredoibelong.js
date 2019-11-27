const readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    let listOfNumbers = [], index;

add_to_list()
function add_to_list() {
    rl.question('\n\nAdd a number to the list, or input "done" to find placement for a new number\nAll inputs will be saved as integers\nInput: ', (addto) => {

        if (addto == 'done') {
            find_placement()
            return

        } else {
            addto = parseInt(addto);
        }
        
        if (!isNaN(addto)) {

            listOfNumbers.push(addto);
            add_to_list()
            
        } else {
            console.log('\nThat is not a number, try again\n');
            add_to_list()
        }
    })
}

function find_placement() {

    rl.question('\nEnter a number and we will find its place in the list\nNumber: ', (placementNum) => {
        let isItANum = placementNum;
            isItANum = parseInt(isItANum);

        if (!isNaN(isItANum)) {
  
                listOfNumbers.push(placementNum);
                listOfNumbers.sort((a,b) => {return a-b});
                index = listOfNumbers.indexOf(placementNum);

            console.log('\n\n\n\n\n');
            result()

        } else {
            console.log('Your input was not a number, please try again...\n\n');
            find_placement()
            
        }
    })
}

function result() {
    
    rl.question('Would you like to display your full array with the new number in place,\n OR would you like to know the index your new number is at in the array?\n(or "end" the program)\n\n(display/index/end)\nInput: ', (answer) => {
        answer = answer.trim().toLowerCase().substring(0,1);

        if (answer == 'd') {

            console.log(`\n(your new number is the one NOT highlighted)\nYour New Array;\n____________________________________________________________\n\n`, ...listOfNumbers, `\n____________________________________________________________\n\n`);
            result()

        } else if (answer == 'i') {

            console.log(`\n______________________________\n\nYour new number was placed at index ${index}!\n______________________________\n`);
            result()

        } else if (answer == 'e') {
            rl.close()
            
        } else {
            console.log('This is not a valid entry, please try agian...\n\n\n');
            result()
            
        }
    })
}