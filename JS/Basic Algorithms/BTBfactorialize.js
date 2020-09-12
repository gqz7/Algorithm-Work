var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

function factorialize() {
    //User Input
    rl.question('Enter a number and you output will be the product of each number equal to or less than your input number\nNumber: ', (num) => {
        num = parseInt(num);

        if (isNaN(num)) {
            console.log('That is not a number, please try to input again...\n\n\n');
            factorialize();
            
        } else {

            let factorial = 1;

            for (let i = 1; i <= num; i++) {
                factorial *= i;   
            }
            //makes number in scientific notation not as long and hard to read (almost all numbers above 10 will be in SN)
            factorial = factorial.toPrecision(4);

            //User Output
            console.log(`\nThe Factorial of ${num} is ${factorial}.\n`);
            
            rl.question('Do you want to try again?\(\'no\' to exit\): ', (yon) => {
                if (yon == 'no') {
                    console.log('\nThe program will not end...');
                    rl.close()

                } else {
                    console.log('The program will run once more...\n\n');
                    factorialize();

                }
            });
        }
    });
}
factorialize()