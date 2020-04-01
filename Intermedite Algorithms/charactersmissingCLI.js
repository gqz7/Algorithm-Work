var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    
    console.log("Enter in some portion of the alphabet or the decimal system, the output will be the characters missing between the starting character of the sequence and ending character\n Example sequence: abde  Output: 'c' OR input: 134 , output: 2\n_____________________________________\n");
    

rl.question("Your sequence: ", (sequence) => {
        sequence = sequence.trim().toLowerCase().replace(/\ |\-|\_|\+|\=|\\|\||\`|\~|\.|\,|\'|\"|\[|\]|\;|\:|\{|\}|\>|\<|\?|\!|\@|\#|\$|\%|\^|\&|\*|\(|\)|\n|\r/g , '').split("");
        var alpha = /[a-z]/, nums = /[0-9]/, missingNums = [], missingLetters = [], numEnd;

        sequence.sort();
        // console.log(sequence);
        for (let i = 0; i < sequence.length; i++) {
             if (nums.test(sequence[i]) && alpha.test(sequence[i+1])) {
                console.log(sequence[i]);
                numEnd = i;
            }
            
        }
        sequence = sequence.join("");

        for (let i = sequence.charCodeAt(0); i < sequence.charCodeAt(numEnd); i++) {

            if (nums.test(String.fromCharCode(i)) && nums.test(String.fromCharCode(i + 1))) {
                if (!sequence.includes(String.fromCharCode(i))) {
                missingNums.push(String.fromCharCode(i));
                
                }
            }
        }

        for (let i = sequence.charCodeAt(numEnd+1); i < sequence.charCodeAt(sequence.length-1); i++) {
            
            if (alpha.test(String.fromCharCode(i)) && alpha.test(String.fromCharCode(i + 1))) {
                if (!sequence.includes(String.fromCharCode(i))) {
                missingLetters.push(String.fromCharCode(i));

                }
            }
        }
        console.log(':OUTPUT:\n----------------------------------------------------------\n');
        
        if (nums.test(sequence) && alpha.test(sequence)) {
            console.log(`Your number sequence started with ${sequence[0]}, and ended with ${sequence[numEnd]}.\nThen your letter sequence started with ${sequence[numEnd + 1]} and ended with ${sequence[sequence.length - 1]}.\n\nYou were missing ${missingLetters.length} characters of the alphabet; ${missingLetters}\nAnd missing ${missingNums.length} of the decimal number sequence; ${missingNums}`);
            
        } else if (nums.test(sequence)) {
            console.log(`Your decimal sequence started with the number ${sequence[0]}, and ended with the number ${sequence[sequence.length - 1]}\nYou were missing ${missingNums.length} characters of the decimal number sequence; ${missingNums}`);

        } else if (alpha.test(sequence)) {
            console.log(`Your sequence started with the letter ${sequence[0]}, and ended with letter ${sequence[sequence.length - 1]}\nYou were missing ${missingLetters.length} characters of the alphabet; ${missingLetters}`);

        } else {
            console.log('Your string did not include numbers or letters');
            
        }
            
        // console.log(`Your sequence started with ${sequence[0]}, and ended with ${sequence[sequence.length - 1]}\nYou were missing ${missing.length} characters of the alphabet; ${missing}`);
        
        rl.close()
        
});


        //  for (let i = sequence.charCodeAt(sequence[0]); i < sequence.charCodeAt(sequence[sequence.length -1]); i++) {
