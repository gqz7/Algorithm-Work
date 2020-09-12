//truth check

function truthCheck(collection, pre) {

    let truth = true;

    collection.forEach(element => {

        if (!Boolean(element[pre])) {

            truth = false
            
        }
        
    });
    
    if (truth) return true;

    return false

}

let testArr = [{"user": "Tinky-Winky", "sex": "male", "age": 0}, {"user": "Dipsy", "sex": "male", "age": 3}, {"user": "Laa-Laa", "sex": "female", "age": 5}, {"user": "Po", "sex": "female", "age": 4}];

let testpre = "age"

console.log(truthCheck(testArr, testpre));