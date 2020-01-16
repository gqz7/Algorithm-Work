//dna pairing

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let rules = [];

//intro
console.log('\n\n\nWelcome to the DNA Pairing service, firstly you will need to enter your rule set\n');
console.log('Your input will be two characters seperated by a comma or a single space.');
console.log('\n --- NOTE all alphabet characters will be converted to UPPERCASE no lowercase characters will be present in the final sequence ---');
console.log('\nThose characters will be paired when creating you sequence, so whenever a character is detected, its pair will be ajoined.');

//the user must have at least one rule to create a squence, therefore the first step for them is to create one rule
set_rules()


//FUNCTIONS
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//NAVIGATION MENU
function navigation() {

    rl.question('\nWould you like to add a new rule, or create your squence\n(rule/squence)\nInput: ', (answer) => {
        answer = answer.substring(0,1).toLowerCase();

        if (answer == 'r') {
            set_rules()
        } else if (answer == 's') {
            create_sequence()
        } else {
            console.log('That was not a vaild response, try again...\n');

            navigation()
            
        }
    })
    
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// CREATING A RULE FOR A PARING
function set_rules() {

    rl.question('\nEnter two characters seperated by a space or a comma to distigush them.\nInput: ', (pair) => {

        pair = pair.replace(/ /g, ',').toUpperCase().split(',').filter(elm => {return elm != ''}).splice(0,2);

        if (pair.length < 2) {
            console.log('That was not a valid pairing, please try again and enter more than one character');
            set_rules()
            return
        }

        // console.log(pair);

        for (let i = 0; i < rules.length; i++) {
           
            if (rules[i].includes(pair[0])) {

                console.log('\nThere is already a rule created for', pair[0], 'try to create a new rule...\n');
                set_rules()
                return
            } else if (rules[i].includes(pair[1])) {

                console.log('\nThere is already a rule created for', pair[1], 'try to create a new rule...\n');
                set_rules()
                return
            }  
        }
        console.log(`\nA new rule has been created, (${pair[0]} - ${pair[1]})\nif ${pair[0]} is found in the sequence, ${pair[1]} will be ajoined and viceversa`);
        rules.push(pair);

        navigation()

    })
    
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//CREATING THE SEQUENCE
function create_sequence() {
    
    rl.question('Enter a string of characters you created rules for, their pair will be ajoined ')
    
}

