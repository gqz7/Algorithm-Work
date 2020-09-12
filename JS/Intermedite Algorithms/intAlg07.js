const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let userString = '', userArr;

console.log('Welcome to the search and relpace program!\n You will first enter a string and then you can replace a specific string with whatever you want\n____________________________________________________________\n');

rl.question('Please enter a string\nString: ', (string) => {

    userString = string;
    
    word_to_be_replaced()
})

function word_to_be_replaced() {
    rl.question('\nEnter a substring from your string that you would like replaced\nString to be replaced: ', (string) => {

        userArr = userString.split(' ');

        if (userArr.includes(string)) {

            replacement_word(string)
            
        } else {
            console.log('That word is not found in your string, try again\n');
            word_to_be_replaced()
        }

        

    })
}

function replacement_word(replaced) {
    
    let i = userArr.indexOf(replaced);

    
    rl.question(`\nEnter a string to replace '${replaced}' with...\nString: `, (string) => {
        userArr.splice(i, 1, string);

        userString = userArr.join(' ');

        console.log('Your new string\n___________________________\n', userString, '\n\n\n');

        naviagtion()
        
    })
    
}

function naviagtion() {

    rl.question('Would you like to replace another word, or exit the program?\n(replace/exit)\nInput: ', (answer) => {
        answer = answer.substring(0,1).toLowerCase()
        if (answer = 'r') {

            word_to_be_replaced()
            
        } else if (answer = 'e') {

            rl.close()

        } else {

            console.log('\n---That was not a valid response, try again---\n');
            naviagtion()

        }
    })

}