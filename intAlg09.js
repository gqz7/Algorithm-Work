//alphanumberic missing chars

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let missingAlpha = [], missingNums = [];

console.log('Enter a string with a portion of the alphabet and/or a portion of the decimal number sequence.\nYour output will show the missing characters\n');

set_ranges()

function set_ranges() {

    rl.question('________\ninput: ', (string) => {

        stringArr = string.trim().toLowerCase().replace(/\W/g, '').split('').sort();

        console.log(stringArr);

        //check if the string provided is long enough to work with
        if (stringArr.length > 1) {

            let numStart = !isNaN(parseInt(stringArr[0])) ? stringArr[0] : null,
            numEnd, alphaStart, alphaEnd;

            

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

            console.log(numStart, numEnd, alphaStart, alphaEnd);
            
            if (numStart != null) {
                find_missing_nums(numStart, numEnd)
            }

            if (alphaStart != undefined) {
                find_missing_alpha(alphaStart, alphaEnd)
            }
            
            rl.close()
        
        //if the user entered a string too short
        } else {

            console.log('The string provided was not long enough to work with, please try again...\n\n');
            set_ranges()
            return
        }

    });
    
}

function find_missing_alpha(start, end) {

}


function find_missing_nums(start, end) {
    
}

    