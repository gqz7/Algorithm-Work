var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

isitpalindrome()

function isitpalindrome() {
    rl.question('Enter a string and we will return if it is a palindrome or not\nInput: ', (string) => {
      string = string.replace(/ |\_|\.|\,|\\|\/|\-|\(|\)|\:/g, '').toLowerCase();  

     let reversedString = string.split('').reverse().join('');

     console.log(reversedString, string);
     

      if (string === reversedString) {
          console.log('\nYour string is a palindrome\n');
          
      } else {
          console.log('\nYour string is not a palindrome\n');
          
      }

      rl.question('Would you like to try another word?(y/n)\nInput: ', (yon) => {
          yon = yon.trim().toLowerCase().substring(0,1);
          if (yon == 'y') {
              console.log('Great! you will enter another word\n____________________________________________\n');
              isitpalindrome();
          } else {
              console.log('Thank you for using the program');
              rl.close()
          }
      })

})}