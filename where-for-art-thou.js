// Make a function that looks through an array of objects (first argument) and returns an array of all objects that have matching name and value pairs (second argument). Each name and value pair of the source object has to be present in the object from the collection if it is to be included in the returned array.


    //   let searchObjValuesArr = Object.values(collection[i]);  
    //   let searchObjKeysArr = Object.keys(collection[i]);
    //   console.log( `Object from array`, collection[i], `\n Source Object`, source);


function whatIsInAName(collection, source) {

  let arr = []; //found objects/ matched objects

  let srcObjValues = Object.values(source);  
  let srcObjKeys = Object.keys(source); 

  // Only change code below this line

  for (let i = 0; i < collection.length; i++) {
      
      let testPassed = true;

      //logic to compare, key value pairs exist, each of the key/values of the src obj

      //object.prototype.hasOwnProperty('keyname') return a boolean

      for (let j = 0; j < srcObjValues.length && testPassed; j++) {

        // console.log(srcObjKeys[j]);

        // console.log(  collection[i][srcObjKeys[j]]);

          if ( !(collection[i].hasOwnProperty(srcObjKeys[j]) && collection[i][srcObjKeys[j]] === srcObjValues[j]) ) { //does it include the key, does the value match

                // console.log('test failed', collection[i]);

              testPassed = false;
              //fail the test
            
          } 

      }      

    //   console.log(searchObjValuesArr, srcObjValues, '\n' , searchObjKeysArr, srcObjKeys);
      

      //ofa and src match, I want to push the matched object to 'arr' 

      if (testPassed) {
          //push the object

          arr.push(collection[i])

        //   console.log(collection[i], 'has passed');
          
      }
      
  }


  // Only change code above this line
  console.log(arr);
  
  return arr;
}


// whatIsInAName([{ first: "Romeo", last: "Montague" }, { first: "Mercutio", last: null }, { first: "Tybalt", last: "Capulet" }], { last: "Capulet" })

// whatIsInAName([{ "apple": 1 }, { "apple": 1 }, { "apple": 1, "bat": 2 }], { "apple": 1 })

whatIsInAName([{ "apple": 1, "bat": 2 }, {"apple": 3, "bat": 2}, { "bat": 2 }, { "apple": 1, "bat": 2, "cookie": 2 }], { "apple": 1, "bat": 2 })

// whatIsInAName([{ "apple": 1, "bat": 2 }, { "apple": 1 }, { "apple": 1, "bat": 2, "cookie": 2 }], { "apple": 1, "cookie": 2 })

// whatIsInAName([{ "apple": 1, "bat": 2 }, { "apple": 1 }, { "apple": 1, "bat": 2, "cookie": 2 }, { "bat":2 }], { "apple": 1, "bat": 2 })

// whatIsInAName([{"a": 1, "b": 2, "c": 3}], {"a": 1, "b": 9999, "c": 3})