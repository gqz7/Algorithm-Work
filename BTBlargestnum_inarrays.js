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
        rl.question('Woud you like to an add array? or search?\n(add/search) Input: ', (answer) => {
            answer = answer.trim().toLowerCase().substring(0,1);
            if (answer == 'a') {
                console.log('You selected add another array...\n\n');
                add_array();

            } else {
                console.log('bringing you to the search...');
                search_arrays();
            }
        })
        
        
    })
}
add_array()

function search_arrays() {

    console.log('The available arrays to search in are...'\n______________________________________);
    for (let i = 0; i < allArrays.length; i++) {
        console.log(i+1 + ": ", allArrays[i]);
    }
    console.log('________________________________________________\n');
    
    
//NEXT STEP add ability to select any number of arrays and search for the largest number in all that were selected

}