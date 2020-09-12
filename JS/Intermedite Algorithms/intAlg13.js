//least common multiple

//INITAL VARIABLE DECLERATION //using the node module 'readline' to get user input
const readline = require('readline'),
      rl = readline.createInterface({
          input: process.stdin,
          output: process.stdout
      });

let currPNF = {};

console.log('Please enter two or more numbers seperated by spaces or commas. Your output will be the Least Common Multiple of those numbers.');

find_lcm()

function find_lcm() {
    
    
    rl.question('Numbers: ', (numbers) => {

        //the first step is to get the numbers the user wants to find the lcm for
        factors = numbers.replace(/ /g, ',').split(',').filter(num => {return !isNaN(parseInt(num))});

        if (factors.length < 2) {
            console.log('Invalid response, try again...\n\n');
            find_lcm()
            return
        }
        //once it is detirmined that there are at least two numbers to work with, we can find the prime factors for each number. 
        //the frequency will be calculated and only the max number of primes for each number factoring will be stored
        //ex. input: 24 300 --> primes of 24; 2, 2, 2, 3 -- primes of 300; 2, 2, 3, 5, 5. so to get the LCM you multiply 2,2,2,3,5,5. 
        //we do not add all the 2s or 3s together, just the highest frequency found in our tested numbers

        for (let i = 0; i < factors.length; i++) {

               let currentNumberFreq = factorialize(factors[i]);

            //    console.log(currentNumberFreq);
               
            //this object itterating loop checks if theres a higher frequency of each number in the new factor versus the current log of prime frequency. 
            //if the focus number is not yet in the currPNF object, then it will be added
            for (const key in currentNumberFreq) {
                if (currentNumberFreq[key] > currPNF[key] || currPNF[key] == undefined) {
                    
                    currPNF[key] = currentNumberFreq[key];
                    
                }
            }
           
            
        }
        
        // console.log(currPNF);

        //to find the lcm i simply itterate through the 'current prime number frequency' object and reduce the numbers to a single integer,
        // it could have been done easier with the reduce method but this algorithm does not store the primes in an array
        let lcm = 1;

        for (const key in currPNF) {

            lcm *= Math.pow( parseInt(key), currPNF[key]);

        }

        console.log(`\n\nThe Least Common Multiple of ${factors}: `, lcm);

        nav()
        
    })
}

//this function breaks down the users number input into its prime factors and returns an object that contains the frequency of each of the prime factors
function factorialize(num) {

    let primeFactor = 2,
        pFactorsArr = [];

    while (primeFactor <= num) {

        // console.log(num,  primeFactor, primeFactorArray);

        if (num % primeFactor == 0) { //if this returns true 'primeFactor is a factor of num'
            pFactorsArr.push(primeFactor); //therfore it can be pushed to the array of factors

            if (num ==  primeFactor) { //if the factor is also == num the loop must be broken

                primeFactor = num + 1;
                
            } else { //otherwise the loop can continue to further break down the number into more primes

                num = num / primeFactor;
                
            }

        } else { //if 'pf' is not a factor of num then the next number is checked
            primeFactor++
        }
        
    }

    //an object will be created to store how many times a number present in the pFactorsArr occur
    let numberFreq = {};

    for (let i = 0; i < pFactorsArr.length; i++) {
        
        if (numberFreq[pFactorsArr[i]]) {
            numberFreq[pFactorsArr[i]]++
        } else {
            numberFreq[pFactorsArr[i]] = 1;
        }
        
    }

    // console.log(numberFreq, pFactorsArr);

    //then this object is returned
    return numberFreq

} 

//navigation function that allows the user to end the program or loop through the program more than once
function nav() {
    
    rl.question('\n\nWould you like to exit to program or try again?\n(lcm/exit)\ninput: ', (answer) => {
        answer = answer.trim().toLowerCase().substring(0,1);

        if (answer == 'l') {

            console.log('Running the program once more...');
            currPNF = {};
            
            find_lcm()
            
        } else if (answer == 'e')  {

            console.log('Exiting the program, Thanks for using it!');
            rl.close()

        } else {
            console.log('That is not a vaild response, try again...\n\n\n');
            nav()
        }
    })
}