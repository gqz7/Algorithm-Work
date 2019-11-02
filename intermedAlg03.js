//using the arguments object i am able to moddify the array and delete elements based on arguments after index 0
function destroyer() {
    var args = [];
    //pushes only the arguments after the array into 'args'
    for (let i = 1; i < arguments.length; i++) {
        args.push(arguments[i]);
    }
    //creates a loop for the length of the array we want to modify
    for (let i = 0; i < arguments[0].length; i++) {
        //loops through all the elements to get rid of while itterating through each element of the main array
        args.forEach(destroy => {
            if (arguments[0][i] === destroy) {
                //when it finds a match it splices it out of the argument itself, but then goes back on index as to not skip over an element
                arguments[0].splice(i,1);
                i--
            }
        });
        
    }
    console.log(arguments[0]);
    
    return arguments[0];
  }
  
  destroyer(["possum", "trollo", 12, "safari", "hotdog", 92, 65, "grandma", "bugati", "trojan", "yacht"], "yacht", "possum", "trollo", "safari", "hotdog", "grandma", "bugati", "trojan"); //expected output 12,92,65
  