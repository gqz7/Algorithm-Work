var readline = require('readline'),
rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter a string that you will truncate (removing end)\n', (string) => {
   if (string.length > 0) {
       rl.question('Great! Now please enter how long you would like your truncated string to be.\n', (num) => {
           var trcString = string.substring(0, num);
           console.log(`-----------------------\nOriginal String: ${string}\nTruncated String: ${trcString}...`);
           rl.close();
       })
   } else {
    console.log("one can not shorten nothing...");
    rl.close();
   }
})