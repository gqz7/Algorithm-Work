let readline = require('readline'),
    rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
    });


rl.question('How wide would you like the staircase to be?\nNumber: ', (inputNumber) => {
    // console.log(inputNumber);
    inputNumber = parseInt(inputNumber);
    let floorLength = 14, jumpLength = 7;


    create_stairs(inputNumber, floorLength, jumpLength);
    
    rl.close();
    
});

function create_stairs(num, floorL, jumpL) {

    for (let i = 0; i <= num; i++) {
            
        let whiteSpace = " ", hashtag = "#", floor = "_";

        if (i == 0 ) {

            console.log(whiteSpace.repeat(num + floorL + jumpL - 1) + "<]");

        } else if ( i == num) {

            console.log(floor.repeat(floorL) + hashtag.repeat(num) + floor.repeat(jumpL-1) + "[ ]" + floor.repeat(4));
            
        } else {

            console.log(whiteSpace.repeat(num - i + floorL) + hashtag.repeat(i) + whiteSpace.repeat(jumpL) + "|");
        }   
    }    
}