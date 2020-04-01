var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

function isItBoo() {
    rl.question('input a value and this program will let you know if it is considered a boolean or not.\nInput: ', (boo) => {

        if (boo == 'true' || boo == 'false') {
            console.log('Your input was a boolean value');
            rl.close();
        } else {
            rl.question('\nYour value was not a regular boolean would you like to try again?(yes/no)', (yon) => {
                yon = yon.trim().substring(0,1).toLowerCase();

                if (yon == 'y') {
                    isItBoo();
                } else {
                    rl.close()
                }
            })
        }
    })
}
isItBoo();