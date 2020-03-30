function sumFibs1(num, odd) {

    let sum = odd? 1 : 0,
        fib = 1,
        lastNum = 1,
        nextNum;
  
    while (fib < num) {

        if (fib % 2 != 0 && odd) {
            console.log(fib);
            
            sum += fib
        } else if (fib % 2 == 0 && !odd) {
            console.log(fib);
            
            sum += fib
        }
        
        nextNum = fib + lastNum;

        lastNum = fib;

        fib = nextNum;
        
    }

    return sum
}

//creates fibonacci tree to
function sumFibs2(num) {

    if (num <= 1) {
        return num
    }
    // console.log(num);
    return sumFibs2(num-1) + sumFibs2(num-2);
    
}

// for (let index = 0; index < 50; index++) {
    
//     let position = index;

//     console.log(`Fibonacci Number At Position ${position} is, ${(sumFibs2(position))}`);

    
// }

function findFibAtPos(fibSquencePosition) {

    let fib = 1,
        lastNum = 0,
        nextNum;

        for (let i = 0; i < fibSquencePosition; i++) {

            console.log(BigInt(lastNum), i+1); 
            
            nextNum = fib + lastNum;

            lastNum = fib;

            fib = nextNum;
            
        }

        return lastNum
        

}

findFibAtPos(777)
