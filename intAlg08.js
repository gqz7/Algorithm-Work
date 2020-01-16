//dna pairing

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let rules = [];

//intro
console.log('Welcome to the DNA Pairing service, firstly you will need to enter your rule set\n');
console.log('Your input will be two characters seperated by a comma or a single space.\nThose characters will be paired, so whenever an input of on character is detected, its pair will be inserted.');

//functions

set_rules()

function set_rules() {

    rl.question('\nEnter two characters seperated by a space or a comma to distigush them.\nInput: ', (pair) => {

        pair = pair.replace(/ /g, ',').split(',').filter(elm => {return elm != ''}).splice(0,2);

        rules.push(pair);

        console.log(pair);
        
        navigation()

    })
    
}

function create_squence() {
    
}

function navigation() {

    rl.question('\nWould you like to add a new rule, or create your squence\n(rule/squence)\nInput: ', (answer) => {
        answer = answer.substring(0,1).toLowerCase();

        if (answer = 'r') {
            set_rules()
        } else if (answer = 's') {
            create_squence()
        } else {
            console.log('That was not a vaild response, try again...\n');

            navigation()
            
        }
    })
    
}