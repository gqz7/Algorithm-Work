const readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    
spliceslice()
function spliceslice() {
    
    rl.question('First enter your array you would like to add anothers array data into.\nEach element should be seperated by ","\nArray 1: ', (array1) => {
        array1 = array1.replace(/ /g, '').split(',').filter(element => element != '');
    
        rl.question('Next you will enter another list of data you would like to add to the first array\nArray 2: ', (array2) => {
            array2 = array2.replace(/ /g, '').split(',').filter(element => element != '');

            rl.question(`At what element's end in the first array would you like to insert your second array?\nYour 1st array; ${array1}\nYour 2st array; ${array2}\nIndex: `, (index) => {
                index = parseInt(index);

                if (!isNaN(index)) {
                    array1.splice(index,0,...array2);
                
                    console.log(`______________________________________\nYour final array is;\n\n${array1}\n\______________________________________\n`);

                    rl.question('Would you like to try again?("no" to exit)\nInput: ', (yon) => {
                        yon = yon.trim().substring(0,1).toLowerCase();

                        if (yon == 'n') {
                            console.log('\n\nThe program will now end...');
                            rl.close()
                            
                        } else {
                            console.log('\nThe program will now start again...\n');
                            spliceslice()
                            
                        }

                    })

                } else {

                    console.log('-------------------------------\nYour index input was not a number, try the program again...\n-------------------------------\n');
                    spliceslice()
                    
                }

            })
            
        }) 
    })
}
