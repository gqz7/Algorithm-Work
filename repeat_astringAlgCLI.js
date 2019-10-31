var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

rl.question('Enter a string you would like repeated.\n', (string) => {

    if (string.length > 0) {
        string = string.trim();
        rl.question('Enter the number of times you would like the string to be repeated\n', (num) => {
           var repeatedString = '';
           for (let i = 0; i < num; i++) {
               repeatedString += string;
               
           }
            console.log(`-----------------------\nYour Repeated String: \n${repeatedString} ...`);
            rl.close();
        })

    } else {
        console.log('You did not enter a string that was long enough.');
        rl.close();
    }

})