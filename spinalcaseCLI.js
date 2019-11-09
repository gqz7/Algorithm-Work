var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    })
rl.question("Enter in a string and it will be converted into spinal case. \nEx; input: this is Spinal ---- output: this-is-spinal\nInput: ", (string) => {
    string = string.replace(/([a-z])([A-Z])/g, "$1 $2" ).toLowerCase().trim().split(/,| |_/);
    for (let i = 0; i < string.length - 1; i++) {
       string[i] = string[i] + "-";
    }
    string = string.join("");
    console.log(`________________\nOutput: ${string} \n the program will now end...`);
    rl.close()
});