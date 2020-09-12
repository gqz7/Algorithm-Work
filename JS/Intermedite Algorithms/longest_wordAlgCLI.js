var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
rl.question('Type in a sentences and we will tell you the longest word you typed\n', (string) => {
    string = string.split(" ");
    
    var longestWord = "";
    for (let i = 0; i < string.length; i++) {
        if (string[i].length > longestWord.length) {
            longestWord = string[i];
        }
        
    }
    string = string.join(" ");
    //console.log(string, longestWord);
    console.log(`-------------------------------\nThe longest word in that sentence was ${longestWord}.\nGoodbye...`);
    rl.close();
})