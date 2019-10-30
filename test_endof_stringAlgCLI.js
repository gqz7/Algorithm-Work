var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

rl.question('Please first enter a string.\n', (string) => {
    if (string.length > 0) {
        console.log(("------------\nThank you.\n--------------"));
    rl.question("Now enter an end portion of your string.\n", (end) => {
        if (string.substring(string.length - end.length, string.length) == end) {
            console.log(`---\n${end}, was at the end of your string.`);
            rl.close();
            
        } else {
            console.log(`---\n${end}, was not the end of your string.`);
            rl.close();
        }

    })
    } else {
        console.log('you did not type something long enough to work with, try again.');
        rl.close();
        
    }
    
    
})