//seek and destroy

const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      }),

      lb = '__________________________________';

console.log(`${lb}\n\nARRAY FORMAT --- [1,2,3] or "4 5 6"\n${lb}\n`);


rl.question('Enter an array\ninput: ', (arr) => {
    arr = arr.replace(/\[|\]|\"|\'|/g, '').replace(/ /g, ',').split(',');

    arr = arr.filter((elm) => elm != '' );

    console.log(`Your array: ${arr}`);
    
    
    rl.question('\nNow Enter a value or an array of values\nthoes that match the value in the current array will be destroyed\ninput: ', (destroyArr) => {
        destroyArr = destroyArr.replace(/\[|\]|\"|\'|/g, '').replace(/ /g, ',').split(',');


        for(let i = 0; i < arr.length; i++) {
            if (destroyArr.includes(arr[i])) {
                arr.splice(i, 1);
                i--
            }
        }

        let message = arr.length != 0 ? 'Your final array is' : 'Your array is now empty';
            

        console.log(`\n\n${message}...\n${lb}\n\n${arr}\n${lb}\nThank you for using the program...\ncreated by gqs`);
        
        rl.close()
    })
    
})