//FACTORAL OF NUM

var fnum = 1;
function factorialize(num){
    if(num == 0){
      return 1;
    }else{
    for(var i = 0; i < num - 1; i++){
      fnum = fnum * (num -i);
      console.log(fnum);
    }
      return fnum
      
    }
   
}

factorialize(10);
    
// call the function within the function
function factorialize(num) {
    if (num === 0) { return 1; }
    return num * factorialize(num-1);
  }
  factorialize(0);
    
  