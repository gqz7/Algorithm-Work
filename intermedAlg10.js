function uniteUnique() {
    var array = [],
        finalArray = [];
    for(let i = 0; i < arguments.length; i++){
        array.push(arguments[i]);
    }

    for (let i = 0; i < array.length; i++) {
        for (let j = 0; j < array[i].length; j++) {
            if (!finalArray.includes(array[i][j])) {  
                finalArray.push(array[i][j]);

            }
        }
    }

    console.log(finalArray);
    return finalArray;
  }
  
  uniteUnique([1, 3], [5, 2, 1, 4], [2, 1,6,34]);
   