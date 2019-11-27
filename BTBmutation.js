var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

mutation()
function mutation() {
    let sameCharacters = [];

    rl.question('Enter a string and a second string input will be used to test if your first string contains all the characters.\nFirst String: ', (string1) => {
        string1 = string1.trim().toLowerCase();

        rl.question('Enter a second string, it will be tested to see if all its characters are in your first string.Second String: ', (string2) => {
            string2 = string2.trim().toLowerCase().split('');

            for (let i = 0; i < string1.length; i++) {
                
                if (string2.includes(string1[i])) { 

                    sameCharacters.push(string1[i]);
                }
                
            }
            console.log(sameCharacters);
            


        })
    })
}