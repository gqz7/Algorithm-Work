var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

function confirm() {
    
    rl.question('First enter a string of any length.\nString:', (string) => {
        string = string.trim();

        rl.question('Enter any portion of your string including the end, and we will confirm it for you.\nEnd: ', (end) => {

            // console.log(end, string.substring(string.length - end.length, string.length));
            
            if (end == string.substring(string.length - end.length, string.length)) {
                console.log('\nYour string ending is confirmed true!\n');
                
            } else {
                console.log('\nThe string end was false...\n');
                
            }

            rl.question('Do you want to try again?\(\'no\' to exit\): ', (yon) => {
                if (yon == 'no') {
                    console.log('\nThe program will not end...');
                    rl.close()
                } else {
                    console.log('The program will run once more...\n\n');
                    confirm();
                }
            });
        })
    })
}
confirm()