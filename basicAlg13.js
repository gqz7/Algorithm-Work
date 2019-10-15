function getIndexToIns(arr, num) {
    // function and sort method rearanging Array in accending order
    arr.sort((a, b) => {return a-b}); 
        
    if(arr.length == 0){
        arr.push(num);
        console.log(num, arr);
        return 0
    }
    //for loop compares the 'num' value to check its index within the accending array
        for (var i = 0; i < arr.length; i++){
                if ( num > arr[i] && i == arr.length - 1) {
                    
                    arr.push(num);
                    num = i + 1;
                    
                    console.log(num, arr);
                    return num;
               
                } else if (num > arr[i]){
                   
                } else {
                    num = i;
                    console.log(num);    
                    return num;
            }
            console.log(num, arr); 
    }
}
  getIndexToIns([ 2, 5, 10, 15 ], 12);