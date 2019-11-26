var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });


    console.log('Welcome to title case your string\n');
    
t_c();
function t_c() {
    

    rl.question('enter a string and it will be title cased for you\nYour string: ', (string) => {
        stringArray = string.split(' ');
        // console.log(stringArray);
        let finalSentence = '';

       for (let i = 0; i < stringArray.length; i++) {
          var newWord = stringArray[i].substring(0,1).toUpperCase() + stringArray[i].substring(1).toLowerCase();
          finalSentence += newWord + " ";
           
       }
       console.log(`\n____________________________________________\n\nYour Title Cased string is: ${finalSentence}\n____________________________________________\n`);

        rl.question('Would you like to try the program again?("no" to exit)\nInput: ', (yon) => {
            yon = yon.trim().toLowerCase().substring(0,1);

            if (yon == 'n') {
                console.log('The program is ending...');
                rl.close();
                
            } else {
                console.log('The program will run one more time...');
                    rl.question('ARE YOU SURE\nInput: ', (yon) => {
                        yon = yon.trim().toLowerCase().substring(0,1);

                        if (yon == 'y') {
                            console.log('The program will run one more time...');
                            rl
                            t_c();
                            
                        } else {
                            rl.close()
                            
                        }
                     })//quesiton 3
            }
        })//question 2
    })//question 1
}

