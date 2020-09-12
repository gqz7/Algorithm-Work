//21.
/* This is the order in which Javascript searches for an objects methods when called upon 

function Animal() { }
Animal.prototype.eat = function() {
  return "nom nom nom";
};
function Bird() { }

// Inherit all methods from Animal
Bird.prototype = Object.create(Animal.prototype);

// Bird.eat() overrides Animal.eat()
Bird.prototype.eat = function() {
  return "peck peck peck";
};

var duck = new Bird();
THEN
duck.eat() ---- will return peck peck peck
    
    duck => Is eat() defined here? No.
    Bird => Is eat() defined here? => Yes. Execute it and stop searching.
    Animal => eat() is also defined, but JavaScript stopped searching before reaching this level.
    Object => JavaScript stopped searching before reaching this level.
*/

function Bird() { }

Bird.prototype.fly = function() { return "I am flying!"; };

function Penguin() { }
Penguin.prototype = Object.create(Bird.prototype);
Penguin.prototype.constructor = Penguin;

Penguin.prototype.fly = function() {return "Alas, this is a flightless bird."; };

let penguin = new Penguin();
console.log(penguin.fly()); //expected console output is "Alas, this is a flightless bird."

//22.
//Method 'mixin`s' are really easy and effienct ways to add methods to two or more objects that dont have the same constructor class/protoype
let bird = {
    name: "Donald",
    numLegs: 2
  };
  
  let boat = {
    name: "Warrior",
    type: "race-boat"
  };
  
  // Add your code below this line
  let glideMixin = function(obj) {
    obj.glide = function() {
      console.log("ssswwwwwssh");
  
    }
  }
  
  glideMixin(bird);
  glideMixin(boat);
  //This will add the method 'glide' to any objects that are called as an argument of 'glideMixin'
  //23.
  //so-called private object variables are created when a varible is created within the scope of just the object, in this case the variable cant be changed or overridden by just objName.property = data;
  function Bird() {
    let weight = 42;
     this.getWeight = function(){
         console.log(weight);
    };
   
   }
   
let ducky = new Bird();
ducky.getWeight();