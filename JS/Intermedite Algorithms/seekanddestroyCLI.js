var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    })

console.log("Welcome to Seek and Destroy Your Arrays!\n___________________________________\n\n");
start();
function start(){rl.question("Enter an array, then we will ask what you would like removed from it.\nArray: ", (arr) => {
    newArr = arr.trim().replace(/ |\[|\]/g, "").split(",");
    if (newArr.length < 1) {
        console.log("That is not an array of values, try again\n________________________\n");
        start();
    }
    rl.question(`\n__________\nNow enter in mulitiple values in an array format (or just seperated by ',') or a single value as is, then your array\nYour Array: [${newArr}],will have the values you entered deleted.\Values: `, (valuesDestroying) => {
        valuesDestroying = valuesDestroying.trim().replace(/ |\[|\]/g, "").split(",");
            for (let i = 0; i < newArr.length; i++) {
                if (newArr[i] === "") {
                    newArr.splice(i,1);
                    i--
                }
                //this forloop below is nested
                for (let j = 0; j < valuesDestroying.length; j++) {
                    
                    if (newArr[i] === valuesDestroying[j]) {
                        newArr.splice(i,1);
                        i--, j--;
                    }   
                } 
            }
            console.log(`Your new array is now equal;\n[${newArr}]\n__________________________________\nThank you for using the program, it will now end...`);   
            rl.close()

    })  
})}