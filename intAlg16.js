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
    
    rl.question('1. English --> binary\n2. Binary --> English\n3. Exit the program\n\nNumber input: ', (num) => {

        num = num.trim();

        switch (num) {
            case '1':

                convert_stringtobinary()
                
                break;

            case '2':

                convert_binarytostring()
                
                break;
            
            case '3':

                rl.close()

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

        enString = binary.split(' ');

        // console.log(enString);

        for (let i = 0; i < enString.length; i++) {

            enString[i] = String.fromCharCode(parseInt(enString[i], 2));
            
        };

        enString = enString.join('');

        console.log(`After converting your binary string to English characters your string is:\n\n${enString}\nTaking you back to the menu...\n`);
        
        nav_menu();
    
    })
    
}

function convert_stringtobinary() {

    rl.question('Enter a string and this program will convert it to a binary sequence\nBinary: ', (string) => {

        string = string.trim();

        let binarySequence = '';

        for (let i = 0; i < string.length; i++) {
            
            binarySequence += binary_conversion(string.charCodeAt(i)) + ' ';
            
        }

        console.log(`After converting your English string to binary your binary sequence is:\n\n${binarySequence}\nTaking you back to the menu...\n`);
        
        nav_menu();

    })
    
}

//this will work for standard ascii codes
function binary_conversion(decimal) {

    let biStr = ''

    for (let i = 6; i >= 0; i--) {

        // console.log(decimal, Math.pow(2, i));
            
        if (decimal - Math.pow(2, i) >= 0) {
            decimal -= Math.pow(2, i);
            biStr += '1';

        } else {
            biStr += '0';
        }
        
    }

    return biStr;
    
}