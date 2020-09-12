var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

function trunk() {
    let trunkString;
    rl.question('Enter your string\nString: ', (string => {

        rl.question('Now enter how many characters you would like to keep in your trunkated string\nLength: ', (num) => {

            trunkString = string.substring(0,num) + "...";

            console.log('Your trunkated string is', trunkString);

            rl.question('Do you want to try again?\(\'no\' to exit\): ', (yon) => {

                if (yon == 'no') {
                    console.log('\nThe program will not end...');
                    rl.close()

                } else {
                    console.log('The program will run once more...\n\n');
                    repeat();

                }
            });
        })
    }))
}
trunk()