const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let userString = '';

console.log('Welcome to the search and relpace program!\n You will first enter a string and then you can replace a specific string with whatever you want\n____________________________________________________________\n');

rl.question('Please enter a string\nString: ', (string) => {

    userString = string;
    
    word_to_be_replaced()
})

function word_to_be_replaced() {
    rl.question('Enter a substring from your string that you would like replaced\nString to be replaced: ', (string) => {

        let userArr = userString.split(' ');

        if (userArr.includes(string)) {
            console.log('true');
            rl.close()
            
        } else {
            console.log('That word is not found in your string, try again\n\n');
            word_to_be_replaced()
        }

        

    })
}