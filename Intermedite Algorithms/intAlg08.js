//dna pairing

//global variables
const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let rules = [];

//intro
console.log('\n\n\nWelcome to the DNA Pairing service, firstly you will need to enter your rule set!');
console.log('\nYour input will be two characters seperated by a comma or a single space.');
console.log('\n --- NOTE all alphabet characters will be converted to UPPERCASE no lowercase characters will be present in the final sequence ---');
console.log('\nThose characters will be paired when creating you sequence, so whenever a character is detected, its pair will be ajoined.');

//the user must have at least one rule to create a squence, therefore the first step for them is to create the first rule
set_rules()


//FUNCTIONS
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//NAVIGATION MENU
function navigation() {

    rl.question('\nWould you like to add a new rule, or create your sequence\n(rule/sequence)\nInput: ', (answer) => {
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

function nav_after_sequence() {

    rl.question('\nWould you like to...\n add a new rule, display another sequence w/ same rules or EXIT the program\n(rule/sequence/exit)\nInput: ', (answer) => {
        answer = answer.substring(0,1).toLowerCase();

        if (answer == 'r') {
            set_rules()
        } else if (answer == 's') {
            create_sequence()
        } else if (answer == 'e') {

            rl.close()

        } else {
            console.log('That was not a vaild response, try again...\n');

            nav_after_sequence()
            
        }
    })
    
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// CREATING A RULE FOR A PARING
function set_rules() {

    rl.question('\nEnter two characters\nInput: ', (pair) => {

        pair = pair.replace(/\W/g, '').toUpperCase().split('').filter(elm => {return elm != ''}).splice(0,2);

        if (pair.length < 2 || pair[1] === pair[0]) {
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

    console.log('\nEnter a string of characters you created rules for, their pair will be ajoined in the format [A-B][C-D]');
    console.log("EXAMPLE: Rules; [A,B], [C,D] Sequence; aabcbd Output; [A-B][A-B][B-A][C-D][B-A][D-C]");
    console.log('\n -- NOTE -- any characters not accociated with a pair will be ignored\n\nYour Rules: ');

    for (let i = 0; i < rules.length; i++) {
        console.log(rules[i]);
        
    }
    
    rl.question('\n\nEnter you sequence\nInput: ', (sequence) => {
        sequence = sequence.toUpperCase().replace(/\W/g, '').split(''); //put each alphanumeric character in an array of single characters 

        //loop that pairs up the characters
        for (let i = 0; i < sequence.length; i++) { 

            let paired = false; //if the boolean stays false then the character will be deleted from the array
            
            for (let j = 0; j < rules.length; j++) { //this nested loop will check if there is a rule for the current char
                
                if (rules[j][0] == sequence[i]) {

                    sequence[i] = `[${sequence[i]}-${rules[j][1]}]`;
                    paired = true;
                    
                } else if (rules[j][1] == sequence[i]) {

                    sequence[i] = `[${sequence[i]}-${rules[j][0]}]`;
                    paired = true;

                }
                
            }

            if (!paired) {  //deletes the characters that done have a pair
                sequence.splice(i,1);
                i--
            }
            
        }

        //puts the sequence back into string form then displays it

        sequence = sequence.join('');
        let lb = '_'
        console.log('\n' + lb.repeat(sequence.length + 3) + '\n');
        
        console.log(`Your sequence is...\n${sequence}`);
        
        nav_after_sequence()

    })

}

