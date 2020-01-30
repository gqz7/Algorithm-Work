//command line interface that convert english text into binary and binary into english


const readline = require('readline'),  
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

//intro
console.log('Welcome to the binary converting program. you will have the options of converting english text into binary, or binary into english text...\n\n');

nav_menu()

function nav_menu() {
    
    rl.question('1. English --> binary\n2. Binary --> English\n\nNumber input: ', (num) => {

        num = num.trim();

        switch (num) {
            case '1':
                
                break;

            case '2':
                
                break;
        
            default:

                console.log('That is not a valid input, try again...\n\n');
                nav_menu()
                
                break;
        }
    })
}

function convert_binarytostring() {

    rl.question('Enter a binary sequence and this program will convert it to a string\nBinary: ', (binary) => {

    })
    
}

function convert_stringtobinary() {

    rl.question('Enter a string and this program will convert it to a binary sequence\nBinary: ', (binary) => {
        
    })
    
}