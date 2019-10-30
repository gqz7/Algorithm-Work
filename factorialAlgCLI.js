//this alg does factorials for both 
var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
 function factorial () {
rl.question("what number would you like the factorial of?\n", (num) => {
    var sumOfAll = 1
    num = parseInt(num);
    if (typeof num == "number") {
       
        if (num < 0) {
            for (let i = 0; i > num; num++) {
               
                
                sumOfAll *= num;        
            }
        } else {
            for (let i = num; i > 0; i--){
                sumOfAll *= i;
            }
        }
        console.log(sumOfAll);
        rl.close();
        
    } else {
        //this part does not work in CLI since parseInt is needed for command line input to be converted into number
     console.log("that is not a number")
     factorial()
    }
    
})

}
factorial();