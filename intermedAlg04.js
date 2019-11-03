function whatIsInAName(collection, source) {
    // What's in a name?
    var arr = [];
    // Only change code below this line
    for (let i = 0; i < collection.length; i++){
        let key = Object.keys(collection[i]),
            value = Object.values(collection[i]),
            sourceKey = Object.keys(source),
            sourceValue = Object.values(source),
            includes = 0;
        
    for (let j = 0; j < key.length; j++) {
        for (let k = 0; k < sourceKey.length; k++) {
            if (key[j] == sourceKey[k] && value[j] == sourceValue[k] ) {
               includes++
    
            }
        }
       
    }
    if (includes == sourceKey.length) {
        arr.push(collection[i])
    }
    }
    
  
    // Only change code above this line
    console.log(arr);
    
    return arr;
  }
  
whatIsInAName([{ "apple": 1, "bat": 2 }, { "bat": 2 }, { "apple": 1, "bat": 2, "cookie": 2 }], { "apple": 1, "bat": 2 });