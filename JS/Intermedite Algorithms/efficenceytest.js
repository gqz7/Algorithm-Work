//Require Vars

const fs = require('fs');

const readline = require('readline'),

      rl = readline.createInterface({
           input:process.stdin,
           output:process.stdout
      });
      
const { PerformanceObserver, performance } = require('perf_hooks');

//FUNCTION 1

function func1() {
    
}

//FUNCTION 2
function func2() {
    
}

//DATA

const ArrayData = [],

     IntData = 9999999999999,

     SentenceData = fs.readFileSync('./paragraphs.txt', 'utf8'),

     RanStringData = fs.readFileSync('./random.txt', 'utf8');

//PREFORMANCE TEST '


function preformTest(NumOfTest) {

     let AvgTime1, AvgTime2, TotalTime1 = 0, TotalTime2 = 0;

     //First Function Test
     for (let i = 0; i < NumOfTest; i++) {

          let start,end,timeTaken;

          start = performance.now();

          func1() //Enter Data In Params

          end = performance.now();

          timeTaken = end - start;

          TotalTime1 += timeTaken;
     }

     //Second Function Test
     for (let i = 0; i < NumOfTest; i++) {

          let start,end,timeTaken;

          start = performance.now();

          func2() //Enter Data In Params

          end = performance.now();

          timeTaken = end - start;

          TotalTime2 += timeTaken;          
     }

     AvgTime1 = TotalTime1/NumOfTest;
     AvgTime2 = TotalTime2/NumOfTest;

     console.log(`Average Time Taken For First Function: ${AvgTime1}\nAverage Time Taken For Second Function: ${AvgTime2}`);


}


rl.question('How many times would you like each function to be ran?\nNumber: ', (num) => {
     if (!isNaN(parseInt(num))) {

          num = parseInt(num)

          preformTest(num)
          
     } else {
          rl.close()
     }


})