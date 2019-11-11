var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    
    console.log("Enter in some portion of the alphabet, the output will be the letters missing between the starting letter and ending letter\n Example sequence: abde  Output: 'c'\n_____________________________________\n");
    

rl.question("Your sequence: ", (sequence) => {
        sequence = sequence.trim();
        var alpha = /[a-z]/, missing = [];

        for (let i = sequence.charCodeAt(0); i < sequence.charCodeAt(sequence.length - 1); i++) {
            if (!sequence.includes(String.fromCharCode(i))) {
                missing.push(String.fromCharCode(i));
            }
        }
            
        console.log(`\n------------------------\nYour sequence started with ${sequence[0]}, and ended with ${sequence[sequence.length - 1]}\nYou were missing ${missing.length} characters of the alphabet; ${missing}`);
        
        rl.close()
        
})


        //  for (let i = sequence.charCodeAt(sequence[0]); i < sequence.charCodeAt(sequence[sequence.length -1]); i++) {
