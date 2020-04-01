//palindrome checker

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      }),


      navigationMessage = 'Would you like to...\n1. Check if a string is a palindrome\n2. Create a palindrome\n3. Exit the program\n\nNumber Selection: ';
     
      //call navigation menu function to start program
      nav()

//this function will allow the user to select what they want the program to do next
function nav() {
    rl.question(navigationMessage, (num) => {

        num = parseInt(num);

        switch (num) {
            case 1:

            check_palindrome()
                
                break;
             case 2:

             create_palindrome()
                
                break;
             case 3:

             console.log('\nExiting the program, Thank you for using it!\n\nby gabriel sherman');
             
             rl.close()
                
                break;
        
            default:

            console.log('That was not a valid number input, try again...\n');

            nav()
            
                break;
        }

    })
}

//the user will be prompted to enter a string, it will return wether or not it is a palindrome
function check_palindrome() {

    rl.question('Enter a string to be checked if it is a palindrome\nInput: ', (string) => {

        let string0 = string.trim().replace(/ |[^a-z][^0-9][^A-Z]/g, '').toLowerCase(),
            string1 = string0.split('').reverse().join('');

        if (string0 === string1) {

            console.log(`\nAccording to my calculations...\n${string},\nis a palindrome!`);
            
        } else {

            console.log(`\nAccording to my calculations...\n${string},\nis NOT a palindrome`);
            
        }

        console.log('\nTaking you back to the navigation menu...\n\n');

        nav()

    })
    
}

//the user will be prompted to enter any string, and it will be appended to a copy of itself reversed, therefore a palindrome will be created
function create_palindrome() {

    rl.question('Enter a string and a palindrome will be created for you\nInput: ', (string) => {

        let newPal = string + string.split('').reverse().join('');

        console.log(`Your auto-generated palindrome is...\n${newPal}`);

        console.log('\nTaking you back to the navigation menu...\n\n');

        nav()

    })
    
}