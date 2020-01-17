//alphanumberic missing chars

//VARIABLE DECLERATION
const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let missingAlpha = [], missingNums = [], stringArr, numStart, numEnd, alphaStart, alphaEnd;

//intro
console.log('Enter a string with a portion of the alphabet and/or a portion of the decimal number sequence.\nYour output will show the missing characters\n');

//SET FUNCTION
set_ranges()

function set_ranges() {

    rl.question('________\ninput: ', (string) => {

        stringArr = string.trim().toLowerCase().replace(/\W/g, '').split('').sort();

        // console.log(stringArr);

        //check if the string provided is long enough to work with
        if (stringArr.length > 1) {

            numStart = !isNaN(parseInt(stringArr[0])) ? stringArr[0] : null;            

            //define the start and end points for the number/alpha sequences provided
            if (numStart != null) {
                
                for (let i = 0; i < stringArr.length; i++) {

                    if (isNaN(parseInt(stringArr[i]))) {

                        numEnd = stringArr[i-1];
                        alphaStart = stringArr[i];
                        alphaEnd = stringArr[stringArr.length-1];

                        i = stringArr.length
                    }
                    
                }
            } else {
                
                alphaStart = stringArr[0];

                alphaEnd = stringArr[stringArr.length-1];
                
            }

            // console.log(numStart, numEnd, alphaStart, alphaEnd);
            
            if (numStart != null) {
                find_missing_nums(numStart, numEnd)
                
            }

            if (alphaStart != undefined) {
                find_missing_alpha(alphaStart, alphaEnd)
                
            }

            display()
        
        //if the user entered a string too short they are prompted to try again
        } else {

            console.log('The string provided was not long enough to work with, please try again...\n\n');
            set_ranges()
            return
        }

    });
    
}

//Finds the missing alphabet characters in the users input
function find_missing_alpha(start, end) {

    for (let i = start.charCodeAt(0) + 1; i < end.charCodeAt(0); i++) {
        
        // console.log(i);

        if (!stringArr.includes(String.fromCharCode(i))) {

            missingAlpha.push(String.fromCharCode(i));

        }
    
    }

}

//Finds the missing numbers in the users input
function find_missing_nums(start, end) {

    for (let i = start.charCodeAt(0) + 1; i < end.charCodeAt(0); i++) {
        // console.log(i);

        if (!stringArr.includes(String.fromCharCode(i))) {

            missingNums.push(String.fromCharCode(i));

        }
        
    }
    
}

function display() {

    console.log('\n_____________________________________________________________________\nResults');
    
    //display number results
    if (missingNums.length > 0) {

        console.log(`\n\nYour sequence started with ${numStart} and ended with ${numEnd},\nyou were missing: ${missingNums}\n`);
        
    } else if (alphaStart != undefined) {

        console.log('\nYou were not missing any numbers\n');

    } 

    //display alphabet results

    if (missingAlpha.length > 0) {

        console.log(`\nYour sequence started with ${alphaStart} and ended with ${alphaEnd},\nyou were missing: ${missingAlpha}\n`);
        
    }  else if (alphaStart != undefined) {

        console.log('\nYou were not missing any letters of the alphabet\n');

    } 

    //end program
    console.log('Program closing...');
    
    rl.close()
    
}  