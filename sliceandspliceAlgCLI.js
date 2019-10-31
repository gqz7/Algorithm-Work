var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    
    rl.question("How to format your array entry: [1,2,3] OR 1,2,3\nEnter an array you would like to splice another array into\n", (arr1) => {
        arr1 = arr1.trim().replace(/\[|\]/g, '').split(',');

        rl.question("Now enter your second array or peice of data\n", (arr2) => {
            arr2 = arr2.trim().replace(/\[|\]/g, '').split(',');

            rl.question(`Now that we have your two peices of data\nArray 1: ${arr1}\nArray 2: ${arr2}\nAt what index would you like second array to be spliced into?\nArr1:[1, 2], Arr2: ["a", "b"] INDEX: 1  will return ["a", 1, 2, "b"]\n-------\nIndex: `,
            (index) => {
                arr1.splice(index, 0, ...arr2);
                console.log(arr1);
                 rl.close();
            })
        })
    })
    
    