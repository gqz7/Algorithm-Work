var readline = require('readline'),
    diffrence = [],
rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

console.log("Welcome to the Array Diffrence Finder: enter two arrays and we will find the diffrence\n---------------------------\n");

///FIRST QUESTION
rl.question('\nPlease enter your first array: ', (arr1) => {
    var array1 = arr1.trim().replace(/\[|\]| /g, "").split(","),
        arr1modified = array1,
        regEx = /[a-z]|'|"/g;
    for (let i = 0; i < array1.length; i++) {
        if (regEx.test(array1[i]) || array1[i] === "") {
            array1.splice(i,1);
            i--
        } else {
            array1[i] = parseInt(array1[i]);
        }
    }
    ////////////////////////////////SECOND QUESTION
    rl.question("\nPlease enter your second array: ", (arr2) => {
            var array2 = arr2.trim().replace(/\[|\]| /g, "").split(","),
                arr2modified = array2,
                regEx = /[a-z]|'|"/g;
            for (let i = 0; i < array2.length; i++) {
                if (regEx.test(array2[i]) || array2[i] === "") {
                    array2.splice(i,1);
                    i--
                } else {
                    array2[i] = parseInt(array2[i]);
                }
            }
            //The diffrences
            for (let i = 0; i < arr1modified.length; i++) {
                for (let j = 0; j < arr2modified.length; j++) {
                    if (arr2modified[j] == arr1modified[i]) {
                        arr1modified.splice(i, 1);
                        arr2modified.splice(j, 1);
                        i--;
                        j--;
                    } 
                }
            }
            diffrence = diffrence.concat(...arr1modified, ...arr2modified);
            console.log(`\nThe values that only one array had were ${diffrence}.`);
            rl.close()
    });
})