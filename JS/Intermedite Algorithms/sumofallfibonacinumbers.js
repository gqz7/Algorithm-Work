let readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });


rl.question('Enter a number\nNum: ', (num) => {

    console.log('\nFibonacci Sequence');
    

    let prevNum = 0,
        fibNum = 1,
        nextnum = 0;
        sum = 0;

    // process.stdout.write(prevNum, ",", fibNum);

    while (nextnum <= num) {

        nextnum = prevNum + fibNum;

        prevNum = fibNum;

        fibString = fibNum.toString(10);

        process.stdout.write(` ${fibString},`);
        // console.log(fibNum);

        sum += fibNum;

        fibNum = nextnum;

    }

    console.log('\n\nFibonacci Sum:', sum);
    

    rl.close();
        
})