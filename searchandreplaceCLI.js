var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });


console.log("Enter a string and then enter a word you would like replaced, followed by a replacement word. Then your new string will be displayed.");

rl.question("Please enter string\nString: ", (string) => {


    string = string.trim().split(" ");
    rl.question("Enter a word to be replaced, then the string you would like to be replaced with, formated like-- replaced-word,replacement-word\nWord Replacement: ", (words) => {
        words = words.split(",");
        if (words[1].substring(0,1) === " ") {
            words[1] = words[1].substring(1,words[1].length);
        }
        for (let i = 0; i < string.length; i++) {
            if (string[i] == words[0]) {
                string[i] = words[1];
            }
            
        }
            string = string.join(" ");
            console.log(string);
            rl.close();

    })
    
})