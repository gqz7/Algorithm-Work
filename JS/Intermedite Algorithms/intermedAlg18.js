function truthCheck(collection, pre) {
    // Is everyone being true?
    let truths = 0;
    for (let i = 0; i < collection.length; i++) {
      if (collection[i][pre]) {
          console.log(true, truths);
          truths++
      }
    
    }
    if (truths == collection.length) {
        console.log("All Truthy");
        
        return true
    } else {
        console.log("Somethin's false");
        
        return false
    }
  }
  
  truthCheck([{"user": "Tinky-Winky" }, {"user": "Dipsy", "sex": "male"}, {"user": "Laa-Laa", "sex": "female"}, {"user": "Po", "sex": "female"}], "sex");
  