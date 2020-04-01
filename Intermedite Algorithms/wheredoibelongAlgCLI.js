var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

rl.question('"How to format your array entry: [1,2,3] OR 1,2,3\nFirst enter an array with a length of 1 or more(repeats will be deleted)\n----------\nArray: ', (arr) => {
    arr = arr.trim().replace(/\[|\]|[a-z]/gi, '').split(',').sort((a, b) => {return a-b});
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] == "") {
            arr.splice(i, 1);
            i--
        } else if (arr[i] == arr[i+1]) {
            arr.splice(i, 1);
            i--
        } else {
            arr[i] = parseInt(arr[i]);
        }
        
    }
   
    rl.question('\n\nNow enter one integer and we will place it in your array, then sort in numerical order for you...\nand return the index it was placed in\n-----------\nNumber: ', (num) => {
        num.trim().replace(/\[|\]|[a-z]/gi, '');
        //num = parseInt(num);
        var index;
        for (let i = 0; i < arr.length; i++) {

            if (num > arr[arr.length -1]) {
                arr.splice(arr.length, 0, num);
                //ends the loop
                index = arr.length - 1;
                i = arr.length;
               
             } else if (num == arr[arr.length -1]) {
                index = arr.length - 1;
                i = arr.length;

             } else if ( num < arr[i]) {
                arr.splice(i, 0, num);
                index = i;
                i = arr.length;
            }
        }  
        console.log(`\nYour number was placed in index ${index}.\n(your number is the one not highlighted) The final array is:\n`, ...arr);
        rl.close();
    })
    
})