var readline = require('readline'),
    rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

 function title_case() {
    rl.question("Enter a sentence to be tile cased, an example of title case; 'This Is My Title'\n", (sentc) => {
        var titleArr = [],
            titleCase = "";

        titleArr = sentc.toLowerCase().trim().split(" ");
        
        for (let i = 0; i < titleArr.length; i++) {
           titleArr[i] = titleArr[i][0].toUpperCase() + titleArr[i].substring(1, titleArr[i].length);
           titleCase = titleCase.concat(titleArr[i], " ");
        }

       console.log(`Your title cased sentence is:\n-------\n${titleCase}\n----\nEnd Of Program...`);
       rl.close();

    });
}
title_case();