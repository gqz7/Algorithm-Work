var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

function reverse() {
    rl.question(
        'Enter a string and it will be reversed and the output will be displayed for you.\nString: ', (string) => {

            let reversedS = '';

            for (let i = string.length -1; i > -1; i--) {
               reversedS += string[i];
                
            }

            console.log(`\n________________________________\nYour reversed string is: ${reversedS}\n________________________________\n`);

            rl.question('Do you want to try again?\(\'no\' to exit\):  ', (yon) => {

                if (yon == 'no') {
                    console.log('\nThe program will not end...');
                    rl.close()

                } else {
                    console.log('The program will run once more...\n\n');
                    reverse();

                }
            });
        }
    )
}
reverse()