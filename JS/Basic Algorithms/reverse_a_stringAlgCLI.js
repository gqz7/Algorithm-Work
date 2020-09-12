var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
 rl.question("Enter a string you would like reversed\n", (q1) => {
     
    revStr = q1.split('').reverse().join("");
    console.log(`\nYour reversed string is...\n${revStr}\nthe program is ending now...`);
    rl.close()

 })