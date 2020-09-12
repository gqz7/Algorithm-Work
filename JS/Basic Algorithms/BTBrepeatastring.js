var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

function repeat() {
    var repeatedString = '';
    rl.question('Enter a string you would like to have repeated\nString: ', (string) => {

        rl.question('How many times would you like your string to be repeated?\nNumber: ', (num) => {

            for (let i = 0; i < num; i++) {
                repeatedString += string;
                
            }
            console.log('\nYour repeated string output is...\n\n'+ repeatedString,"\n");
            
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
    })
    
}
repeat()