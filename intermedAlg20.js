var Person = function(firstAndLast) {
    // Complete the method below and implement the others similarly
    var fullName = firstAndLast;
    
    this.getFullName = () => {
        return fullName
    }
    this.getFirstName = () => {
        return fullName.split(" ").shift();
    }
    this.getLastName = () => {
        return fullName.split(" ").pop();
    }
    this.setFirstName = (first) => {
        fullName = first + " " + fullName.split(" ").pop();
        
    }
    this.setLastName = (last) => {
        fullName = fullName.split(" ").shift() + " " + last;
    }
    this.setFullName = (firstAndLast) => {
        fullName = firstAndLast;
    }

  };
  
  var bob = new Person('Bob Ross');
 bob.setFirstName("gabe");
