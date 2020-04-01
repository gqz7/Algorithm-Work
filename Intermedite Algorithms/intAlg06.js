// If a word begins with a vowel you just add "way" to the end.

// If a word does not contain a vowel, just add "ay" to the end.

// else take the first letter at ay to it and attach that to the end of the word

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      }),
      vowels = /[aeiou]/;

rl.question('Enter a string and it will be converted into piglatin for you\nInput: ', (string) => {

    words = string.split(' ');

    for (let i = 0; i < words.length; i++) {

        // console.log(vowels.test(words[i][0]));
        
        words[i] = piglatinConvert(words[i]);

        // console.log(words[i]);
        
    }

    words = words.join(' ')
    
    //Result
    console.log(`\n\n\nYour Piglatin Phrase is:\n--------------------------\n${words}`);
    

    rl.close()
})


function piglatinConvert(enWord) {

    if (vowels.test(enWord[0])) {

        return enWord = enWord+'way';
        
    } else if (vowels.test(enWord)) {

        for(let i = 0; i < enWord.length; i++) {
            if (vowels.test(enWord[i])) {

                return enWord = enWord.substring(i, enWord.length) + enWord.substring(0, i) + 'ay';

            }
            
        }

    } else {

        enWord = enWord+'ay';
        return enWord
    }
    
}
