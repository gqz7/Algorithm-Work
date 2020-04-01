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

            for (let i = 0; i < string2.length; i++) {
                
                if (string1.includes(string2[i])) { 

                    sameCharacters.push(string2[i]);
                    string2.splice(i,1);
                    i--
                }
                
            }
            console.log('\n______________________________________________________________________________________________________\n');
            
            if (string2.length == 0) {
                console.log(`All characters in the second string were in the first string`);
            } else {
                console.log(`Not all characters in the second string were in the first string, the first string was missing`, ...string2);
            }
            console.log('______________________________________________________________________________________________________\nThe program is closing...');
            
            // console.log(sameCharacters, string2);
            
           rl.close()
            


        })
    })
}