//take input of a mulitdimentional array and conver it into a single dimension array.

function steamrollArray(arr) {

    let sRollArr = [];
   
    for (let i = 0; i < arr.length; i++) {

        // console.log(arr[i]);
        
        if (arr[i].length != undefined) {
            
            for (let j = 0; j < arr[i].length; j++) {
               extract_data(arr[i][j]);
                
            }

        } else {
            sRollArr.push(arr[i]);
        }
        
    }

    function extract_data(element) {
        if (element.length == undefined) {
            sRollArr.push(element)
        } else {
            extract_data(element[0])
        }
    }

    console.log(sRollArr);
    
    
    return arr;
}
  
  steamrollArray([1, [[[4]]], [7,8,[9,10]]]);
  