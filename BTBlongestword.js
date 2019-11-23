var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

function longest_word() {
    
    let longest = '';
    rl.question('Enter a string and the first instance of the longest word/words will be ouput in the console.\nString: ', (string) => {
        string = string.trim().split(" ");

        for (let i = 0; i < string.length; i++) {
            
            if (string[i].length > longest.length) {
                longest = string[i];
            }
        }

        console.log(`The longest word in your string was '${longest}'.`);
        
        rl.question('Do you want to try again?\(\'no\' to exit\): ', (yon) => {
                if (yon == 'no') {
                    console.log('\nThe program will not end...');
                    rl.close()
                } else {
                    console.log('The program will run once more...\n\n');
                    longest_word();
                }
            });
    })
}
longest_word()