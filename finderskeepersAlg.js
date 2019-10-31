function findElement(arr, func) {
    let num;
    num = arr.filter( func );
    console.log(num);
  }
  findElement([1, 3, 5, 8, 9, 10], num => num % 2 === 0);
  