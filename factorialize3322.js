let total = 1
function factorialize(num) {

    console.log(num);
    
    if (num > 0) {
        total *= num
        return factorialize(num-1);
    } else {
        return total
    }

}

// console.log(
// factorialize(0)
// );


function factorialize2(num) {

    let factorial = 1;
    
    while (num > 0) {
        factorial *= num;
        num--
    }
    return factorial
}

// console.log(
// factorialize2(5)
// );

function factorialize3(num) {

    if (num == 0) {
        return 1
    } else {
        return num * factorialize3(num-1)
    }

}

console.log(
factorialize3(5)
);
