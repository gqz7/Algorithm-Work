//alphanumberic missing chars

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

      console.log('Enter a string with a portion of the alphabet and/or a portion of the decimal number sequence.\nYour output will show the missing characters\n');

find_missing()

function find_missing() {

    rl.question('________\ninput: ', (string) => {

        stringArr = string.trim().toLowerCase().replace(/\W/g, '').split('').sort();

        // console.log(stringArr);

        //check if the string provided is long enough to work with
        if (stringArr.length > 1) {

            let numStart = !isNaN(parseInt(stringArr[0])) ? stringArr[0] : null, numEnd, alphaStart, alphaEnd;

            //define the start and end points for the number/alpha sequences provided
            if (numStart != null) {
                
                for (let i = 0; i < stringArr.length; i++) {
                    if (isNaN(parseInt(stringArr[i]))) {
                        numEnd = stringArr[i-1];
                        alphaStart = stringArr[i];
                        alphaEnd = stringArr[stringArr.length-1];
                    }
                    
                }
            } else {

                
            }
            
            
            rl.close()
                
        } else {

            console.log('The string provided was not long enough to work with, please try again...\n\n');
            find_missing()
            return
        }

    });
    
}

    