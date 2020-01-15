//dna pairing

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

//intro
console.log('Welcome to the DNA Pairing service, firstly you will need to enter your rule set\n');
console.log('Your input will be two characters seperated by a comma or a single space.\nThose characters will be paired, so whenever an input of on character is detected, its pair will be inserted.');

//functions

set_rules()

function set_rules() {

    rl.question('\nEnter two characters seperated by a space or a comma to distigush them.', (pair) => {
        
    })
    
}