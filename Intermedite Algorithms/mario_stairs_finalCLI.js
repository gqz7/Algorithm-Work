let readline = require('readline'),
    rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
    });



cli()
function cli() {
    
    rl.question('How wide would you like the staircase to be?\nNumber: ', (stairNumIn) => {
        
        stairNumIn = parseInt(stairNumIn);
        let floorLength = 14, jumpLength = 7;

        if (isNaN(stairNumIn) || stairNumIn < 1) {
            console.log("\nThat is not a vaild number, try again\n\n");
            cli();
            
        } else {
            rl.question('How wide would you like the jump to be?\nNumber: ', (jumpNumIn) => {
                jumpNumIn = parseInt(jumpNumIn);

                 if (isNaN(stairNumIn) || jumpNumIn < 1) {

                    console.log("\nThat is not a vaild number, try again\n\n");
                    cli();
                    
                 } else {

                     create_stairs(stairNumIn, floorLength, jumpNumIn);
        
                     rl.close();

                 }
            })
        }

    });
}

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