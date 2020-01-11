//seek and destroy

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

rl.question('Enter an array\ninput: ', (arr) => {
    arr = arr.replace(/\[|\]|\"|\'|/g, '').replace(/ /g, ',').split(',');

    
    rl.question('\nNow Enter a value or an array of values\nthoes that match the value in the current array will be destroyed\ninput: ', (destroyArr) => {
        destroyArr = destroyArr.replace(/\[|\]|\"|\'|/g, '').replace(/ /g, ',').split(',');


        for(let i = 0; i < arr.length; i++) {
            if (destroyArr.includes(arr[i])) {
                arr.splice(i, 1);
                i--
            }
        }

        console.log(`\n_____________________________\nYour final array is...\n\n${arr}\n\nThank you for using the program...\n`);
        
        rl.close()
    })
    
})