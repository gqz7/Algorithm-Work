let readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    spinal_case()


    function spinal_case() {
        rl.question('Enter a string to be spinal cased\nString: ', (str) => {

            let newString = str.replace(/ /g, '-'), spinalStr;

            const upperCase = /[A-Z]/;

            const alpha = /[a-zA-Z]/;

            for (let i = 0; i < newString.length; i++) {

                if (newString[i+1] && alpha.test(newString[i]) && upperCase.test(newString[i+1]) ) {

                    newString = newString.substring(0,i+1) + '-' +newString[i+1].toLowerCase() + newString.substring( i+2, newString.length );
                    
                    i++
  
                } else if ( newString[i+1] && newString[i] == '_') {

                    newString = newString.substring(0,i) + '-' +newString[i+1].toLowerCase() + newString.substring( i+2, newString.length );
                    i++
                }
                
            }

            newString = newString.toLowerCase();

            console.log(`\nThe Spinal Case String:\n${newString}\n\n\n`);
            
            rl.question('Would you like to try again?\n(y/n)\nInput: ', (answer) => {

                if (answer.toLowerCase().substring(0,1) == 'y') {
                    spinal_case()
                } else {
                    
                    console.log('Closing program...');
                    
                    setTimeout(() => {
                        rl.close()
                    },1000)
                    
                    
                }

            })
        })
    }

