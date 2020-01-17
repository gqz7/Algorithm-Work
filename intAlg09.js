//alphanumberic missing chars

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

      console.log('Enter a string with a portion of the alphabet and/or a portion of the decimal number sequence.\nYour output will show the missing characters\n');
      

    rl.question('________\ninput: ', (string) => {

        string = string.trim().toLowerCase().replace(/\W/g, '').split('').sort();

        console.log(string);
        
        rl.close()
    });