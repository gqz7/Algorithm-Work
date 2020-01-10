const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      }),

      lineBreak = '______________________________________________';


console.log('You will enter two arrays and then the diffrence of thoes arrays will be found\n'+ lineBreak+ '\n\n');

rl.question('Enter your first array:\nFormat [1,2,3] or "4 5 6"\nFirst Array: ', (arr1) => {

    arr1 = arr1.replace(/\[|\]|\"|\'|/g, '').replace(/ /g, ',').split(',');

    // console.log(arr1);
    rl.question(`\n\nFirst Array: ${arr1}\nEnter your second array:\nSecond Array: `, (arr2) => {

        arr2 = arr2.replace(/\[|\]|\"|\'|/g, '').replace(/ /g, ',').split(',');

        console.log(`${lineBreak}\nFirst Array ${arr1}\nSecond Array ${arr2}`);

        let diffArr1 = arr1,
            diffArr2 = arr2,
            totalDif;

        for (let i = 0; i < diffArr1.length; i++) {
           
            for (let j = 0; j < diffArr2.length; j++) {
                

                if (diffArr1[i] == diffArr2[j]) {
                    
                    diffArr1.splice(i, 1);
                    diffArr2.splice(j, 1);
                    i--
                    j--
                }
                
            }
            
        }

        totalDif = diffArr1.concat(diffArr2);

        console.log(`\nDiffrence: ${totalDif}.`);
        
        
        rl.close()
    })
})