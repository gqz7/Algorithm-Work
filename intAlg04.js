const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      }),

      lineBr = '_______________________________________________';


console.log(lineBr + '\nWelcome to Javascript Object Storage\n' + lineBr);
menu()




function menu() {
    
    rl.question('Would you like to...\n1). Search for an object\n2). Create an object\n3). Take inventory of object\n4). Exit the program\n\nEnter a number for selection: ',
    (ans) => {

        switch (ans) {
            case '1':

            break;
            case '2':

            break;
            case '3':

            break;
            case '4':
                ETP()
            break;
            

        }
    })
}


function ETP() {

    console.log('\n\nThe program will now exit...');
    rl.close()
    
}