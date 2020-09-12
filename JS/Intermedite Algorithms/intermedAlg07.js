function myReplace(str, before, after) {
    str = str.split(" ");
    var uppercase = /[A-Z]/;
    if (uppercase.test(before[0])) {
      after = after[0].toUpperCase() + after.substring(1, after.length);
    }
    for (let i = 0; i < str.length; i++){
      if (str[i] == before){ 
        str.splice(i, 1, after);
      }
    }
    str = str.join(" ");
    console.log(str);
    
    return str;
  }
  
  myReplace("He is sleeping on the couch", "sleeping", "sitting")  