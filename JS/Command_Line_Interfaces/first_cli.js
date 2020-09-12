//THIS FILE IS USING NODE.JS

const readline = require('readline'),

      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

      FirstQuestion()

function FirstQuestion(answer) {

    rl.question('Enter A String And It Will Be Reversed\nString: ', (answer) => {

        //REVERSE A STRING

        let newAnswer = '';

        for (let i = answer.length-1; i >= 0; i--) {

            newAnswer += answer[i];
            
        }

        console.log(`\nOriginal: ${answer}\nReversed: ${newAnswer}\n`); //display the reversed string
        
        rl.question(`Would you like to try again?\n(y/n)\ninput: `, SecondQuestion)
    
    })  
    
}


function SecondQuestion(answer) {

    answer = answer.toLowerCase().substring(0,1);

    if (answer == 'y') {
        
        FirstQuestion()

    } else {
        
        rl.question('Rate Your Experience 1 to 10\nRating: ', (num) => {
            
            console.log('\n\nThankyou for your feedback, now closing the program...');
            
            rl.close()
        })
    }
    
}