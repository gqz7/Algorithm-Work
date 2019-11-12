var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

rl.question("Enter a string and the output will be converted into Pig Latin\nInput: ", (string) => {
    let alpha = /[a-z][A-Z]/,
        capital = /[A-Z]/,
        vowels =/[aeiouAEIOU]/;

     
    string = string.trim().split(/ /g);

    for (let i = 0; i < string.length; i++) {
        if (!vowels.test(string[i])) {
            string[i] = string[i] + "ay";
        } else if (vowels.test(string[i][0])) {
            string[i] = string[i] + "way";
        } else {
            let vowelFound = false;
                for (let j = 0; j < string[i].length; j++) {
                    if (!vowelFound && vowels.test(string[i][j])) {
                        if (capital.test(string[i][0])) {
                            string[i] = string[i].substring(j, j+1).toUpperCase() + string[i].substring(j + 1, string[i].length) + string[i].substring(string[i][0], j).toLowerCase() + "ay";
                            vowelFound = true;
                        } else {

                            string[i] = string[i].substring(j, string[i].length) + string[i].substring(string[i][0], j).toLowerCase() + "ay";
                            vowelFound = true;
                        } 
                    }
                }
 
        }
    }

    string = string.join(" ");


    console.log(`\n_____________________________\n\nYour Pig Latin phrase is: ${string} .\n-----------------------------\nThe program will now end...`);

    rl.close()

})