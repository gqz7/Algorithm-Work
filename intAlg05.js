const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });


menu()

function menu() {
    
    rl.question('Would you like to convert a string to spinal case, or exit the program?\n(CONVERT/EXIT)\ninput: ', (answer) => {

        answer = answer.substring(0,1).toLowerCase();

        if (answer == 'c') {

            console.log('\nGreat! Please enter you string now...');

            convert()
            
        } else if (answer == 'e') {

            console.log('\n\nThank you for using the program!\nby gqs');
            rl.close()

        } else {
            console.log('\nThat is not a valid input, try again...\n\n');
            menu()
        }
    })
}

function convert() {

    rl.question('\ninput: ', (string) => {

        let newString = string.replace(/([a-z])([A-Z])/g, "$1 $2").toLowerCase().replace(/_/g, " ").trim().split(" ").join("-").replace(/([-])([-])/g, '$1');

        console.log(`your-spinal-case-string-is...\n\n${newString}\n\nThank you for using the program!\nby gqs`);

    })
}